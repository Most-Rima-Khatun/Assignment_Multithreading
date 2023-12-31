package Problem_06;

import java.util.Random;

public class AddRunnable<E> implements Runnable
{
    private ArrayList<E> list;
    private int count;
    private E element;
    private final int DELAY = 10;
    private Random gen;

    public AddRunnable(ArrayList<E> list, int count, E element)
    {
        this.list = list;
        this.count = count;
        this.element = element;
        this.gen = new Random();
    }

    public void run()
    {
        try
        {
            for(int i = 1; i <= count; i++)
            {
                System.out.print("[Add...]");
                if(this.list.size() == 0)
                {
                    this.list.add(0, element);
                }
                else
                {
                    int index = gen.nextInt(this.list.size());
                    this.list.add(index, element);
                }
                System.out.println("[Size: " + this.list.size() + "]");
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException e) { e.printStackTrace(); }
    }
}

