package LibrarySystem;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryDeposit depot = new LibraryDeposit(1);
        Returner r = new Returner(depot);
        Borrower b = new Borrower(depot);

        for(int i = 5; i > 0; i--){
            Thread t1 = new Thread(r);
            Thread t2 = new Thread(b);

            t1.setName("还书者"+i);
            t2.setName("借书者"+i);

            t1.start();
            t2.start();
        }
    }
}
