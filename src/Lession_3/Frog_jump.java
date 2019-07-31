/* A small frog wants to get to the other side of the road.
The frog is currently located at position X and wants to get to a position greater than or equal to Y.
The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

class Solution { public int solution(int X, int Y, int D); }

that, given three integers X, Y and D, returns the minimal number of jumps from
position X to a position equal to or greater than Y.

For example, given:

  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:

after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Write an efficient algorithm for the following assumptions:

X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y. */

class Frog_jump {
  public int solution(int X, int Y, int D) {
    if (X == Y) {
      System.out.println("if X == Y, no jump needed");
      return 0;
    } else if ((Y-X) % D == Y-X) {
      System.out.println("(Y-X) < D, 1 time jump");
      return 1;
    } else if ((Y-X) % D == 0){
      System.out.println("(Y-X)%D == 0: " + (Y-X) / D + " times jump");
      return (Y-X) / D;
    } else {
      System.out.println("(Y-X)%D > 0: " + ((Y-X) / D + 1) + " times jump");
      return (Y-X) / D + 1;
    }
  }

  public static void main(String [] args) {
    Frog_jump ss = new Frog_jump();
    ss.solution(10, 85, 30);
    ss.solution(10, 20, 30);
    ss.solution(10, 100, 30);
    ss.solution(10, 1000000000, 30);
    ss.solution(10, 10, 30);

  }
}
