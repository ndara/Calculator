/* Jonathan Cheruvelil jcheruve
   Nishanth Dara ndara
   October 8th, 2015
   Project 1   */

import java.util.EmptyStackException;

//MyStack is a generic linked list implementation of a stack
//  The stack is a data structure in which a newly added element will be the first susceptible element to be removed
public class MyStack <T>
{

    //A node is used to represent each item in the stack and a pointer to the next item in the stack
    private class Node
    {
        //This stores the generic item
        public T item;

        //This is a pointer to the next node in the stack
        public Node next;

        //This constructor needs a generic item and a reference to the next node in a stack
        public Node(T item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }

    //This node is the first node in the stack (at the top)
    private Node first;

    //This constructor initializes MyStack, starts it off as an empty stack
    public MyStack()
    {
        this.first = null;
    }

    //This method takes in an item, makes a node out of it, and puts it on the top of the stack
    public void push(T thing)
    {
        Node node = new Node(thing, first);
        first = node;
    }

    //This method returns the item that was on the top of the stack
    public T pop()
    {
        if(!(isEmpty()))
        {
            T value = first.item;
            first = first.next;
            return value;
        }
        else
        {
            throw new EmptyStackException();
        }
    }

    //This item shows the user what is on the top of the stack without removing it from the stack
    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return first.item;
        }
    }

    //This method tells the user if the stack is empty or not
    public boolean isEmpty()
    {
        return(first == null);
    }
}
