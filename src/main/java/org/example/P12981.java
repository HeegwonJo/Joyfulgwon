package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class P12981 {
    public static void main(String[] args) {
        P12981 P = new P12981();
        System.out.println(Arrays.toString(P.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(P.solution(2,new String[] {"hello", "one", "even", "never", "now", "world", "draw"})));
    }
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String before = words[i - 1];
            String current = words[i];
            set.add(current);

            if (before.charAt(before.length() - 1) != current.charAt(0)
                    || set.contains(current)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
            }
        }

        return answer;
    }
}
