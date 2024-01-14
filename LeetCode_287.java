import java.util.Arrays;

public class LeetCode_287 {//// Boolean array approach
    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int i : nums) {
            if (arr[i])
                return i;
            arr[i] = true;
        }
        return -1;
    }
    /*
     * public int findDuplicate(int[] nums) { ////Floyd's cycle finding algorithm or
     * Hare-Tortoise algorithm
     * int slow=0,fast=0;
     * while(true)// check cycle in the array
     * {
     * slow=nums[slow];
     * fast=nums[nums[fast]];
     * if(slow==fast) break;
     * }
     * slow=0;
     * while(slow!=fast)
     * {
     * slow=nums[slow];
     * fast=nums[fast];
     * }
     * return fast;
     * }
     */

    public static void main(String[] args) {
        LeetCode_287 solution = new LeetCode_287();

        // Example usage:
        int[] nums1 = { 1, 3, 4, 2, 2 };
        int result1 = solution.findDuplicate(nums1);
        System.out.println("Array nums1: " + Arrays.toString(nums1));
        System.out.println("Duplicate in nums1: " + result1); // Expected output: 2

        int[] nums2 = { 3, 1, 3, 4, 2 };
        int result2 = solution.findDuplicate(nums2);
        System.out.println("Array nums2: " + Arrays.toString(nums2));
        System.out.println("Duplicate in nums2: " + result2); // Expected output: 3

        int[] nums3 = { 1, 1 };
        int result3 = solution.findDuplicate(nums3);
        System.out.println("Array nums3: " + Arrays.toString(nums3));
        System.out.println("Duplicate in nums3: " + result3); // Expected output: 1
    }
}
