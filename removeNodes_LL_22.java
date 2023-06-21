import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class removeNodes_LL_22 
{
     public class ListNode
     {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val=val;
            this.next= null;
        }
     } 
     public ListNode removeNodes(ListNode head) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int max = 0;
        int[] arr = new int[list.size()];
        //finding max from the end to include values into result
        for (int i = list.size() - 1; i >= 0; i--) {
            if (max <= list.get(i).val) {
                arr[i] = 1;
                max = list.get(i).val;
            }
        }
        boolean headSet = false;
        cur = head;
        //adding nodes to the result
        for (int i = 0; i < list.size(); i++) {
            if (arr[i] == 1) 
            {
                if (!headSet) {
                    headSet = true;
                    head = list.get(i);
                    cur = head;
                } else {
                    cur.next = list.get(i);
                    cur = cur.next;
                }
            }
        }
        cur.next = null;
        System.gc();
        return head;
    } 
    public static void main(String[] args)
    {
        removeNodes_LL_22 obj = new removeNodes_LL_22();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();// create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements in linked list ");
        int m = scanner.nextInt();

        System.out.println("Enter the elements :");
        for (int i = 0; i < m; i++) // input values for linked list
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

        head = obj.removeNodes(head);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
        linkedList.addFirst(temp.val);
        temp = temp.next;
        }

        for(int i= linkedList.size()- 1; i>=0; i--)
        {
            System.out.print(linkedList.get(i)+ " -> ");
        }
        System.out.println("null");
    }   
}
