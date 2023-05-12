package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//회장선거
public class Array_vote {

    public static void main (String[] args){
        Array_vote T= new Array_vote();
        int[][] arr = new int[][] {{0, 1},{0, 3}, {1, 2}, {2, 0}, {2, 3}, {3, 0}};
        System.out.println(Arrays.toString(T.solution(4, arr,2)));
    }
    public int[] solution(int n, int[][] votes, int k){
        int [] answer= new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>();
        //TODO: 후보 먼저 구하자
        HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int[] x: votes){
           int vote=x[1];
           map.put(vote, map.getOrDefault(vote,0)+1);
        }
        //후보정보 리스트에 담기
       for(int x: map.keySet()){
           if(map.get(x)>=k){
               list.add(x);
           }
       }
       //후보를 추천한 학생 확인
       for(int[] x:votes){
           if(list.contains(x[1])){
               answer[x[0]]++;
           }
       }

        return answer;
    }
}
