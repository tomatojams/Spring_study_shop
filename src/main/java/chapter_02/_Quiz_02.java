package chapter_02;

/** Created by tomatojams on 2023-09-27 */
public class _Quiz_02 {
  public static void main(String[] args) {

    int height = 115;

    String isTall = (height > 120) ? "탑승가능합니다" : "탑승불가합니다";
    System.out.println("키가 " + height + "cm인 승객님은 " + isTall);
  }
}
