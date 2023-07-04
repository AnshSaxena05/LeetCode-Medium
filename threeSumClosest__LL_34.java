import java.util.Arrays;
import java.util.Scanner;

public class threeSumClosest__LL_34 
{
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int curSum = 0;
        
        for (int i = 0; i <nums.length - 2; i++) {
            int left = i + 1;
            int right=nums.length - 1;

            while (left<right) {
                curSum = nums[i] + nums[left] + nums[right];
                if (curSum==target) {
                    return curSum;
                } 
                else if (Math.abs(target - curSum) < Math.abs(target - closestSum)) {
                    closestSum=curSum;
                }
                if (curSum <= target) {
                    left += 1;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left += 1;
                    }
                } else {
                    right -= 1;
                }
            }
        }
        System.gc();
        return closestSum;
    }
     public static void main(String[] args) 
     {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter the target sum: ");
        int k = scanner.nextInt();
        scanner.close();

        // Call the threeSum method
        threeSumClosest__LL_34 obj= new threeSumClosest__LL_34();
        int result = obj.threeSumClosest(nums, k );

        // Print the result
        System.out.println("The sum that is closest to the target is:"+ result);
    }
}    

