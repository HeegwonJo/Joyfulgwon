package org.example;

public class Arule {
    public static void main(String[] args) {
        System.out.println(canGenerate("abab")); // true
        System.out.println(canGenerate("bbaa")); // false
    }

    public static boolean canGenerate(String target) {
        String current = target;

        while (current.length() > 1) {
            int countA = countCharacter(current, 'a');

            if (countA == 0) {
                return false;
            }

            String bCount = String.valueOf('b').repeat(countA);

            if (!current.startsWith(bCount) || !current.endsWith(bCount)) {
                return false;
            }

            current = current.substring(countA, current.length() - countA);
        }

        return "a".equals(current);
    }

    private static int countCharacter(String str, char c) {
        int count = 0;

        for (char ch : str.toCharArray()) {
            if (ch == c)
                ++count;
        }

        return count;
    }
}
