//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread firstThread = new Thread(new FirstThread());
        Thread secondThread = new Thread(new SecondThread());

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}