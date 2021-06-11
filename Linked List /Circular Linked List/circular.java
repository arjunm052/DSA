import java.util.*;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

public class circular {
    public static void printList(Node head) {
        if(head==null){
            return;
        }
        Node ptr = head;
        do{
            System.out.print(ptr.data+"\t");
            ptr=ptr.next;
        }while(ptr!=head);
    }

    public static Node insertAtBeginning(Node head,int data) {
        Node temp = new Node(data);
        if(head==null){
            temp.next=temp;
            return temp;
        }
        temp.next = head.next;
        head.next = temp;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return head;
    }

    public static Node insertAtEnd(Node head,int data) {
        Node temp = new Node(data);
        if(head==null){
            temp.next=temp;
            return temp;
        }
        temp.next = head.next;
        head.next = temp;
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        return temp;
    }

    public static Node deleteHead(Node head) {
        if(head==null || head.next==null){
            return null;
        }
        head.data=head.next.data;
        head.next=head.next.next;
        return head;
    }

    public static Node deleteKthNode(Node head,int k) {
        if(head==null){
            return null;
        }
        if(k==1){
            return deleteHead(head);
        }
        Node curr = head;
        for(int i = 0;i<k-2;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }


    public static void main(String[] args) {
        Node head=null;
        head = insertAtBeginning(head, 3);
        head = insertAtBeginning(head, 2);
        head = insertAtBeginning(head, 1);

        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 6);

        // head = deleteHead(head);
        head = deleteKthNode(head, 3);

        printList(head);
    }
}
