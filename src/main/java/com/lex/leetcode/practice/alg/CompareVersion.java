package com.lex.leetcode.practice.alg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 中等
 * 比较版本号
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/30 下午7:09
 */
public class CompareVersion {

    /**
     * 如果 version1 > version2 返回 1，
     * 如果 version1 < version2 返回 -1，
     * 除此之外返回 0
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {

        List<String> vl1 = Arrays.asList(version1.split("\\."));
        List<String> vl2 = Arrays.asList(version2.split("\\."));

        List<Integer> vil1 = toIntVersion(vl1);
        List<Integer> vil2 = toIntVersion(vl2);
        int ls1 = 0,ls2=0;
        int ll1 = vil1.size(),ll2 = vil2.size();
        while (ls1 < ll1 || ls2 < ll2){
            int v1Int = ls1 < ll1 ? vil1.get(ls1) : 0;
            int v2Int = ls2 < ll2 ? vil2.get(ls2) : 0;
            if(v1Int != v2Int){
                return v1Int > v2Int ? 1 : -1;
            }
            ls1++;
            ls2++;
        }
        return 0;
    }

    private List<Integer> toIntVersion(List<String> vl){
        List<Integer> list = new ArrayList<>();
        for(String str : vl){
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    public static void main(String[] args) {
        {
            CompareVersion cv = new CompareVersion();
            System.out.println(cv.compareVersion("1.01","1.001"));

            System.out.println(cv.compareVersion("1.0","1.0.0"));

            System.out.println(cv.compareVersion("1.0.1","1"));

            System.out.println(cv.compareVersion("7.5.2.4","7.5.3"));
        }
    }

}
