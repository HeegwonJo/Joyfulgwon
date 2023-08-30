package org.example;

import java.util.*;

public class P42895 {
    public static void main(String[] args) {
        P42895 T = new P42895();
        System.out.println(T.solution(5,12));
    }

    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] dp = new HashSet[9];

        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            int num = 0;
            for (int j = 0; j < i; j++) {
                num = num * 10 + N;
            }
            dp[i].add(num);

            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (Integer a : dp[j]) {
                    for (Integer b : dp[k]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }

            if (dp[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

