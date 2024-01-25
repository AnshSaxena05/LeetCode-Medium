public class LeetCode_189 {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private static void swap(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        long startTime = System.nanoTime();
        rotate(nums, k);
        long endTime = System.nanoTime();

        // Print the rotated array
        System.out.println("Rotated Array:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Calculate and print time complexity
        long elapsedTime = endTime - startTime;
        System.out.println("Time Complexity: " + elapsedTime + " nanoseconds");

        System.out.println("Space Complexity: O(1)");
    }
}
