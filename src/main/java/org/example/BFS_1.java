package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {
    public static void main(String[] args) {
        BFS_1 P = new BFS_1();
        System.out.println(P.solution(5, 14));
        System.out.println(P.solution(8, 3));
    }

    private int solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        int[] jumps = {-1, 1, 5};
        int[] check = new int[10001];
        int jumpCount = 0;
        q.offer(s);
        check[s] = 1;
        while (!q.isEmpty()) {
            int range = q.size();
            for (int i = 0; i < range; i++) {
                int cur = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = cur + jumps[j];
                    if (nx == e) return jumpCount + 1;
                    if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            jumpCount++;
        }
        return -1;
    }
}
