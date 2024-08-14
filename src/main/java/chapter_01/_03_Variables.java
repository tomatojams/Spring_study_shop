package chapter_01;

/** Created by tomatojams on 2023-09-27 */
public class _03_Variables {

  public static void main(String[] args) {
    String name = " 토마토";

    System.out.println("안녕하세요" + name + "입니다.");
    System.out.println(name + "님 , 배송이 완료되었습니다.");

    double score = 90.5;
    char grade = 'A';
    System.out.println(name + "님의 평균점수는" + score + "입니다.");
    System.out.println(name + "님의 학점은" + grade + "입니다.");

    boolean pass = true;
    System.out.println(name + "님은" + pass + "입니다.");

    double d = 3.14123456789;
    float f = 3.141233445543f; // double형을 float형으로 변환 할 때는 뒤에 f를 붙여줘야 한다.
    System.out.println(d);
    System.out.println(f);



    // int i = 12345678; // int형은 21억까지만 표현 가능하다.
    long l = 12345678900000L; // int형을 long형으로 변환 할 때는 뒤에 L을 붙여줘야 한다.
    l = 12_345_6_78_900_000l; // 숫자 사이에 _를 넣어서 가독성을 높일 수 있다.
    System.out.println(l);
  }
}
