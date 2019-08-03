/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/
// O(N + M) with good performance

import java.util.Arrays;

class n_counter_performance {
    public int[] solution(int N, int[] A) {

        final int condition = N + 1;
        int currentMax = 0;
        int lastUpdate = 0;
        int countersArray[] = new int[N];

        for (int iii = 0; iii < A.length; iii++) {
            int currentValue = A[iii];
            if (currentValue == condition) {
                // use lastUpdate to keep max value of all counter
                // to avoid the O(N*M) situations
                lastUpdate = currentMax;
            } else {
                int position = currentValue - 1;
                if (countersArray[position] < lastUpdate) {
                    countersArray[position] = lastUpdate + 1;
                } else {
                    countersArray[position]++;
                }

                if (countersArray[position] > currentMax) {
                    currentMax = countersArray[position];
                }
            }

        }

        System.out.println("111: " + Arrays.toString(countersArray));

        // update all elements of countersArray,
        // which <= lastUpdate to max value of any counter.
        // in this case, [3, 0, 1, 4, 0] =>  [3, 2, 2, 4, 2]
        for (int iii = 0; iii < N; iii++) {
            if (countersArray[iii] < lastUpdate)
                countersArray[iii] = lastUpdate;
        }

        System.out.println(Arrays.toString(countersArray));
        return countersArray;
    }

    public static void main(String [] args) {
        n_counter_performance ss = new n_counter_performance();
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        ss.solution(5, A);
    }
}