

class Solution
{
    Node reverseList(Node head)
    {
        Node prev = null;
        Node curr = head;
        Node temp = head;
        while(curr != null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
