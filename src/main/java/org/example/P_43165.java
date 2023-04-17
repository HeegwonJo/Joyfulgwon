package org.example;

public class P_43165 {
    int answer;
    int target;
    int[] numbers;
    public static void main(String[] args) throws Exception {
        P_43165 P=new P_43165();
        System.out.println(P.solution(new int[]{1,1,1,1,1},3));
    }

    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;

        DFS(0,0);

        return answer;
    }
    void DFS(int index, int sum){
        if(index==numbers.length){
            if(sum==target)answer++;
            return;
        }
        DFS(index+1,sum+numbers[index]);
        DFS(index+1,sum-numbers[index]);
    }
}
