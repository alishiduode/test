package com.example.demo.excute;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 测试异步线程池
 * @author aaa
 */
@Lazy
@Component
public class CsAsyncExecute {

    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 10, 10,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);


    public ThreadPoolExecutor getPoolExecutor() {
        return poolExecutor;
    }

}
