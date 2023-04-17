package org.example;

public class String3 {

    public static void main(String[] args){
        String3 T = new String3();
        System.out.println(T.solution("a#b!GE*T@S"));
    }

    public String solution(String s){
        String answer;
        char[] str=s.toCharArray();
        int left=0, right=s.length()-1;
        while(left<right){
            if(!Character.isAlphabetic(str[left])) left++;
            else if(!Character.isAlphabetic(str[right])) right--;
            else{
                char temp=str[left];
                str[left]=str[right];
                str[right]=temp;
                left++;
                right--;
            }
        }
        answer=String.valueOf(str);
        return answer;
    }
}
