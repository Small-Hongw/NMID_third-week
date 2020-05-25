package LibrarySystem;

public class LibraryDeposit {
    private int bookMount;
    private final int bookMax = 3;

    public LibraryDeposit(int mount){
        bookMount = mount;
    }

    public synchronized void returnBook(){
        if(bookMount >= bookMax){//书已经满了就不用还书，并结束了线程
            System.out.println("hi，您好"+Thread.currentThread().getName()+"   图书已满不用还书啦！");
        }
        else {//还书成功
            bookMount++;
            System.out.println(Thread.currentThread().getName()+"还书成功，当前图书剩余：" + bookMount);
        }
    }

    public synchronized void borrowBook(){
        if(bookMount <= 0 ){//书没有了需要等待有人来还书
            System.out.println("hi，您好"+Thread.currentThread().getName()+"   当前图书不足请等待");
            try{
                wait();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            finally {
                borrowBook();
            }
        }
        else {//借书成功
            bookMount--;
            System.out.println(Thread.currentThread().getName()+"借书成功，当前图书剩余：" + bookMount);
            notifyAll();
        }
    }
}
