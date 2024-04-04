class SecondThread implements Runnable {

    public SecondThread() {

    }

    @Override
    public void run() {
        while (Buffer.firstT || (Buffer.firstT == false && !Buffer.buffer.isEmpty())) {
            synchronized (Buffer.buffer) {
                while (Buffer.buffer.isEmpty()) {
                    try {
                        Buffer.buffer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int convert = Integer.parseInt(getFromBuffer().trim(), 5);
                Buffer.buffer.removeAll(Buffer.buffer);
                System.out.println("вывод: " + convert + " - второй поток");

                Buffer.buffer.notify();
            }
        }

    }

    private static String getFromBuffer() {
        String res = "";
        for (int x : Buffer.buffer) {
            res += x;
        }

        return res;
    }

}
