package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        int K = sc.nextInt();
        Integer[] values = new Integer[N];
        for(int i = 0 ; i< N; i++){
            values[i] = sc.nextInt();
        }
        Arrays.sort(values, Comparator.reverseOrder());

        for(int x : values){
            if(K>x) {
               answer += K/x;
               K=K%x;
            }
            if(K ==0 ) break;
        }

        System.out.println(answer);
    }
}
