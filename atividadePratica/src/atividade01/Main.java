package atividade01;

public class Main {
    public static void main(String args[]) throws InterruptedException{
        //Opção 1
        /*MyThread t = new MyThread();
        t.run();
        System.out.println(Thread.currentThread());
        Thread.sleep(1000); //espera 1 segundo*/
        //Opção 2
        MyRunnable r = new MyRunnable();
        MyThread t = new MyThread();
        t.start();
    }
}
