package LibrarySystem;

public class Borrower implements Runnable{
    LibraryDeposit depot;

    public Borrower(LibraryDeposit depot){
        this.depot=depot;
    }

    //借书者的代码
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始借书啦！");
        try{
            Thread.currentThread().sleep(100);//借书前小睡一下
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        depot.borrowBook();
    }
}
