package test;

public class Test {

  public static void main(String[] args) {
    int i = 0;

    test(i);
    System.out.println(i);
  }

  public static void test(int n) {
    n = n + 1;
    System.out.println("n:" + n);
  }

}
