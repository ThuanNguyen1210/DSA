class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            this.head = this.tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void insertAtIndex(int data, int idx) {
        Node newNode = new Node(data);
        int tmpIdx = 0;
        Node temp = this.head;
        
        while (temp.next != null && tmpIdx != idx){
            temp = temp.next;
            tmpIdx++;
        }

        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;

    }

    void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void printBackward() {
        Node temp = this.tail;
        while (temp != null) {
            System.err.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtIndex(6, 2);
        
        list.printBackward();
    }
}
