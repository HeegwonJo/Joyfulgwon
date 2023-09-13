package org.example;

import java.util.Arrays;

public class KiwiJuiceEasy {

    public static void main(String[] args) {
        KiwiJuiceEasy K = new KiwiJuiceEasy();
        System.out.println(Arrays.toString(K.thePouring(new int [] {30,20,10}, new int[]{10,5,5}, new int[]{0,1,2}, new int[]{1,2,0})));
    }

    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        for (int i = 0; i < fromId.length; i++) {
            int sum = bottles[fromId[i]] + bottles[toId[i]];
            bottles[toId[i]] = Math.min(sum, capacities[toId[i]]);
            bottles[fromId[i]] = sum-bottles[toId[i]];

        }
        return bottles;
    }
}
