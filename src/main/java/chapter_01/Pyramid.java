package chapter_01;

/** Created by tomatojams on 2023-09-14 */
public class Pyramid {

  public static void main(String[] args) {
    int numberOfBricks = 9;

    for (int i = 1; i <= numberOfBricks; i = i + 2) {
      int space = (numberOfBricks - i) / 2;

      for (int j = 0; j < space; j++) {
        System.out.print(" ");
      }
      for (int k = 0; k < i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
