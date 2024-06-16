package ggg;

import java.util.concurrent.*;

/**
 * 线程池
 * @Author jpl
 * @date 2024/4/21&下午10:28
 */
public class fff {
    /**
     * 线程池的注意事项

     * 1、临时线程什么时候创建?
     *      新任务提交时发现核心线程都在忙，任务队列也满了，并且还可以创建临时线程，此时才会创建临时线程。

     * 2、什么时候会开始拒绝新任务?
     *      核心线程和临时线程都在忙，任务队列也满了，新的任务过来的时候才会开始拒绝任务。
     */

    public static void main(String[] args) {


        /**
         * @param corePoolSize     指定线程池的核心线程的数量
         * @param maximumPoolSize  指定线程池的最大线程数量
         * @param keepAliveTime    指定临时线程的存活时间
         * @param unit             指定临时线程存活的时间单位(秒、分、时、天)
         * @param workQueue        指定线程池的任务队列
         * @param threadFactory    指定线程池的线程工厂
         * @param handler          指定线程池的任务拒绝策略(线程都在忙，任务队列也满了的时候，新任务来了该怎么处理)
         */
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());


        /**
         * workQueue  指定线程池的任务队列 5种，1:LinkedBlockingQueue,2:SynchronousQueue,3:LinkedBlockingDeque,4:PriorityBlockingQueue,5:DelayQueue
         * 常用的有界队列
         * 1、ArrayBlockingQueue                                      有界队列，满了会阻塞
         * 2、LinkedBlockingQueue                                    接近于无界队列，满了会阻塞
         */



            /**
             *                                新任务拒绝策略

             * 策略                                              详解
             * ThreadPoolExecutor.AbortPolicy                   丢弃任务并抛出RejectedExecutionException异常。是默认的策略
             * ThreadPoolExecutor.DiscardPolicy:                丢弃任务，但是不抛出异常 这是不推荐的做法
             * ThreadPoolExecutor.Discard0ldestPolicy           抛弃队列中等待最久的任务 然后把当前任务加入队列中
             * ThreadPoolExecutor.CallerRunsPolicy              由主线程负责调用任务的run()方法从而绕过线程池直接执行
             */




        /**
                              ExecutorService的常用方法

         * 方法名称                                                   说明
         * void execute(Runnable command)                           执行 Runnable 任务
         * Future<T>submit(Callable<T>task)                         执行 Ca11able 任务，返回未来任务对象，用于获取线程返回的结果
         * void shutdown()                                          等全部任务执行完毕后，再关闭线程池!
         * List<Runnable> shutdownNow()                             立刻关闭线程池，停止正在执行的任务，并返回队列中未执行的任务
         *
         */






    }

}
