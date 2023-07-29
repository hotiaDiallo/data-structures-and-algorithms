package com.linkedlist;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;

    //addLast
    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
    }

    //addFirst
    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    //indexOf
    public int indexOf(int item){
        int index = 0;
        Node curr = first;
        while (curr != null){
            if(curr.value == item) return index;
            index++;
            curr = curr.next;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    //deleteFirst
    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
    }

    //deleteLast
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        last = getPrevious(last);
        if (last != null) last.next = null;
    }

    private Node getPrevious(Node node){
        var curr = first;
        while (curr != null){
            if (curr.next == null) return curr;
            curr = curr.next;
        }
        return null;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private class Node {
        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}