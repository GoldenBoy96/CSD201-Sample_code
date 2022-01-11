package sll;

public class Node <T>{
    T value;
    Node next;
    
    Node() {}
    Node(T el) {
        this.value = el;
    }
    Node(T el, Node nt) {
        this.value = el;
        this.next = nt;
    }
    //el = element
}