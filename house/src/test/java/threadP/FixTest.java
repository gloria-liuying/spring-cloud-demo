package threadP;

import java.util.concurrent.*;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/18
 */
public class FixTest {

    public static void main(String[] args) {
        scheduleThreadPool();
    }
    public static void scheduleThreadPool(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for(int i = 0;i<100;i++){
            final int index = i;
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    sys(index);
                }
            },3, TimeUnit.SECONDS);
        }
    }

    public static void sys(int index) {
        System.out.println("当前线程："+Thread.currentThread().getName()+"输出："+index);
    }
}
