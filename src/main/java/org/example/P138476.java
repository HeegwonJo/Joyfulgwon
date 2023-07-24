package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class P138476 {

    public static void main(String[] args) throws Exception {
        P138476 T = new P138476();
        System.out.println(T.solution(6,new int[]{1,3,2,5,4,5,2,3}));
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x: tangerine){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int x: map.keySet()){
            list.add(map.get(x));
        }
        Collections.sort(list,Comparator.reverseOrder());
        System.out.println(map);
        System.out.println(list);
        for(int i=0; i<list.size(); i++){
            k-=list.get(i);
            answer++;
            if(k<=0) return answer;
        }
        return answer;
    }

}
