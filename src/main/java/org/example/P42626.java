package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class P42626 {
    public static void main(String[] args) {
        P42626 T = new P42626();
        System.out.println(T.solution(new int[]{1,2,3,9,10,12}, 7));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: scoville){
            pq.offer(x);
        }
        while(pq.peek()<K){
            if(pq.size()==1) return -1;
            pq.offer(pq.poll()+pq.poll()*2);
            answer++;
        }


        return answer;
    }


}
