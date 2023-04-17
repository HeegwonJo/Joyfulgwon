package org.example;

public class Array_mountain {
    //4방향 탐색을 위한 배열 선언 상우하좌 순
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] board = new int[][]{{5, 3, 7, 2, 3},
            {3, 7, 1, 6, 1},
            {7, 2, 5, 3, 4},
            {4, 3, 6, 4, 1},
            {8, 7, 3, 5, 2}};

    public static void main(String[] args) {
        Array_mountain T = new Array_mountain();
        System.out.println(T.solution(board));
    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPeak(i, j) == true) answer++;
            }
        }
        return answer;
    }
    //봉우리인지 확인해주는 함수
    public boolean isPeak(int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx=x+dx[k];
            int ny=y+dy[k];
            if (nx>=0 && nx< board.length && ny>=0 && ny< board.length &&board[x][y] < board[nx][ny]) return false;
        }
        return true;
    }
}
