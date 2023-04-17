package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Cardpick {
    public static void main(String[] args) {
        Cardpick T = new Cardpick();
        System.out.println(T.solution(new int[]{2, 3, 7, 1, 2, 1, 5}, 4));
        System.out.println(T.solution(new int[]{1,2,3,5,6,7,1,3,9},5));
    }

    public int solution(int[] nums, int k) {
        int answer=Arrays.stream(nums).reduce(0, (a, b)->a+b);
        //배열의 총 합
        for(int x : nums){
            answer+=x;
        }
        int windowSize=nums.length-k;
        int window=0;
        for(int i=0; i<windowSize; i++){
            window+=nums[i];
        }
        int tmp=window;

        for(int i=0; i<nums.length-windowSize; i++){
            window=window+nums[i+windowSize]-nums[i];
            tmp=Math.min(window,tmp);
        }
        return answer-tmp;
    }
}
