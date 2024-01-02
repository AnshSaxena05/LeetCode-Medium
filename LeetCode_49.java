import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49
{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(String x: strs)
        {
            char arr[]=x.toCharArray();//convert each word of strs[] array into character array.
            Arrays.sort(arr);//sort the char array
            String word=new String(arr);//convert thr string array into word
            if(!h.containsKey(word))//check if the sorted is already present or not.
            {
                h.put(word,new ArrayList<>());//if sorted word not present , then add the sorted word to map-"h"
            }                                 // along with the new ArrayList to add the words of strs[] array
            h.get(word).add(x);//add the respective words from str[] array into Newly created ArrayList for that "sorted word"-key
        }
        return new ArrayList<>(h.values());
    }
    public static void main(String[] args) {
        LeetCode_49 solution = new LeetCode_49();

        // Example input array of strings
        String[] inputArray = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the groupAnagrams method
        List<List<String>> result = solution.groupAnagrams(inputArray);

        System.out.println(result);
    }
}
