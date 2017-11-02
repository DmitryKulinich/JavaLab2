package Exp7;

import java.util.*;

public class DoubleLinkedList<T> {
	private class Node {
        T    data;
        Node next;
        Node previous;
        Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
	
    private Node first = null;
    private Node last  = null;
    private int  count = 0;
    
    public void add(T elem) {
        Node newNode = new Node(elem, null, null);
        if (last == null) {
            first = newNode;
        }
        else {
            last.next = newNode;
        }
        last = newNode;
        count++;
    }
    
    public void removeFirstOccurrence(T value) {
        if (first != null && first.data.equals(value)) { 
            first = first.next; 
            first.previous = null;
            count--; 
        }
        else if (last != null && last.data.equals(value)) {
        	last = last.previous;
        	last.next = null;
        	count--;
        }
        else {
            Node link = first;
            while (link.next != null) {
                if (link.next.data.equals(value)) {
                    link.next = link.next.next;
                    link.next.previous = link;
                    count--;
                }
                if (link.next == null) {
                    last = link;
                    break;
                }
                link = link.next;
            }
        }
    }
    
    public final int size() {
        return count;
    }
    
    @Override
    public String toString() {
        String s = "size = " + size() + "\n[";
        Node link = first;
        while (link != null) {
            s += link.data;
            link = link.next;
            if (link != null) {
                s += ", ";
            }
        }
        s += "]\n";
        return s;
    }
}
