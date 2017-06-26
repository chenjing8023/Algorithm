import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 17-3-26.
 */
public class Son  extends Father{
    public int age;
    private static Son sample;
    public Son(){

    }
    public static Son getSon(){
        return Sample.son;
    }
    private static class Sample{
        private static final Son son =new Son();
    }
    public static void main (String[] args) {
       Son son=new Son();
        AtomicInteger a=new AtomicInteger(10);
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("a","a");
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }


    public void run() {
        storage.pop();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }


    public void run() {
        Product product = new Product("090505105", "电话");
        storage.push(product);
    }

}

/**
 * 产品类
 */
class Product {
    private String id;// 产品id
    private String name;// 产品名称

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String toString() {
        return "(产品ID：" + id + " 产品名称：" + name + ")";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

/**
 *仓库
 */
class Storage {
    // 仓库容量为10
    private Product[] products = new Product[10];
    private int top = 0;

    // 生产者往仓库中放入产品
    public synchronized void push(Product product) {
        try {
            while (true){
                if (top == products.length) {
                    try {
                        wait();//仓库已满，等待
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                //把产品放入仓库
                products[top++] = product;
                System.out.println(Thread.currentThread().getName() + " 生产了产品"
                        + product);
                notifyAll();//唤醒等待线程
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    // 消费者从仓库中取出产品
    public synchronized Product pop() {
        try {
            while (true){
                if (top == 0) {
                    try {
                        wait();//仓库空，等待
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

                //从仓库中取产品
                --top;
                Product p = new Product(products[top].getId(), products[top].getName());
                products[top] = null;
                System.out.println(Thread.currentThread().getName() + " 消费了产品" + p);
                notifyAll();//唤醒等待线程

                wait();
                return p;

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return null;

    }
}