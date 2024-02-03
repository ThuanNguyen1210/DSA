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
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtIndex(4, 1);

        list.print();

        list.reverse();

        list.print();

        int searchElement = 3;
        System.out.println(
                String.format("Is exist %d in list: ", searchElement)
                        + list.searchRecursive(searchElement, list.getHead()));

    }
}
