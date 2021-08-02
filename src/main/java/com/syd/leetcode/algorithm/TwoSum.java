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

    /**
     * 标签：哈希映射
     * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)O(n2)
     * 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     * 如果最终都没有结果则抛出异常
     * 时间复杂度：$$
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
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
