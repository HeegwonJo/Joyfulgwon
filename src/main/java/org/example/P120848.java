package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P120848 {
    public static void main(String[] args) throws Exception {
        P120848 T = new P120848();
        System.out.println(T.solution("abcabcadc"));
    }
    public String solution(String s) {
        String answer = "";
        HashMap<Character, Integer> map= new HashMap<>();
        ArrayList<Character> list =new ArrayList<>();
        for(char x: s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(char x:map.keySet()){
            if(map.get(x)==1) list.add(x);
        }
        Collections.sort(list);
        for(char x:list){
            answer+=x;
        }

        return answer;
    }
}
