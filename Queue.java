package Problem_05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue<E>
{
    private BlockingQueue<E> q;

    public Queue(int maxCapacity)
    {
        this.q = new ArrayBlockingQueue<>(maxCapacity);
    }

    public int getCurrentSize()
    {
        return q.size();
    }

    public void add(E element) throws InterruptedException
    {
        q.put(element);
    }

    public E remove() throws InterruptedException
    {
        return q.take();
    }

    public boolean isEmpty()
    {
        return (q.size() == 0);
    }
}

