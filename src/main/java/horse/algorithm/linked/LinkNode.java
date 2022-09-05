package horse.algorithm.linked;

public class LinkNode<E> {


    private Node<E> head;


    public static void main(String[] args) {
        LinkNode<String> linked = new LinkNode<>();
        linked.addLast("a");
        linked.addLast("b");
        linked.addLast("c");

        Node<String> next = linked.head;
        while (next != null) {
            System.out.print(next.data);
            next = next.next;

        }

    }

    protected void addLast(E data) {
        if (head == null) {
            head = new Node(data, null);
        }
        head.next = new Node(data, null);
    }

    public static class Node<E> {

        private E data;

        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
