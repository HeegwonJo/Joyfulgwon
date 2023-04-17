package org.example;

public class String1 {
    public static void main(String[] args) {
        String1 T = new String1();
        System.out.println(T.solution("KKHSSSSSSSE"));
    }

    public String solution(String s) {
        String answer = "";
        int cnt = 1;
        s=s+" ";
        for (int i = 0; i < s.length()-1; i++) {
            if (s.toCharArray()[i] == s.toCharArray()[i+1]) cnt++;
            else {
                answer+=s.toCharArray()[i];
                if(cnt>1){ answer += String.valueOf(cnt);}
                cnt=1;
            }
        }
        return answer;
    }
}
