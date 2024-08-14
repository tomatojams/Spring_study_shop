package chapter_02;

/** Created by tomatojams on 2023-09-27 */
public class _05_Operator5 {

  public static void main(String[] args) {
    // 삼항연산자
    // 결과 = (조건 )? (참의경우 결과값) : (거짓의경우 결과값);

    int x = 5;
    int y = 3;
    int max = (x > y) ? x : y;
    System.out.println(max);

    int min = (x < y) ? x : y;
    System.out.println(min);

    boolean b = (x == y) ? true : false;
    System.out.println(b);
  }
}
