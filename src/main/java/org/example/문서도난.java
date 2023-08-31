package org.example;
import java.util.*;
class Info implements Comparable<Info>{
    public String name;
    public int time;
    Info(String name, int time){
        this.name = name;
        this.time = time;
    }
    @Override
    public int compareTo(Info ob){
        return this.time - ob.time;
    }
}
public class 문서도난 {
    public int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H*60+M;
    }
    public String[] solution(String[] reports, String times){
        //String[] answer ={};
        ArrayList<Info> tmp = new ArrayList<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            tmp.add(new Info(a, getTime(b)));
        }
        Collections.sort(tmp);
        int s = getTime(times.split(" ")[0]);
        int e = getTime(times.split(" ")[1]);
        ArrayList<String> res = new ArrayList<>();
        for(Info ob : tmp){
            if(ob.time >= s && ob.time <= e){
                res.add(ob.name);
            }
            if(ob.time > e) break;
        }
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        문서도난 T = new 문서도난();
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
    }
}