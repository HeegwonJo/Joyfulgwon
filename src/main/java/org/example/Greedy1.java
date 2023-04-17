package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Greedy1 {
    public static void main(String[] args) {
        Greedy1 T = new Greedy1();
        System.out.println(T.solution(new Integer[]{2, 8, 3, 6, 1, 9, 1, 9}, 2));
        System.out.println(T.solution(new Integer[]{7, 6, 8, 9, 10}, 1));
    }

    public int solution(Integer[] abbilities, int k) {
        int answer = 0;
        int n = abbilities.length;
        //임시배열 선언만 했음 생성은 조건문 안에서 할거임 Integer로 한건 컴퍼레이터로 내림차순 정렬하려고
        Integer[] tmp;

        //내림차순 정렬해놓고 한바퀴 다뽑음 2n 번쨰랑 2n-1번째 차이 저장한 배열 따로 만들고 그 배열에서 k번쨰까지 뽑기..?
        //홀수명, 짝수명 케이스 생각하기 => 홀수면 그냥 0하나 더 넣어주는게 나을듯
        //홀수명
        if (n % 2 == 1) {
            tmp = new Integer[n + 1];
            for(int i = 0; i<abbilities.length; i++){
                tmp[i] = abbilities[i];
            }
            tmp[n] = 0;
        }
        //짝수명
        else {
            tmp = new Integer[n];
            for (int i = 0; i < abbilities.length; i++) {
                tmp[i] = abbilities[i];
            }
        }
        //0 잘 들어갔는지 확인
        System.out.println(Arrays.toString(tmp));
        //내림차순 정렬 Arrays.sort(tmp,Collections.reverseOrder()) 해도 됨
        Arrays.sort(tmp, (a, b) -> b - a);
        //정렬 이쁘게 잘 됐나 확인
        System.out.println(Arrays.toString(tmp));

        //0-1, 2-3, 4-5 ,,,두명씩 짝지어서 능력치 차이 담은 리스트
        //어차피 짝수명으로 맞춰놨으니까 n/2 길이 배열해도 됨. 초반에 홀수 짝수 구분없이 구현해보려고 리스트로 만들었음.
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (int i = 0; i<tmp.length/2; i++) {
            //차이 나는만큼 리스트에 담고
            diff.add(tmp[2 * i] - tmp[2 * i + 1]);
            //answer에는 짝수번 째 사람 능력치 다 더함
            answer += tmp[2*i+1];
        }

        //리스트 내림차순 정렬
        Collections.sort(diff, Collections.reverseOrder());
        //정렬 확인
        System.out.println(diff);
        //우선권 갯수만큼 차이 큰 순서로 더하기
        for(int i=0; i<k; i++){
            answer+= diff.get(i);
        }
        return answer;
    }
}
// 우선권을 사용하면서 뽑아가는 형태가 아니라
// 순서대로 다 뽑아놓고 이건 진짜 아니다 같은 라운든데 스탯차이 너무 난다 하는 선수를
// 우선권 갯수만큼 트레이드 할 수 있다고 생각.
//ex) player = {10, 10, 8, 7 , 6, 3, 2 , 1}
//     team1 = {10,8,6,2}
//     team2 = {10,7,3,1}
//              1, 2,3,4 라운드에 뽑힌 선수들
//      diff = {0,1,3,1}
//반복문 돌면서 같은 인덱스에 있는 선수들 숫자 차이 새로운 배열에 넣고 큰거부터 k개 뽑아준 방식
