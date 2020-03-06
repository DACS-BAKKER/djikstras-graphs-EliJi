/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 10-15-19
 *  Description: Generic Iterable Implementation of a Stack
 **************************************************************************** */

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>  {

    //this covers Stack() constructor
    private Node first;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        //step 1 in diagram
        Node oldFirst = first;
        //step 2 in diagram
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        //step 3 in diagram
        size++;
    }

    public Item pop() {
        //step 1 in diagram
        Item item = first.item;
        //step 2 in diagram
        first = first.next;
        //step 3 in diagram
        size--;
        //step 4 in diagram
        return item;
    }

    public int size(){
        return size;
    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

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
}