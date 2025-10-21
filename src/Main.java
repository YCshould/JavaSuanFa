import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread myThread = new MyThread("MyThread",8);
//        myThread.start();
        // 创建一个固定大小的线程池，大小为 3
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                3,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());   //一般想将这部分代码写到配置类中，方便管理线程池的配置
        String wu = "wu";
        String xue = "xue";
        Future<?> submit = threadPoolExecutor.submit(() -> {
            test(xue);
        });
        threadPoolExecutor.shutdown();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        CompletableFuture.runAsync(() -> {
            test(wu);
        }, threadPoolExecutor);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //Future<Object>可接收方法的返回值，如果方法没有返回值
        Future<Object> submit1 = executorService.submit(() -> {
            while (true) {
                Thread.sleep(1000);
                test(wu);
            }

        });
        // 等待线程池中的线程执行完毕,要是submit1没有执行完毕，则会一直阻塞,submit1.get()后面不会执行
        submit1.get();
        boolean done = submit1.isDone();
        System.out.println("is_done:" + done);
        executorService1.submit(() -> {
//            int i=0;
//            while(true){
//                Thread.sleep(1000);
//                System.out.printf("输出的累加值为:%d%n",i++);
//            }
            try {
                test1(wu);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("----------------");

//        test("wu---------------");
//        System.out.println("回到主线程----------------------------");
//        executorService1.shutdown();//关闭线程池并不是让线程池中的线程立即停止
//      executorService.shutdown();
    }

    public static void test(String name) {
        {
            System.out.println("test" + " " + "hello world" + " " + name);
        }
    }

    public static void test1(String name) throws InterruptedException {
        {
            while (true) {
                Thread.sleep(1000);
                System.out.println("test1" + "hello world" + " " + name);
            }

        }
    }
}

class MyThread extends Thread {

    public MyThread(String name, int priority) {
        super(name);
        super.setPriority(priority);
    }


    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }
}

class P {
    private String name;
    private int age;

    public void b(String name, int age) {
        this.name = "zhangsan";
        this.age = 18;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
