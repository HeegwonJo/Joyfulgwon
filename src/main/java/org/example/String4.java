package org.example;

public class String4 {
    public static void main(String[] args) {
        String4 T = new String4();
        System.out.println(T.solution("abcabbakcba"));
        System.out.println(T.solution("abcacbakcba"));
    }

    public String solution(String s) {
        String answer = "Yes";
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                String s1 = s.substring(left, right);
                String s2 = s.substring(left + 1, right + 1);
                if (!isPalindrome(s1) && !isPalindrome(s2)) return "NO";
                else break;
            } else {
                left++;
                right--;
            }
        }
        return answer;

    }
    public boolean isPalindrome(String s) {
        boolean answer = true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return answer;
    }

}
