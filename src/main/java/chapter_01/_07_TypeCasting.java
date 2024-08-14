package chapter_01;

/** Created by tomatojams on 2023-09-27 */
public class _07_TypeCasting {

  public static void main(String[] args) {
    // 형전환 (Type Casting)
    // 정수형에서 실수형으로
    // 실수형에서 정수형으로

    int score = 93;
    System.out.println(score); // 93
    System.out.println((float) score); // 93.0
    System.out.println((double) score); // 93.0

    // float , double to int

    float score_f = 93.5f;
    double score_d = 98.8;

    System.out.println((int) score_f); // 93
    System.out.println((int) score_d); // 98

    int score_int = (int) score_f + (int) score_d;
    System.out.println(score_int); // 191

    // 변수에 형변환된 데이터 집어넣기
    double convertecdScoreDouble = score; // 191 -> 191.0
    // int -> long -> float -> double (자동형변환)
    System.out.println(convertecdScoreDouble);
    // int convertedScoreInt = score_d; 에러
    // double -> float -> long -> int (수동형변환)

    // 숫자를 문자열로
    String s1 = String.valueOf(123); // String 클래스의 메소드 활용
    s1 = Integer.toString(123); // Integer 클래스의 메소드 활용
    System.out.println(s1);

    String s2 = String.valueOf(99.9); // String 클래스의 메소드 활용
    s2 = Double.toString(99.9); // Double 클래스의 메소드 활용
    System.out.println(s2);

    // 문자열을 숫자로

    int i = Integer.parseInt("93"); // String -> int (Integer 클래스의 메소드 활용)
    System.out.println(i);
    double d = Double.parseDouble("99.9"); // String -> double (Double 클래스의 메소드 활용)
    System.out.println(d);

    // int error = Integer.parseInt("자바");

  }
}
