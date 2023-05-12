package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_3 {
    public static void main(String[] args){
        BFS_3 T=new BFS_3();
        System.out.println(T.solution(new int[]{2,2,0,2,1,1}));
        System.out.println(T.solution(new int[]{1,0,1,1,3,1,2,1}));
        System.out.println(T.solution(new int[]{1,1}));
    }

    public int solution(int[] nums){
        int answer=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int[] ch= new int[nums.length];
        ch[0]=1;
        int jump=0;
        while(!q.isEmpty()){
            int range=q.size();
            for(int i=0; i<range; i++){
                int curX=q.poll();
                for (int j=1; j<=nums[curX]; j++){
                    int nx=curX+j;
                    if(nx==nums.length-1) return jump+1;
                    if(nx>=0 && nx<nums.length && ch[nx]==0){
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            jump++;
        }
        return -1;
    }
}
