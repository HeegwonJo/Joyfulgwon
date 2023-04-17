package org.example;

import java.util.*;


public class Sorting2 {
    public static void main(String[] args){
        Sorting2 s = new Sorting2();
        System.out.println(Arrays.toString(s.solution(new int []{3,76,24})));
    }

    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer= new int[n];
        ArrayList<Patient> list = new ArrayList<>();
        for(int i=0; i<emergency.length; i++){
            Patient patient=new Patient(emergency[i],i);
            list.add(patient);
        }
        Collections.sort(list,(a,b)->b.emer-a.emer);

        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i).index+1;
        }
        return answer;
    }
}
class Patient{
    public int emer;
    public int index;

    Patient(int emer, int index){
        this.emer=emer;
        this.index=index;
    }
}