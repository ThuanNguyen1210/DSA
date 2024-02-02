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
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        // add case if not empty list
    }
}
