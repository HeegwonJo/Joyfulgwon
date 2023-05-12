package org.example;

public class P_181910 {
    public String solution(String my_string, int n){

        return my_string.substring(0,n);

    }

    public static void main(String[] args){
        P_181910 P =new P_181910();
        System.out.println(P.solution("ProgrammerS123",11));
    }

}
