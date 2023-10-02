package Problem_02;

public interface Stack<E>
{
    void push(E element);

    E pop() throws InterruptedException;

    boolean isEmpty();

    int size();
}
