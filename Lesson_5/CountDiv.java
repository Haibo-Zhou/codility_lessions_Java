/*
Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
 */

// O(B-A)

//public class CountDiv {
//    public int solution(int A, int B, int K) {
//        // write your code in Java SE 8
//        int result = 0;
//        int range = B - A + 1;
//
//        for (int i = 0; i < range; i++) {
//            if (A % K == 0 ) {
//                result += 1;
//            }
//            A++;
//            // System.out.println(A);
//        }
//        System.out.println("final: " + result);
//        return result;
//    }
//
//    public static void main(String [] args) {
//        CountDiv ss = new CountDiv();
//        ss.solution(6, 11, 2);
//    }
//}



// O(1)
public class CountDiv {
    public int solution(int A, int B, int K) {
        int b = B / K;
        int a = 0;
        /*
          purely math problem:(
          Number of integer in the range [1 .. X] that divisible by K is X/K.
          So, within the range [A .. B], the result is B/K - (A - 1)/K
        */
        if (A > 0) {
            a = (A - 1) / K;
        } else if (A == 0) {
            b++;
        }
        System.out.println(b - a);
        return b - a;
    }

    public static void main(String [] args) {
        CountDiv ss = new CountDiv();
        ss.solution(6, 11, 2);
        ss.solution(0, 4, 2);
        ss.solution(11, 345, 17);
    }
}

