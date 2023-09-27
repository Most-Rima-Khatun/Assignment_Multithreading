package Problem1;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

public class LIstThreadRunner {
    public static void main(String[] args) {
        List<Integer> lst = new LinkedList<>();
        final int VAL = 100;
        final int REPETATIONS = 50;
        final int THREADS = 100;
        for(int i = 1; i <= THREADS; i++)
        {
            AddRunnable<Integer> a = new AddRunnable<>(lst,VAL,REPETATIONS);
            RemoveRunnable<Integer> r = new RemoveRunnable<>(lst,VAL,REPETATIONS);

            Thread at = new Thread(a);
            Thread rt = new Thread(r);

            at.start();
            rt.start();
        }
    }
}
