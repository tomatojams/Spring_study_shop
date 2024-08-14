package chapter_03;

/**
 * Created by tomatojams on 2024-08-14
 */
public class _03_String3 {

  public static void main(String[] args) {
    final String Abstract = "tomato";
    final int show = 29;
    System.out.println("접속할 수 있는 URL: http://localhost:8080/");
    System.out.println(Abstract + show + "2");
    // 클래스를 자료형처럼 타입지정으로 쓸수있음
    Hello Test = new Hello();
    Test.hi();
    System.out.println(Test.name);
  }
}


class Hello {

  String name = "soma";

  void hi() {
    System.out.println("hi I'm" + " " + name);
  }
}