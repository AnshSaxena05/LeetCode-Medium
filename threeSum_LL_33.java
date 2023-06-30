import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class threeSum_LL_33 
{
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);// sorting the given array
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++)//check addition till last index of num 
         // array. 
        {// initialize index j,k
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {//keep the i value constant and move the j and k index 
                int sum = nums[i] + nums[j] + nums[k];//sum the values of i,j,k
                if (sum == target) {// if sum == target 
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));// add all the index
                    j++;//to hashset(s) in the form of array list.
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        output.addAll(s);// add all the hashset values to arraylist(output)   
        return output;// because return type is list.
    }    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        // Call the threeSum method
        List<List<Integer>> result = threeSum(nums);

        // Print the result
        System.out.println("Triplets with sum 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
