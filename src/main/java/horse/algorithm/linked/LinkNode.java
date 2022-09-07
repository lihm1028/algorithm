package horse.algorithm.linked;

public class LinkNode<E> {


    private Node<E> head;


    public static void main(String[] args) {
        LinkNode<String> linked = new LinkNode<>();
//        linked.addLast("a");
//        linked.addLast("b");
//        linked.addLast("c");


        linked.addLast2("1");
        linked.addLast2("2");
        linked.addLast2("3");
        linked.addLast2("4");

        linked.reverseAll();

        Node<String> next = linked.head;
        while (next != null) {
            System.out.print(next.data);
            next = next.next;

        }

    }


    private void addLast2(E data) {
        Node<E> node = new Node(data, null);
        if (head == null) {
            head = node;
        } else {
            head.addNode(node);
        }
    }

    private void reverseAll() {
        Node<E> node = reverse(null, head);
        head = node;
    }


    private Node<E> reverse(Node<E> prev, Node<E> current) {
        if (current == null) {
            return prev;
        }
        Node<E> temp = current.next;
        current.next = prev;

        // 下一次递归
        prev = current;
        current = temp;
        return reverse(prev, current);
    }


    /**
     * 将新元素添加到链表链表头部
     *
     * @param data
     */
    protected void addFirst(E data) {
        /**
         * 1.先构建新节点
         * 2.判断head节点是不是null，如果空链表，将新节点设置为head。
         * 否则：先将head.next赋值给current.next,再将current设置为head节点
         *
         */
        Node current = new Node(data, null);
        if (head == null) {
            head = current;
            return;
        }
        current.next = head.next;
        head = current;

    }

    protected void addLast(E data) {
        Node current = new Node(data, null);
        if (head == null) {
            head = current;
            return;
        }

        if (head.next == null) {
            head.next = current;
            return;
        }
        Node<E> next = head.next;
        while (next != null && next.next != null) {
            next = next.next;
        }
        next.next = current;

    }

    public static class Node<E> {

        private E data;

        private Node<E> next;


        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public void addNode(Node<E> node) {
            if (this.next == null) {
                this.next = node;
            } else {
                this.next.addNode(node);
            }
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
