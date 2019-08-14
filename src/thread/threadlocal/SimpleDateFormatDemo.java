package thread.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 我们知道SimpleDateFormat在多线程下是存在线程安全问题的，
 * 那么将SimpleDateFormat作为每个线程的局部变量的副本就是每个线程都拥有自己的SimpleDateFormat，就不存在线程安全问题了。
 */
public class SimpleDateFormatDemo {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

    public DateFormat getDateFormat() {
        DateFormat df = threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            threadLocal.set(df);
        }
        return df;
    }

    public static class MyRunnable implements Runnable {
        private SimpleDateFormatDemo simpleDateFormatDemo;

        public MyRunnable(SimpleDateFormatDemo simpleDateFormatDemo) {
            this.simpleDateFormatDemo = simpleDateFormatDemo;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 当前时间：" + simpleDateFormatDemo.getDateFormat().format(new Date()));
        }
    }

    public static void main(String [] args) {
        SimpleDateFormatDemo formatDemo = new SimpleDateFormatDemo();

        MyRunnable myRunnable1 = new MyRunnable(formatDemo);
        MyRunnable myRunnable2 = new MyRunnable(formatDemo);
        MyRunnable myRunnable3 = new MyRunnable(formatDemo);

        Thread thread1= new Thread(myRunnable1);
        Thread thread2= new Thread(myRunnable2);
        Thread thread3= new Thread(myRunnable3);
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
