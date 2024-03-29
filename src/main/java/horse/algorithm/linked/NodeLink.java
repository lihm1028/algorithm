package horse.algorithm.linked;

public class NodeLink {

    private Node head;

    private int size;

    public static void main(String[] args) {
        final NodeLink nodeLink = new NodeLink();
        nodeLink.addHeadNode(2);
        nodeLink.addHeadNode(3);
        nodeLink.addHeadNode(4);
        nodeLink.addLastNode(5);
        nodeLink.printNode();
//        nodeLink.reverseNode();
        nodeLink.reverseNode2();
        System.out.println("");
        nodeLink.printNode();


    }

    public void addHeadNode(Integer data) {
        if (head == null) {
            Node node = new Node();
            node.data = data;
            node.next = null;
            this.head = node;
        } else {
            Node node = new Node();
            node.data = data;
            node.next = head;
            head = node;

        }
        size++;

    }

    public void addLastNode(Integer data) {
        if (head == null) {
            Node node = new Node();
            node.data = data;
            node.next = null;
            head = node;

        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            Node node = new Node();
            node.data = data;
            node.next = null;
            last.next = node;

        }
        size++;


    }

    public void printNode() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? "," : ""));
            current = current.next;
        }

    }


    /**
     * 双指针反转
     */
    public void reverseNode() {
        Node prev = null;
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;

    }

    /**
     * 4,3,2,5
     *
     * 3,4
     * 2,3,4
     * 5,2,3,4
     *
     *
     */
    public void reverseNode2() {
        final Node reverse = reverse(null, head);
        head = reverse;
    }

    public Node reverse(Node prev, Node current) {
        // 如果当前节点已经是最后一个了，那么最后一个了就返回上一个节点
        if (current == null) {
            return prev;
        }
        //3
        Node temp = current.next;
        //上一个节点
        current.next = prev;

        // 下一次递归，
        prev = current;
        current = temp;
        return reverse(prev, current);
    }

    private static class Node {
        private Integer data;
        private Node next = null;

        public Node() {


        }
    }


}
