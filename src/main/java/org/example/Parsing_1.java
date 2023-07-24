package org.example;

import java.util.*;

public class Parsing_1 {
    public static void main(String[] args) {
        Parsing_1 P = new Parsing_1();
        System.out.println(P.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60));
        System.out.println(P.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120));

    }

    public ArrayList<String> solution(String[] reports, int time) {
        ArrayList<String> answer = new ArrayList<String>();
        HashMap<String, Integer> inTime = new HashMap<>();
        HashMap<String, Integer> totalTime = new HashMap<>();

        for (String x : reports) {
            String name = x.split(" ")[0];
            String hour = x.split(" ")[1];
            String action = x.split(" ")[2];
            if(action.equals("in")) {
                inTime.put(name,getTime(hour));
            } else if (action.equals("out")) {
                totalTime.put(name,totalTime.getOrDefault(name,0)+(getTime(hour)-inTime.get(name)));
            }

        }

        System.out.println(totalTime);
        for(String Person: totalTime.keySet()){
            if(totalTime.get(Person)>time) answer.add(Person);
        }
        Collections.sort(answer);

        return answer;
    }

    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
}

