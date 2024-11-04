package test;

public class Test3 {

  public static void main(String[] args) {
    TestObj s = new TestObj("Test1");

    test(s);
    System.out.println(s);
  }

  public static void test(TestObj obj) {
    obj.name = "Test2";
    System.out.println("n:" + obj);
  }

  public static class TestObj {

    public TestObj(String name) {
      this.name = name;
    }

    public String name;
  }

}
