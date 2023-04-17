package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class P3687 {
    public static void main(String[] args){
        P3687 p = new P3687();
        System.out.println(p.solution(4));
    }

    public int[] solution (int n){
        int[] answer=new int [2];
        //class 만들어서 원래 숫자랑 만들 수 있는 성냥개비 개수 가진 객체 만들기.
        int[] numarr= new int[] {1,2,3,4,5,6,7,8,9,0};
        int[] num= new int[]{2,5,5,4,5,6,4,7,6,6};
        ArrayList<Number> list = new ArrayList<Number>();

        for (int i = 0; i < 10; i++) {
            Number number = new Number (numarr[i],num[i]);
            list.add(number);
        }
        Collections.sort(list,(a,b)-> (a.orgnum-a.num)==(b.orgnum-b.num)? a.num-b.num : a.num-b.num);

        System.out.println(list);

        return answer;
    }
}

class Number{
    public int orgnum;
    public int num;

    Number (int orgnum, int num){
        this.orgnum=orgnum;
        this.num=num;
    }

    @Override
    public String toString(){
        return "org :" + this.orgnum + "num :" +this.num + "  ";
    }




}