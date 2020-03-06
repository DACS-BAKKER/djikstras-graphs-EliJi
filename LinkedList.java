/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 10-15-19
 *
 *  Description: Simplified Linked List. The only methods implmented are those
 *               needed for reverse linked list.
 **************************************************************************** */

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>  {

    //this covers LinkedList() constructor
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        if(first == null) {
            first = new Node();
            first.item = item;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node last = new Node();
            last.item = item;
            temp.next = last;
        }
    }

    public Iterator<Item> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    //iteratively reverse
    public void iReverse(){
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            //step 1 in diagram
            next = current.next;
            //step 2 in diagram
            current.next = prev;
            //step 3 in diagram
            prev = current;
            current = next;
        }
        //step 5 in digram
        first = prev;
    }

    //recursively reverse
    public void rReverse(){
        if(isEmpty()) return;
        else rReverseWrapper(first);
    }

    private void rReverseWrapper(Node current){
        //BASE CASE
        if(current.next==null) {
            first = current;
            return;
        }
        //do the n - 1
        rReverseWrapper(current.next);
        //STEP CASE
        //reverse pointer
        current.next.next = current;
        //remove pointer
        current.next = null;
    }
}