/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.*;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;
        // 0 < P < N
        // int P = 1;
        long sum1 = 0;
        long sum2 = 0;
        long sum = 0;
        long diff_value = 0;
        List<Integer> list = new ArrayList<Integer>();

        // get the total value of A[]
        // Use Stream to be low performance:(, long sum = IntStream.of(A).asLongStream().sum();
        // So Im using for loops to get the sum.
        // System.out.println("sum: " + sum);
        for (int i : A) {
          sum += i;
        }

        // get 1st part sum1 and 2nd part sum2, then get difference
        // of |sum1 - sum2|, store them into list,
        // get minimal value of list.
        for (int p=1; p<n; p++) {
            System.out.println("p= " + p);
            sum1 += A[p-1];
            sum2 = sum - sum1;
            diff_value = Math.abs(sum1 - sum2);
            list.add((int)diff_value);
            System.out.println("list: " + list);
        }


        System.out.println("minimal value: " + Collections.min(list));
        return Collections.min(list);
    }

    public static void main(String [] args) {
      Solution ss = new Solution();
      int [] A = {3, 1, 2, 4, 3};
      ss.solution(A);
    }
}
