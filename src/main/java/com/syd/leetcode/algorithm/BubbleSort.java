package com.syd.leetcode.algorithm;

import java.util.Arrays;

public class BubbleSort {

    private static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; ++i) {
            for (int j = 0; j < length - 1 - i ; ++ j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 7, 9, 5, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

