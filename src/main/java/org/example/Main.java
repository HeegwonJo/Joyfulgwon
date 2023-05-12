package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().bfs(5, 12));
    }
}

class Solution {

    int[] dir = {1, -1, 5};  // 방향벡터
    boolean[] chk;
    Queue<Integer> queue = new LinkedList<>();

    public int bfs(int s, int e) {
        int ans = 0;
        chk = new boolean[10001];
        chk[s] = true;
        queue.offer(s);
        while(!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int now = queue.poll();
                if (e == now)
                    return ans+1;
                else {
                    for (int j = 0; j < 3; j++) {
                        int nx = now + dir[j];
                        if (0 <= nx && nx <= 10000 && !chk[nx]) {
                            queue.offer(nx);
                            chk[nx] = true;
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
