import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data=x;
        next=null;
        prev=null;
    }
}


public class Double {
    public static void printList(Node head) {
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println("\n");
    }

    public static Node insertAtHead(Node head,int data) {
        Node temp = new Node(data);
        temp.next=head;
        if(head!=null){
            head.prev=temp;
        }
        return temp;
    }

    public static Node insertAtEnd(Node head,int data) {
        Node temp = new Node(data);
        if(head==null){
            return temp;
        }
        Node curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }

    public static Node reverseList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node prev = null, curr = head;
        while(curr!=null){
            prev=curr.prev;
            curr.prev=curr.next;
            curr.next=prev;
            curr=curr.prev;
        }
        return prev.prev;
    }

    public static Node deleteHead(Node head) {
        if(head==null || head.next==null){
            return null;
        }
        else {
            head=head.next;
            head.prev=null;
            return head;
        }
    }

    public static Node deleteEnd(Node head) {
        if(head==null || head.next==null){
            return null;
        }
        Node curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.prev.next=null;
        return head;
    }


    public static void main(String[] args) {
        Node head=null;
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);

        head = deleteHead(head);
        head = deleteEnd(head);

        printList(head);
        // head = reverseList(head);
        // printList(head);

    }
}
