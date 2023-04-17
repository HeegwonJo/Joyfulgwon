package org.example;

import java.util.ArrayList;

class String12 {
    public static void main(String[] args){
        String12 T = new String12();
        System.out.println(T.solution(new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"}));
        System.out.println(T.solution(new String[]{"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"}));
    }
    //분 단위로 시간 파싱하는 함수
    public int getTime(String time){
        String[] tmp = time.split(":");
        int H=Integer.parseInt(tmp[0]);
        int M=Integer.parseInt(tmp[1]);
        return H*60+M;
    }

    public String solution(String[] times){

        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0; i<times.length; i++){
            list.add(getTime(times[i]));
        }
        int sum=0;
        for(int i=0; i<list.size(); i+=2){
            int time=list.get(i+1)-list.get(i);
            if(time<5) sum+=0;
            else if(time>=105) sum+=105;
            else sum+=time;
        }
        int hour=sum/60;
        int minute=sum%60;
        return (hour<10 ? "0" + hour : hour)+":"+(minute<10?"0"+minute:minute);
    }
}