package exercise;

// BEGIN
class MinThread extends Thread {
    private int[] numbers;
    private int min = 0;

    MinThread(int[] numbers) {
        this.numbers = numbers;
        if (numbers.length > 0) {
            min = numbers[0];
        }
    }

    @Override
    public void run() {
        System.out.printf("INFO: Thread %s started\n", this.getName());
        for (int i : numbers) {
            min = Math.min(i, min);
        }
        System.out.printf("INFO: Thread %s finished\n", this.getName());
    }

    public int getMin() {
        return min;
    }
}
// END
