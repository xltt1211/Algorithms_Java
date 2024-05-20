package LeetCode;

import java.util.HashMap;

/***
 * 题目描述
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 你可以按任意顺序返回答案。

 示例 1：
 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

 示例 2：
 输入：nums = [3,2,4], target = 6
 输出：[1,2]

 示例 3：
 输入：nums = [3,3], target = 6
 输出：[0,1]

 提示：
 2 <= nums.length <= 104
 -109 <= nums[i] <= 109
 -109 <= target <= 109

 * 解题思想
 * https://www.bilibili.com/video/BV1AA411B7XV/?spm_id_from=333.337.search-card.all.click&vd_source=535474508e5ca95a86f0603784e2b70d
 *
 *
 */
public class LeetCode0001_两数之和 {
    //方法一 暴力枚举
    public static int[] Sum2(int[] arr, int target) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //方法二，哈希表
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if(hashMap.get(other) != null) {
                arr[0] = hashMap.get(other);
                arr[1] = i;
            }
            hashMap.put(nums[i],i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {8};
        int target = 8;
        // Sum1(arr, target);

        int[] test1 = Sum2(arr1, target);
//        for (int i : arr1) {
//            System.out.println(i);
//        }

        int[] test2 = twoSum(arr, target);
        for (int i : test2) {
            System.out.println(i);
        }

    }
}
