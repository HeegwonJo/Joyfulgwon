package org.example;

import java.util.LinkedList;
import java.util.Queue;

import java.util.*;
public class Queue_Timetable {
    public ArrayList<String> solution(String need, String[] plans){
        ArrayList<String> answer=new ArrayList<>();
        String res="YES";
        for(String plan : plans){
            Queue<Character> Q=new LinkedList<>();
            int flag=0;
            for(char x : need.toCharArray()) Q.offer(x);
            for(char x : plan.toCharArray()){
                if(Q.contains(x)){
                    if(x!=Q.poll()){
                        answer.add("NO");
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0 && !Q.isEmpty()) answer.add("NO");
            if(flag==0 && Q.isEmpty()) answer.add("YES");
        }
        return answer;
    }
}