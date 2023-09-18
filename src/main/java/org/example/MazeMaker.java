package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
    public static void main(String[] args) {
        MazeMaker m = new MazeMaker();
        System.out.println(m.longestPath(new String[]{"......."}, 0, 0,
                new int[]{1, -1, 0, 0}, new int[]{0, 0, -1, 1}));

    }

    public int longestPath(String[] maze, int startRow, int startCol,
                           int[] moveRow, int[] moveCol) {
        int max = 0;
        int w = maze[0].length();
        int h = maze.length;
        char[][] board = new char[h][w];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                board[i][j] = maze[i].charAt(j);
            }
        }

        int[][] dist = new int[h][w];
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(startCol, startRow));

        while (!q.isEmpty()) {
            Point tmp = q.poll();

            for (int i = 0; i < moveRow.length; i++) {
                // 인접한 좌표 계산
                int nx = tmp.x + moveRow[i];
                int ny = tmp.y + moveCol[i];

                // 유효한 범위 내에 있는지와 방문 가능 여부 체크
                if (nx >= 0 && nx < w && ny >= 0 && ny < h &&
                        board[ny][nx] == '.' && dist[ny][nx] == 00) {
                    q.offer(new Point(nx, ny));
                    dist[ny][nx] = dist[tmp.y][tmp.x] + 1; // 거리 정보 업데이트
                }
            }
        }

        for (int[] x : dist) {
            for (int y : x) {
                max = Math.max(max, y);
            }
        }

        return max;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}