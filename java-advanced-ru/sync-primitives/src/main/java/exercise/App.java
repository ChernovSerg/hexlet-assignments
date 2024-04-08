package exercise;

class App {

    public static void main(String[] args) {
        SafetyList list = new SafetyList();
        Thread thread1 = new Thread(new ListThread(list));
        Thread thread2 = new Thread(new ListThread(list));
        try {
        thread1.start();
        thread2.start();
        thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size = " + list.getSize());
//        System.out.println("capacity = " + list.getCapacity());
//        System.out.println(list);
    }
}

