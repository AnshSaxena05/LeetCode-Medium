import java.util.*;

public class flatten_DLL_25 
{
    class Node 
    {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    };
    public Node flatten(Node head) {
        Stack<Node> stk = new Stack<>();// created a empty stack
        Node curr =  head;
        if(curr==null)// check if curr value is null or not, if null then return null.
            return null;
        while(curr.next !=null  || curr.child!=null)
        {
            while(curr.child==null)
            {// this while block checks the final condition to exit the while loop, where curr.next 
             // is null and curr.child is also null.
                if(curr.next ==null)
                    break;
               curr= curr.next; 
            }
            if(curr.next!=null)
            {// this if block breaks the connection between 2 blocks and add the curr.next to stack
                curr.next.prev = null;
                stk.add(curr.next);
                curr.next = null;
            }
            if(curr.child!=null)
            {// this if block connects the child block to the main stream( curr block ) and then 
             // assign the curr pointer to child  
                Node temp = curr.child;
                temp.prev = curr;
                curr.child = null;
                curr.next = temp;
                curr = temp;
            }
        }
       while(!stk.isEmpty()) 
       {// this while block add all the remaining list node to the main stream 
           Node rem =  stk.pop();
           rem.prev = curr;
           curr.next = rem;
           while(curr.next!=null)
           {
               curr = curr.next;
           }
       }
        return head; 
    } 
    public static void main(String[] args) {
        flatten_DLL_25  flattenDLL = new flatten_DLL_25 ();
        Scanner scanner = new Scanner(System.in);

        // Input the length of the list
        System.out.print("Enter the length of the list: ");
        int length = scanner.nextInt();

        Node head = null;
        Node curr = null;

        // Input the values of the list nodes and their child nodes
        for (int i = 0; i < length; i++) {
            System.out.print("Enter the value of node " + (i + 1) + ": ");
            int value = scanner.nextInt();

            Node newNode = flattenDLL.new Node();
            newNode.val = value;
            newNode.prev = null;
            newNode.next = null;
            newNode.child = null;

            System.out.print("Enter the value of the child node for node " + (i + 1) + ": ");
            int childValue = scanner.nextInt();

            if (childValue != -1) {
                Node childNode = flattenDLL.new Node();
                childNode.val = childValue;
                childNode.prev = null;
                childNode.next = null;
                childNode.child = null;
                newNode.child = childNode;
            }

            if (head == null) {
                head = newNode;
                curr = newNode;
            } else {
                curr.next = newNode;
                newNode.prev = curr;
                curr = curr.next;
            }
        }

        Node result = flattenDLL.flatten(head);

        // Output the flattened list
        System.out.println("Flattened list:");
        while (result != null) {
            System.out.print(result.val + " ");
            if (result.child != null) {
                System.out.print(result.child.val + " ");
            }
            result = result.next;
        }

        scanner.close();
    }
}
