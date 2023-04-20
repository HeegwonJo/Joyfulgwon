package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class P_87377 {
    public static void main(String[] args){
        P_87377 P = new P_87377();
        System.out.println(P.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}));
    }
    private String[] solution(int[][] line){
        String[] answer = {};
        Set<Integer> set= new HashSet<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i<100; i++) {
            list.add(i);
        }
        return answer;

    }
}
