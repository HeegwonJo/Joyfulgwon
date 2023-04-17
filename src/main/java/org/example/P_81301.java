package org.example;

import java.util.*;
public class P_81301 {
    public static void main(String[] args){
        P_81301 T=new P_81301();
        System.out.println(T.solution("one4seveneight"));
    }


    public int solution(String s) {
        int answer = 0;
        String[] num= new String[] {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<num.length; i++){
            s= s.replace(num[i], i+"");
        }

        return Integer.parseInt(s);
    }
}