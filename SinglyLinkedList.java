package rr;

public class SinglyLinkedList<E> {

    private int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    // 1. equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList<E> that = (SinglyLinkedList<E>) o;
        Node<E> p1 = this.head;
        Node<E> p2 = that.head;
        while (p1 != null && p2 != null) {
            if (!p1.element.equals(p2.element)) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null && p2 == null;
    }

    // 2. Second-to-last node
    public E getSecondToLast() {
        if (isEmpty() || size() < 2) {
            return null;
        }
        Node<E> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        return current.element;
    }

    // 3. Size without instance variable (using recursion)
    public int sizeRecursive() {
        return sizeRecursive(head);
    }

    private int sizeRecursive(Node<E> current) {
        if (current == null) return 0;
        return 1 + sizeRecursive(current.next);
    }

    // 4. Rotate (addLast(removeFirst()))
    public E rotate() {
        if (isEmpty()) return null;
        E removed = head.element;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            tail.next = head;
            tail = tail.next;
        }
        tail.next = null;
        return removed;
    }

    // 5. Concatenate two lists
    public static <E> SinglyLinkedList<E> concatenate(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2) {
        SinglyLinkedList<E> result = new SinglyLinkedList<>();
        result.head = list1.head;
        if (list1.tail != null) {
            list1.tail.next = list2.head;
        }
        result.tail = list2.tail;
        return result;
    }

    // 6. Reverse list (iterative with constant space)
    public void reverse() {
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            Node<E> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Existing methods (addFirst, addLast, removeFirst, getAll)
    // ... (implementations omitted for brevity)
}