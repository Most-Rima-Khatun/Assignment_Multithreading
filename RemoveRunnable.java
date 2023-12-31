package Problem_06;

import java.util.Random;

public class RemoveRunnable<E> implements Runnable
{
    private ArrayList<E> list;
    private int count;
    private final int DELAY = 10;
    private Random gen;

    public RemoveRunnable(ArrayList<E> list, int count)
    {
        this.list = list;
        this.count = count;
        this.gen = new Random();
    }

    public void run()
    {
        try
        {
            for(int i = 1; i <= count; i++)
            {
                System.out.print("[Remove...]");
                if(this.list.size() == 0)
                {
                    this.list.remove(0);
                }
                else
                {
                    int index = gen.nextInt(this.list.size());
                    this.list.remove(index);
                }
                System.out.println("[Size: " + this.list.size() + "]");
                Thread.sleep(DELAY);
            }
        }
        catch(InterruptedException e) { e.printStackTrace(); }
    }
}

