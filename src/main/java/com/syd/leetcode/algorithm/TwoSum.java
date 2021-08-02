package com.syd.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 时间复杂度：O(N^2)O(N2)，其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)O(1)。
     */
    public static int[] twoSum(int[] nums,int target){
        for(int i = 0 ; i < nums.length ; i ++){
            int num = nums[i];
            for(int j = i + 1 ; j < nums.length ; j ++){
                if(num + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSumByMap(int[] nums,int target){
        Map<Integer,Integer> valueAndIndexMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            int num = nums[i];
            if(valueAndIndexMap.containsKey(target - num)){
                return new int[]{valueAndIndexMap.get(num),i};
            }
            valueAndIndexMap.put(num,i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,3,5};
        int[] arr = twoSum(nums,10);
        int[] arrMap = twoSumByMap(nums,10);
        System.out.println(arr);
    }

}
