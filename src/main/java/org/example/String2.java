package org.example;

public class String2 {
    public static void main(String[] args) {
        String2 T = new String2();
        System.out.println(T.solution("gofoG"));
        System.out.println(T.solution("Moom"));
    }

    public String solution(String s) {
        String answer = "Yes";
        s=s.toLowerCase();
        int left=0;
        int right=s.length()-1;

        while(left < right){
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right--;
            }
            else return "no";
        }

        return answer;
    }
}
