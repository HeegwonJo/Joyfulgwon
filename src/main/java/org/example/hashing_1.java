package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class hashing_1 {
    public static void main(String[] args){
        hashing_1 P = new hashing_1();
        System.out.println(P.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(P.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"},3));
    }

    public String solution(String[] votes, int k){
        String answer = "";
        //득표수 조회
        HashMap<String, Integer> voteMap = new HashMap<String, Integer>();
        for(String x: votes){
            String candidate = x.split(" ")[1];
            voteMap.put(candidate,voteMap.getOrDefault(candidate,0)+1);
        }
        //후보자 선정
        List<String> candidates = new ArrayList<String>();
        for(String x: voteMap.keySet()){
            if(voteMap.get(x)>=k) candidates.add(x);
        }
        //선물 개수 파악.
        HashMap<String, Integer> presentMap = new HashMap<String, Integer>();
        for(String x: votes){
            if(candidates.contains(x.split(" ")[1])){
                String voter= x.split(" ")[0];
                presentMap.put(voter,presentMap.getOrDefault(voter,0)+1);
            }
        }
        List<String> maxPresent = new ArrayList<>();
        int maxCount = 0;
        for (String name : presentMap.keySet()) {
            int count = presentMap.get(name);
            if (count > maxCount) {
                maxCount = count;
                maxPresent.clear();
                maxPresent.add(name);
            } else if (count == maxCount) {
                maxPresent.add(name);
            }
        }
        Collections.sort(maxPresent);
        return maxPresent.get(0);
    }
}
