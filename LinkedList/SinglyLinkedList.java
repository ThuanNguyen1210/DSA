class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class SinglyLinkedList {
    Node head;

    Node getHead() {
        return this.head;
    }

    void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertAtIndex(int data, int idx) {
        int tempIdx = 0;
        Node prev = this.head;
        Node cur = this.head;

        while (cur != null && tempIdx != idx) {
            prev = cur;
            cur = cur.next;
            tempIdx++;
        }

        Node newNode = new Node(data);
        prev.next = newNode;
        newNode.next = cur;
    }

    boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    boolean searchRecursive(int data, Node node) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        return searchRecursive(data, node.next);
    }

    void removeElementAtPosition(int idx) {
        if (this.head == null) {
            return;
        }

        if (idx == 0) {
            head = head.next;
            return;
        }


        int tempIdx = 0;
        Node tempNode = this.head;
        Node prevNode = null;
        while (tempNode != null && tempIdx != idx) {
            prevNode = tempNode;
            tempNode = tempNode.next;
            tempIdx ++;
        }
        if (tempIdx != idx) {
            return;
        }

        prevNode.next = tempNode.next;
        tempNode.next = null;
    }

    void reverse() {
        Node prev = null, next, curr = this.head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    void print() {
        System.out.print("List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtTail(0);
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);

        list.removeElementAtPosition(3);

        list.print();
    }
}
