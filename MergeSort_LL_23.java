import java.util.LinkedList;
import java.util.Scanner;

public class MergeSort_LL_23 
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val) 
        {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode sortList(ListNode head) 
    {
    if (head == null || head.next == null)
      
        return head;
        
    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) 
    {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    prev.next = null;
    
    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) 
  {
    ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) 
    {
      if (l1.val < l2.val) 
      {
        p.next = l1;
        l1 = l1.next;
      } 
      else 
      {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
  }    
  public static void main(String[] args)
    {
        MergeSort_LL_23  obj = new MergeSort_LL_23();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();// create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements :");
        for (int i = 0; i < n; i++) // input values for linked list
        {
            int element = scanner.nextInt();
            linkedList.add(element);
        }
        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = 0; i <= linkedList.size() - 1; i++) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        head = obj.sortList(head);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
        linkedList.addFirst(temp.val);
        temp = temp.next;
        }

        for(int i=linkedList.size() - 1; i >= 0 ; i--)
        {
            System.out.print(linkedList.get(i)+ " -> ");
        }
        System.out.println("null");
    }  
}
