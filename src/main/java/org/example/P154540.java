package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class P154540 {
    public int[] solution(String[] maps) {
        int[] answer = {};
        int n = maps[0].length();
        int m = maps.length;
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = maps[j].toCharArray()[i];
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                if (board[i][j] != 'X' && !visited[i][j]) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count += Integer.parseInt(board[i][j]);
                }

                // 인접 무인도 탐색
                while (!q.isEmpty()) {
                    int[] tmp = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int next_i = dx[k] + tmp[0];
                        int next_j = dy[k] + tmp[1];

                        // 상하좌우 및 방문 확인 후 탐색
                        if (next_i >= 0 && next_i < n && next_j >= 0 && next_j < m && !visited[next_i][next_j] && !"X".equals(board[next_i][next_j])) {
                            q.add(new int[]{next_i, next_j});
                            visited[next_i][next_j] = true;
                            count += Integer.parseInt(board[next_i][next_j]);
                        }
                    }
                }

                if (count > 0) {
                    answer.add(count);
                }

            }

        }
    }
}
