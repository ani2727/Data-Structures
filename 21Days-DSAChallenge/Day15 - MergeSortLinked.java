//Problem Link: https://bit.ly/3tG5GXU 

/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    static Node findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node merge(Node head1,Node head2)
    {
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        while(head1 != null && head2 != null)
        {
            if(head1.data <= head2.data) {
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
            
        }
        if(head1 != null) temp.next = head1;
        else temp.next = head2;
        
        return dummy.next;
    }
    
    static Node mergeSort(Node head)
    {
        if(head == null || head.next == null) return head;
        
        Node middle = findMiddle(head);
        Node righthead = middle.next;
        middle.next = null;
        Node lefthead = head;
        
        lefthead = mergeSort(lefthead);
        righthead = mergeSort(righthead);
        
        return merge(lefthead,righthead);
    }
}

