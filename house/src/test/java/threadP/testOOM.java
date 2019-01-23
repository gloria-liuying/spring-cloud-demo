package threadP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/18
 */
public class testOOM {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(new SubThread());
        }
    }
}
    class SubThread implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //do nothing
            }
        }
}
