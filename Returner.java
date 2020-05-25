package LibrarySystem;

public class Returner implements Runnable{
    LibraryDeposit depot;

    public Returner(LibraryDeposit depot){
        this.depot = depot;
    }

   //还书者还书代码
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始还书啦！");
        try{
            Thread.currentThread().sleep(100);//还书前稍微睡一下
        }catch (InterruptedException ex){
                ex.printStackTrace();
        }
        depot.returnBook();
    }
}
