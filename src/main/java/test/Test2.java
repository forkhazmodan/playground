package test;

public class Test2 {


  public static void main(String[] args) {
    String s = new String("test");

    test(s);
    System.out.println(s);
  }

  public static void test(String n) {
    n = "Test";
    System.out.println("n:" + n);
  }

}
