package list;

public class Node {
    int value;
    Node next;
    
    Node() {}
    Node(int el) {
        this.value = el;
    }
    Node(int el, Node nt) {
        this.value = el;
        this.next = nt;
    }
    //el = element
}