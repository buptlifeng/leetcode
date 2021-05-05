package com.lex.leetcode.practice.dp;

import com.lex.leetcode.practice.Base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minesweeper/
 * 中等
 *
 * @author lifeng
 */
public class UpdateBoard extends Base {

    // 方向向量
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * 深度优先
     * 1.先判断第一个点是否为雷，如果是，直接退出
     * 2.如果当前的点附近都没有雷，标记为B，然后递归遍历周边的点（至少周边8个），直到没有新的块挖出来（条件4）；
     * 3.如果当前的点附近有雷，则标记雷的数量；
     * 4.如果本次没有新的块挖出来，则退出；
     * <p>
     * 时间：O(nm)
     * 时间：O(nm)
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoardDfs(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int flen = board.length, slen = board[0].length;
        int cnt = 0;
        // 遍历周边8个点
        for (int i = 0; i < 8; i++) {
            int dx = x + dirX[i];
            int dy = y + dirY[i];
            if (dx < 0 || dx >= flen || dy < 0 || dy >= slen) {
                continue;
            }
            if (board[dx][dy] == 'M') {
                cnt++;
            }
        }

        // 如果有雷
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            // 如果没有，继续遍历周边的元素
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int dx = x + dirX[i];
                int dy = y + dirY[i];
                if (dx < 0 || dx >= flen || dy < 0
                        || dy >= slen || board[dx][dy] != 'E') {
                    continue;
                }
                // 递归周边的点
                dfs(board, dx, dy);
            }
        }
    }

    public char[][] updateBoardBfs(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    private void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int flen = board.length, slen = board[0].length;
        boolean[][] visited = new boolean[flen][slen];
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = 0, dx = cur[0], dy = cur[1];
            for (int i = 0; i < 8; i++) {
                int ix = dx + dirX[i];
                int iy = dy + dirY[i];
                if (ix < 0 || ix >= flen || iy < 0 || iy >= slen) {
                    continue;
                }
                if (board[ix][iy] == 'M') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                board[dx][dy] = (char) (cnt + '0');
            } else {
                // 如果没有，先设置为B，然后继续遍历周边的元素
                board[dx][dy] = 'B';
                for (int i = 0; i < 8; i++) {
                    int ix = dx + dirX[i];
                    int iy = dy + dirY[i];
                    if (ix < 0 || ix >= flen || iy < 0 || iy >= slen
                            || visited[ix][iy] || board[ix][iy] != 'E') {
                        continue;
                    }
                    queue.offer(new int[]{ix, iy});
                    visited[ix][iy] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        {
            UpdateBoard solution = new UpdateBoard();
            char[][] board = new char[][]{
                    {'E', 'E', 'E', 'E', 'E'},
                    {'E', 'E', 'M', 'E', 'E'},
                    {'E', 'E', 'E', 'E', 'E'},
                    {'E', 'E', 'E', 'E', 'E'}
            };
            solution.updateBoardDfs(board, new int[]{3, 0});
            solution.printArray(board);
        }

        {
            UpdateBoard solution = new UpdateBoard();
            char[][] board = new char[][]{
                    {'E', 'E', 'E', 'E', 'E'},
                    {'E', 'E', 'M', 'E', 'E'},
                    {'E', 'E', 'E', 'E', 'E'},
                    {'E', 'E', 'E', 'E', 'E'}
            };
            solution.updateBoardBfs(board, new int[]{3, 0});
            solution.printArray(board);
        }

        {
            UpdateBoard solution = new UpdateBoard();
            char[][] board = new char[][]{
                    {'B', '1', 'E', '1', 'B'},
                    {'B', '1', 'M', '1', 'B'},
                    {'B', '1', '1', '1', 'B'},
                    {'B', 'B', 'B', 'B', 'B'}
            };
            solution.updateBoardDfs(board, new int[]{1, 2});
            solution.printArray(board);
        }

        {
            UpdateBoard solution = new UpdateBoard();
            char[][] board = new char[][]{
                    {'B', '1', 'E', '1', 'B'},
                    {'B', '1', 'M', '1', 'B'},
                    {'B', '1', '1', '1', 'B'},
                    {'B', 'B', 'B', 'B', 'B'}
            };
            solution.updateBoardBfs(board, new int[]{1, 2});
            solution.printArray(board);
        }
    }

}
