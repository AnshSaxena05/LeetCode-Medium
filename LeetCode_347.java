import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> h= new HashMap<>();
        for(int x:nums)
        {
            h.merge(x,1,Integer::sum);//for geting frequency
        }
        List<Integer> list=new ArrayList<>(h.keySet());
        list.sort((a,b)-> h.get(b) - h.get(a));//sort in decending order
        int res[]= new int[k];
        for(int i=0;i<k;i++)
        res[i]=list.get(i);
        return res;
    }
    public static void main(String[] args) {
        LeetCode_347 solution = new LeetCode_347();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
