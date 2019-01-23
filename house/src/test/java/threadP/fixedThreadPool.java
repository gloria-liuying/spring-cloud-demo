package threadP;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/18
 */
public class fixedThreadPool {
    public static void main(String[] args) {
        fixedExecutePool();
    }
    public static void fixedExecutePool(){
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for(int i=1;i<15;i++){
        final int index = i;
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                sys(index);

            }
        });
    }}
    public static void sys(int index) {
        System.out.println("当前线程："+Thread.currentThread().getName()+"输出："+index);
    }
}
