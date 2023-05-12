package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class P_64065 {
    public static void main(String[] args){
        P_64065 P= new P_64065();
        System.out.println(P.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
        System.out.println(P.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }
    public LinkedHashSet<Integer> solution(String s){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        //원소 개수가 작은 것 순서로 정렬
        s=s.replaceAll("\\{","");
        String[] tuples = s.split("},");
        for(int i=0; i<tuples.length; i++){
            tuples[i]=tuples[i].replaceAll("}}","");
        }
        Arrays.sort(tuples, (a,b)-> a.length()-b.length());
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(String x: tuples){
            String[] nums = x.split(",");
            for (String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }
        System.out.println(set);

        return set;
    }
}
