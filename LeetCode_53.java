public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int maxending=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            maxending=Math.max(maxending+nums[i], nums[i]);
            res=Math.max(res,maxending);
        }
    return res;
    }
    public static void main(String[] args) {
        LeetCode_53 solution = new LeetCode_53();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + solution.maxSubArray(nums1));

        // Test case 2
        int[] nums2 = {5, -6, 3, 4, -2, 1, 7, -8};
        System.out.println("Max subarray sum: " + solution.maxSubArray(nums2));
    }
}
