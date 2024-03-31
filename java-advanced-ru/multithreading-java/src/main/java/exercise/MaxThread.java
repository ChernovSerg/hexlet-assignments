package exercise;

// BEGIN
class MaxThread extends Thread{
    private int[] numbers;
    private int max = 0;

    MaxThread(int[] numbers) {
        this.numbers = numbers;
        if (numbers.length > 0) {
            max = numbers[0];
        }
    }

    @Override
    public void run() {
        System.out.printf("INFO: Thread %s started\n", this.getName());
        for (int i : numbers) {
            max = Math.max(i, max);
        }
        System.out.printf("INFO: Thread %s finished\n", this.getName());
    }

    public int getMax() {
        return max;
    }
}
// END
