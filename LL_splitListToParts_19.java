import java.util.*;

public class LL_splitListToParts_19 
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
    public ListNode[] splitListToParts(ListNode head, int k) 
    {
        ListNode curr= head;
        int length = 0;//variable to store calculated length of given linked list

        while( curr != null)// finding the length of the given list node.
        {
            curr=curr.next;
            length +=1;
        }

        int rem= 0;

        // length of given listnode is greatter then k (partition factor)
        if( length>= k) //Eg. 5%2 = 1
            rem = length%k;

        // finding the legth of subparts we need to divide (int)5/2 = 2
        int cutlength = length/k;
        
        // again starting from head
        curr = head;
        ListNode arr[] = new ListNode[k];// create ListNode array
        ListNode temp = curr;
        int len =0;
        int x=0;// x to check when we reach k
        while (curr != null)
        {
            len = rem>0?cutlength +1 :cutlength;
            rem = rem -1; 

            while( curr .next != null && len-- > 1)// reach till end till len condition is not satisfied....  if the len is compared (len>1), then len value is decremented. 
            {
                curr = curr.next;
            }

            // save the new head
            ListNode newHead =  curr.next;
            curr.next = null;
            // store the curr subarray to the result
            arr[x] = temp;
            // move to the next subarray 
            temp =  newHead;
            curr = newHead;
            x++;
        }
        
        //System.out.print(length);
        return arr;
    }     
    public static void main(String[] args)
    {
        LL_splitListToParts_19 obj = new LL_splitListToParts_19();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();// create a new linked list
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of linked list ");
        int m = scanner.nextInt();

        System.out.println("Enter the elements :");
        for (int i = 0; i < m; i++) // input values for linked list
        {
            int element = scanner.nextInt();
            linkedList.add(element);
        }
        System.out.print("Enter the number of divisions required ");
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
        ListNode arr[] = new ListNode[n];

        arr = obj.splitListToParts(head, n);


        for (int i = 0; i < arr.length; i++) 
        {
            ListNode node = arr[i];
            while (node != null) 
            {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}