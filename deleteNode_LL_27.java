public class deleteNode_LL_27 
{
    public class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val= val;
            this.next= null;
        }
    }    
    public void deleteNode(ListNode node)
    {
        node.val=node.next.val;
        node.next= node.next.next;
    }
}
