import java.util.ArrayList;

public class Buffer {
    public static ArrayList<Integer> buffer = new ArrayList<>();
    public static int N = 8;
    public volatile static boolean firstT = true;

    public Buffer() {
    }


}