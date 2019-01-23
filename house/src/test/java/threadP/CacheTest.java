package threadP;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * <p>  </p>
 *
 * @author ly
 * @since 2019/1/18
 */
public class CacheTest {
    public static void main(String[] args) {
        cacheThreadPool();
    }
    public static void cacheThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i<100;i++){
            final int index = i;
            try{
                Thread.sleep(i*1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    sys(index);
                }
            });
        }
    }

    public static void sys(int index) {
        System.out.println("当前线程："+Thread.currentThread().getName()+"输出："+index);
    }
}
