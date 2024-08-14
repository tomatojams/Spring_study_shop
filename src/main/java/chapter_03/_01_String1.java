package chapter_03;

/** Created by tomatojams on 2023-09-27 */
public class _01_String1 {
  public static void main(String[] args) {

    String s = "I like Java and Python and C.";
    System.out.println(s.length()); // 문자길이
    System.out.println(s.charAt(0)); // 문자열의 0번째 문자
    // 대소문자
    System.out.println(s.toUpperCase()); // 대문자로 변환
    System.out.println(s.toLowerCase()); // 소문자로 변환

    //  포함관계
    System.out.println(s.contains("Java")); // 포함관계
    System.out.println(s.contains("C#")); // 포함관계
    System.out.println(s.indexOf("Java")); // 문자열의 시작위치
    System.out.println(s.indexOf("C#")); // -1
    System.out.println(s.lastIndexOf("and")); // 문자열의 마지막 위치
    System.out.println(s.lastIndexOf("and")); // 문자열의 마지막 위치
    System.out.println(s.startsWith("I like")); // true or false
    System.out.println(s.endsWith(".")); // true or false
  }
}
