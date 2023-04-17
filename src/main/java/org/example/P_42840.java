package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class P_42840 {
    public static void main(String[] args){
        P_42840 P = new P_42840();
        System.out.println(Arrays.toString(P.solution(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(P.solution(new int[] {1,3,2,4,2})));
    }
    public int[] solution(int[] answers){
        int[] answer1={1,2,3,4,5};
        int[] answer2={2,1,2,3,2,4,2,5};
        int[] answer3={3,3,1,1,2,2,4,4,5,5};
        int[] cnt=new int[] {0,0,0};
        for(int i=0; i<answers.length; i++) {
            if (answer1[i % 5] == answers[i]) cnt[0]++;
            if (answer2[i % 8] == answers[i]) cnt[1]++;
            if (answer3[i % 10] == answers[i]) cnt[2]++;
        }
        int max =0;
        for(int x: cnt){max=Math.max(max,x);}
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<cnt.length; i++){
            if(cnt[i]==max) answer.add(i+1);
        }
        int[] answerArr=new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
           answerArr[i]=answer.get(i);
        }

        return answerArr;
    }


}
