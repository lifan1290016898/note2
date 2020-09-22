package org.demo.juc;

import org.demo.juc.model.Student;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestPriorityBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Student> studentQueue = new PriorityBlockingQueue<>();
        // add(): 如果队列中有剩余空间则添加后返回true, 否则抛出异常
        studentQueue.add(new Student(3));
        // offer(): 队列中有剩余空间, 在指定的时间内添加后返回true, 否则返回false
        studentQueue.offer(new Student(1), 2, TimeUnit.SECONDS);
        // put(): 向队列中添加元素时, 如果队列中没有空间,那么线程就会一直等待,直到添加到队列中
        studentQueue.put(new Student(2));

        System.out.println(studentQueue);
        System.out.println(studentQueue.poll(2, TimeUnit.SECONDS));
        System.out.println(studentQueue);
        System.out.println(studentQueue.take());
        System.out.println(studentQueue);
        /**
         * 以上输出内容如下:
         *      [Student(id=1), Student(id=3), Student(id=2)]
         *      使用取出元素时就会排序
         *      Student(id=1)                poll(): 指定时间内取出元素, 如果超时就返回null
         *      [Student(id=2), Student(id=3)]
         *      Student(id=2)                take(): 从队列中取值,如果没有值那么线程会一直阻塞
         *      [Student(id=3)]
         */
    }


}
