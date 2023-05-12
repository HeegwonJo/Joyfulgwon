package org.example;

public class ladder {
    public static void main (String[]args){
        ladder T= new ladder();
        System.out.println(T.solution(5, new int[][] {{1,3},{2,4},{1,4}}));
        System.out.println(T.solution(7, new int[][] {{1,3,5},{1,3,6},{2,4}}));
        System.out.println(T.solution(12, new int[][] {{1,5,8,10},{2,4,7},{1,5,7,9,11},{2,5,7,10},{3,6,8,11}}));
    }

    public char[] solution(int n, int[][] ladder){
        char[] answer= new char [n];
        for(int i=0; i<n; i++){
            answer[i]= (char)(i+'A');
        }
        for(int[] arr : ladder){
            for (int x: arr){
                char tmp = answer[x];
                answer[x]=answer[x-1];
                answer[x-1]=tmp;
            }
        }

        return answer;
    }

}
