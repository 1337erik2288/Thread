import java.sql.SQLOutput;
import java.util.Random;

class FirstThread implements Runnable {

    private final Random random = new Random();

    public FirstThread() {

    }

    @Override
    public void run() {

        for (int i = 0; i < 1200; i++) {
            synchronized (Buffer.buffer) {
                while (Buffer.buffer.size() >=  Buffer.N) {
                    try {
                        Buffer.buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int help = random.nextInt(0, 4);

                Buffer.buffer.add((int) help);
                System.out.println("Число " + i + " первый поток " + help);

                Buffer.buffer.notify();
            }
        }
        Buffer.firstT = false;

    }
}
