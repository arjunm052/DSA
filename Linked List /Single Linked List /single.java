import java.util.*;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

public class single {

    public static void printList(Node head) {
        Node ptr = head;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }

    public static void recursivePrintList(Node head) {
        if(head==null){
            return;
        }

        System.out.println(head.data);
        recursivePrintList(head.next);
    }

    public static Node insertAtBeginning(Node head,int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        return head;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node ptr = head;
        if(head==null){
            head = new Node(data);
            return head;
        }

        while(ptr.next!=null){
            ptr=ptr.next;
        }
        Node temp = new Node(data);
        ptr.next = temp;
        return head;
    }

    public static Node deleteAtBeginning(Node head) {
        if(head==null){
            return head;
        }
        head=head.next;
        return head;
    }

    public static Node deleteAtEnd(Node head) {
        if(head==null || head.next==null){
            head = null;
            return head;
        }

        Node ptr = head;
        while(ptr.next.next!=null){
            ptr=ptr.next;
        }
        ptr.next=null;
        return head;
    }

    public static Node insertAtPosition(Node head, int pos, int data) {
        Node temp = new Node(data);
        if(pos==1){
          temp.next = head;
          head = temp;
          return head;  
        }
        Node curr = head;
        for(int i = 1; i<pos-1 && curr!=null;i++){
            curr=curr.next;
        }
        if(curr==null){
            return head;
        }
        temp.next=curr.next;
        curr.next = temp;
        return head;
    }

    public static Node sortedInsert(Node head, int data) {
        Node temp = new Node(data);
        if(head==null){
            return temp;
        }
        if(data<head.data){
            temp.next = head;
            head = temp;
            return head;
        }

        Node curr = head;
        while(curr.next!=null && curr.next.data<data){
            curr=curr.next;
        }
        temp.next = curr.next;
        curr.next=temp;
        return head;
    }

    public static void findingMiddle(Node head) {
        if(head==null){
            return;
        }
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.data);
    }

    public static void printNthFromEnd(Node head,int n) {
        if(head==null){
            return;
        }
        Node first = head;
        for(int i=0;i<n;i++){
            if(first==null){
                return;
            }
            first=first.next;
        }

        Node second = head;
        while(first!=null){
            second=second.next;
            first=first.next;
        }
        System.out.println(second.data);
    }

    public static Node reverseIterative(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public static Node reverseRecursive(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node rest_head = reverseRecursive(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next = temp1;
        temp1.next = temp2;
        // printList(head);
        head = insertAtBeginning(head, 8);
        head = insertAtBeginning(head, 5);
        head = insertAtBeginning(head, 2);

        head = insertAtEnd(head, 60);
        head = insertAtEnd(head, 70);

        head = deleteAtBeginning(head);

        head =  deleteAtEnd(head);

        head = insertAtPosition(head, 1, 1);
        head = insertAtPosition(head, 4, 97);

        head = sortedInsert(head, 58);

        // findingMiddle(head);

        // printNthFromEnd(head, 2);

        // head = reverseIterative(head);
        // head = reverseRecursive(head);

        printList(head);


        
    }
}
