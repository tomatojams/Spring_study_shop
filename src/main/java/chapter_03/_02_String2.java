package chapter_03;

/** Created by tomatojams on 2023-09-27 */
public class _02_String2 {

  public static void main(String[] args) {
    String s = "I like Java and Python and C.";

    // 문자열 변환
    System.out.println(s.replace(" and", ",")); // " and" -> "," 변환
    System.out.println(s.substring(7)); // Java에서 시작 이전은 잘라냄
    System.out.println(s.substring(s.indexOf("Java"))); // Java부터 끝까지 위와같음
    System.out.println(s.substring(s.indexOf("Java"), s.indexOf("."))); // 7부터 끝위치 직전까지

    // 공백제거
    s = "          I love Java.          ";
    System.out.println(s.trim()); // 앞뒤 공백 제거
  }
}
