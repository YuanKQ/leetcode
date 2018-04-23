/******************************
 * User: yuan
 * Date: 18-3-28 下午9:21
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    Queue<Integer> data = new LinkedList<>();
    Random r = new Random();
    public void consume() throws InterruptedException {
        synchronized (data){
            while (data.isEmpty()) {
                data.wait();
            }
            System.out.println("consume: " + data.poll() + "\tdata.size:" + data.size());
//            data.notifyAll(); // 通知生产者
        }
    }

    public void produce() throws InterruptedException {
        synchronized (data){
//            while (data.size() == 10){
//                System.out.println();
//                data.wait();
//            }
            Integer rn = new Integer(r.nextInt(10));
            data.offer(rn);
            System.out.println("produce: " + rn + "\tdata.size:" + data.size());
            data.notifyAll();
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            try {
                while (!Thread.interrupted())
                    consume();
            } catch (InterruptedException e) {
                System.out.println("Exception in Consumer.");
            }
        }


    }

    class Producer implements Runnable{
        @Override
        public void run() {
            try {
                while (!Thread.interrupted())
                    produce();
            } catch (InterruptedException e) {
                System.out.println("Exception in Producer.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        Main m = new Main();
        Producer p = m.new Producer();
        Consumer c = m.new Consumer();
        int repeat = 100;
        es.execute(p);
        es.execute(c);
        while (repeat -- >= 0)
           TimeUnit.MILLISECONDS.sleep(100);
        es.shutdown();
    }
}
