import java.util.*;

public class swapNodes_LL_21 
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val = val;
            this.next=null;
        }
    }
    public ListNode swapNodes(ListNode head, int k) 
    {

        ListNode pointer =head;
        int size = 1;

        while(size++ < k)
        {
            pointer = pointer.next;
        }
        ListNode first= pointer;
        ListNode second = head;
        while( pointer.next != null)
        {
            pointer= pointer.next;
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
    public static void main(String[] args)
    {
        swapNodes_LL_21 obj = new swapNodes_LL_21();
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

        System.out.print("Enter the value of node value to swap ");
        int n = scanner.nextInt();

        scanner.close();
        
         // Convert LinkedList to ListNode
        ListNode head = null;
        for (int i = linkedList.size() - 1; i >= 0; i--) 
        {
        ListNode newNode = obj.new ListNode(linkedList.get(i));
        newNode.next = head;
        head = newNode;
        }

        head = obj.swapNodes(head , n);

        // Convert ListNode back to LinkedList for printing
        linkedList.clear();
        ListNode temp = head;
        while (temp != null) {
        linkedList.addFirst(temp.val);
        temp = temp.next;
        }

        for(int i=0; i < linkedList.size(); i++)
        {
            System.out.print(linkedList.get(i)+ " -> ");
        }
        System.out.println("null");
    }
}
