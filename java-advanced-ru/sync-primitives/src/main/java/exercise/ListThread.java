package exercise;

import java.util.Random;

public class ListThread extends Thread{

    private SafetyList list;

    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            try {
                Thread.sleep(1);
                Random rnd = new Random();
                list.add(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
