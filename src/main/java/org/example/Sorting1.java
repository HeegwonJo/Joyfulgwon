package org.example;
import java.util.*;
public class Sorting1 {
    static public void main(String[] args){
        Sorting1 T = new Sorting1();
        System.out.println(T.solution(new int[][] {{14,18},{12,15},{15,20},{20,30},{5,14}}));
    }

    public int solution(int[][] times){
        int answer=Integer.MIN_VALUE;

        // 시간을 수평선위에 들어오는 시간, 나가는 시간으로 한줄로 정리하면 쉬움.
        // Arrays.sort(times,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        // 배열로는 안될 듯=> 시간이 속성을 가져야되니까 클래스 만들어주고 객체가 시간이랑 들어오고 나가는 속성 가지게 구현
        ArrayList<Time> list = new ArrayList<>();
        //Times 돌면서 앞에 숫자에는 s 붙여서 객체 만들어 담고 뒤에 숫자에는 e 붙여서 객체 만들어서 리스트에 담아줌
        for(int i=0; i<times.length; i++){
            Time startTimeInfo = new Time(times[i][0],'s');
            Time endTimeInfo = new Time(times[i][1],'e');
            list.add(startTimeInfo);
            list.add(endTimeInfo);
        }
        //카운트 초기화
        int cnt=0;
        //리스트 정렬
        Collections.sort(list,(a,b)->a.time==b.time?a.info-b.info:a.time-b.time);
        //리스트 돌면서 s만나면 카운트 ++ e만나면 카운트-- 시간 같으면 e 가 앞으로 나오게 정렬되있어서 예외처리 안해도 됨
        for(Time x: list){
            System.out.print(x);
            if(x.info=='s')cnt++;
            else cnt--;
           answer=Math.max(answer,cnt);
        }

        return answer;
    }



}
class Time {
    public int time;
    public char info;

    Time(int time, char info){
        this.time=time;
        this.info=info;
    }

    @Override
    public String toString(){
        return "시간 "+ this.time +" 출입여부 " + this.info+ "   ";
    }
}