package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class String7 {
    public static void main(String[] args) {
        String7 T = new String7();
        System.out.println(T.solution("aaabc"));
        System.out.println(T.solution("aabb"));
    }

    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        String tmp = "abc";
        for (char key : tmp.toCharArray()) {
            if (map.getOrDefault(key, 0) > max) {
                max = map.getOrDefault(key, 0);
            }
        }
        for (char key : tmp.toCharArray()) {
            answer.add(max - map.getOrDefault(key, 0));
        }
        return answer;

    }

}
