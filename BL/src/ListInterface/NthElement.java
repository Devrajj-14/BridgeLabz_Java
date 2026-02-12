package ListInterface;

import java.util.NoSuchElementException;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class NthElement {

    public static <T> T nthFromEnd(Node<T> head, int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be >= 1");

        Node<T> fast = head;
        Node<T> slow = head;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) throw new NoSuchElementException("n is larger than list length");
            fast = fast.next;
        }

        // Move both until fast hits end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow == null) throw new NoSuchElementException("Empty list");
        return slow.data;
    }

    public static void main(String[] args) {
        // Build: A -> B -> C -> D -> E
        Node<String> head = new Node<>("A");
        head.next = new Node<>("B");
        head.next.next = new Node<>("C");
        head.next.next.next = new Node<>("D");
        head.next.next.next.next = new Node<>("E");

        System.out.println(nthFromEnd(head, 2)); // D
    }
}
