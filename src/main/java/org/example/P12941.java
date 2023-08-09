package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P12941 {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : B) {
            queue.offer(num);
        }

        int answer = 0;
        Arrays.sort(A);
        for (int num : A) {
            answer += num * queue.poll();
        }

        return answer;
    }
}
