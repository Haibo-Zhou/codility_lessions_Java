/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
*/


import java.util.*;

class checkPermutation {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        if (A[0] != 1) {
          System.out.println("A[0] doesn't equal 1, then array A is not a permutation.");
          return 0;
        }

        for (int i = 0; i < A.length - 1; i ++) {
          if (A[i+1] != A[i] + 1) {
            System.out.println("array A is not a permutation.");
            return 0;
          }
        }
        System.out.println("array A is a permutation!");
        return 1;
    }

    public static void main(String [] args) {
      checkPermutation ss = new checkPermutation();
      int [] A = {4, 1, 3, 2};
      int [] B = {5, 6, 1, 1, 3, 1, 9};
      int [] C = {2, 3, 4, 5};
      ss.solution(A);
      ss.solution(B);
      ss.solution(C);
    }
}
