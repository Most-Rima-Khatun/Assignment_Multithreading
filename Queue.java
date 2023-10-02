package Problem_04;

import java.time.LocalTime;
import java.util.NoSuchElementException;

public class Queue<E>
{
    private Node<E> first;
    private Node<E> last;
    private int currentSize;
    private final int MAX_SIZE = 5;

    public Queue()
    {
        this.first = null;
        this.last = null;
        this.currentSize = 0;
    }

    public int getCurrentSize()
    {
        return this.currentSize;
    }

    public E getFirst()
    {
        if(this.first == null)
        {
            throw new NoSuchElementException();
        }
        return this.first.data;
    }

    public E getLast()
    {
        if(this.last == null)
        {
            throw new NoSuchElementException();
        }
        return this.last.data;
    }


    public synchronized void add(E element) throws InterruptedException
    {
        while(this.currentSize >= MAX_SIZE)
        {
            wait();
        }

        if(this.currentSize < 1)
        {
            Node<E> newNode = new Node<>();
            newNode.data = element;
            newNode.next = null;

            this.first = newNode;
            this.last = newNode;
        }
        else
        {
            Node<E> newNode = new Node<>();
            newNode.data = element;
            newNode.next = null;

            this.last.next = newNode;
            this.last = newNode;
        }
        this.currentSize++;
        System.out.println("[" + this.currentSize + "]:"  + LocalTime.now().toString());
        notifyAll();
    }


    public synchronized E remove() throws InterruptedException
    {
        while(this.currentSize <= 0)
        {
            wait();
        }

        E firstInQueue = this.first.data;
        this.first = this.first.next;
        this.currentSize--;
        System.out.println("[" + this.currentSize + "]:" + LocalTime.now().toString());

        notifyAll();
        return firstInQueue;
    }


    public boolean isEmpty()
    {
        return (this.first == null) && (this.last == null);
    }


    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append("[");
        Node<E> currentNode = this.first;
        while(currentNode != null)
        {
            s.append(currentNode.data.toString() + ", ");
            currentNode = currentNode.next;
        }
        return s.substring(0, s.length() - 2) + "]";
    }


    class Node<T>
    {

        public T data;
        public Node<T> next;


    }
}
