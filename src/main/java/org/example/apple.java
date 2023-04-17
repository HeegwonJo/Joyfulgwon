package org.example;

class apple {
    public static void main(String[] args){
    apple T = new apple();
    System.out.println(T.solution(new int[]{3, 2, 1, 2, 1, 3}, new int[]{1, 0, 0, 1, 0, 0}, 3));
    System.out.println(T.solution(new int[] {3,2,3,2,1,3}, new int[]{1,0,0,1,0,0},3));
}
    public int solution(int[] apples, int[] power, int m){
        int answer=0;
        int n = apples.length;
        // 문제풀이: 에너지 1인 인덱스 apple 다 구하고 슬라이딩 윈도우로 밀고 가면서 0인거 제일 큰거 찾으면 됨.
        int tmp=0;
        for(int i=0; i<n; i++){
            if(power[i]==1) tmp+=apples[i];
        }
        //첫번쨰 인덱스에서 부스트 쓴경우
        for(int i=0; i<m; i++){
            if(power[i]==0) tmp+=apples[i];
        }
        //정답에 임시값 담고
        answer=tmp;

        //윈도우 한칸씩 앞으로 가면서 앞에거 더하고 뒤에거 빼고 큰 값으로 교체
        for(int i=0; i<n-m; i++){
            if(power[i+m]==0)tmp+=apples[i+m];
            if(power[i]==0)tmp-=apples[i];
            answer=Math.max(answer,tmp);
        }
        return answer;
    }
}