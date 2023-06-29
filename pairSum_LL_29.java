import java.util.LinkedList;
import java.util.Scanner;

public class pairSum_LL_29 
{ 
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int pairSum(ListNode head) 
    {
        int[] arr = new int[100000];
        int index = 0;
        while (head != null) 
        {
            arr[index++] = head.val;
            head = head.next;
        }
        int maxSum = 0;
        for (int i = 0; i < index / 2; i++) 
        {
            int twinSum = arr[i] + arr[index - 1 - i];
            if (twinSum > maxSum) 
            {
                maxSum = twinSum;
            }
        }
        System.gc();
        return maxSum;
    }
    public static void main(String[] args)
    {
        pairSum_LL_29  obj = new pairSum_LL_29 ();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();// create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) // input values for linked list
        {
            int element = scanner.nextInt();
            linkedList.add(element);
        }
        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        int result = obj.pairSum(head);
        System.out.print("The maximum twin value :"+ result );       
    }

        
}

