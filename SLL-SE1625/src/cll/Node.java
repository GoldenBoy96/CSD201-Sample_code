package cll;

import dll.*;

public class Node <T>{
    T value;
    Node next;
    Node pre;
    
    Node() {}
    Node(T el) {
        this.value = el;
    }
    Node(T el, Node nt, Node pr) {
        this.value = el;
        this.next = nt;
        this.pre = pr;
    }
    //el = element
}