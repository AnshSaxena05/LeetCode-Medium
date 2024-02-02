public class LeetCode_918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxNormal = kadane(nums, n);
        
        if (maxNormal < 0)
            return maxNormal;
        
        int arraySum = 0;
        
        for (int i = 0; i < n; i++) {
            arraySum += nums[i];
            nums[i] = -nums[i];
        }
        
        int maxCircular = arraySum + kadane(nums, n);
        return Math.max(maxCircular,maxNormal);
    }
    
    public int kadane(int arr[], int n) {
        int maxEnding = arr[0];
        int result = arr[0];
        
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }
        
        return result;
    }
    public static void main(String[] args)
    {
        LeetCode_918 solution = new LeetCode_918();
        int[] nums = {1, -2, 3, -2};
        int result = solution.maxSubarraySumCircular(nums);
        System.out.println("Output: " + result);
    }
}
