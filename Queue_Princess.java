package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Princess {
    public static void main (String[] args){
        Queue_Princess T= new Queue_Princess();
        System.out.println(T.solution(8, 3));
    }
    public int solution(int n, int k){
        Queue<Integer> q= new LinkedList<>();
        //큐에 n 명 담기
        for(int i=1; i<=n; i++){
            q.offer(i);
        }
        System.out.println(q);
        //한명 남을때 까지 반복
        while(q.size()!=1){
            int cnt=1;
            //카운트만큼 앞에서 꺼내서 뒤에 넣어주기
            while(cnt<k){
                q.offer(q.poll());
                cnt++;
            }
            //한명씩 줄여나감
            q.poll();
        }
        //마지막 한명
        return q.poll();
    }
}
