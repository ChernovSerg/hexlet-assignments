package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");
    private static final int[] numbers = {10, -4, 67, 100, -100, 8};

    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> result = new HashMap<>();
        MinThread threadMin = new MinThread(numbers);
        MaxThread threadMax = new MaxThread(numbers);
        threadMin.start();
        threadMax.start();
        try {
            threadMin.join();
            threadMax.join();
            result.put("min", threadMin.getMin());
            result.put("max", threadMax.getMax());
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return result;
        }
    }

    // BEGIN
    public static void main(String[] args) {
        System.out.println(App.getMinMax(numbers));
    }
    // END
}
