package experiment.multithreading.volatile_visibility;

public class Main {

    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (!flag) {
                System.out.println("Wait");
            }
            System.out.println("Flag detected!");
            new String();
        }).start();

        new Thread(() -> {
            flag = true;
            System.out.println("Flag set to true");
        }).start();
    }
}
