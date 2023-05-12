package org.example;


import java.util.LinkedList;
import java.util.Queue;

public class BFS_2 {
    static int answer=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 0, 0}};
    public static void main(String[] args) {

        BFS_2 P = new BFS_2();
        board[0][0]=1;
        DFS(0,0);
        System.out.println(P.solution(board));
        System.out.println(answer);
    }

    private int solution(int[][] board) {
        //첫번째 칸 (0,0) 에서 부터 1로 바꾸면서 사방탐색하고 한칸 지나가면 Q에 담음. 도착할 때 까지 moveCount ++하고 도착하면 리턴
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        //사방탐색 위한 배열 선언 좌상우하 순으로 탐색
        int[][] dist=new int[7][7];
        while (!Q.isEmpty()) {
            int[] cur=Q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                if (nX >= 0 && nY >= 0 && nX <= 6 && nY <= 6 && board[nX][nY]==0) {
                    Q.offer(new int[]{nX,nY});
                    board[nX][nY]=1;
                    dist[nX][nY]=dist[curX][curY]+1;
                }
            }
        }
        if(dist[6][6]!=0) return dist[6][6];
        return -1;
    }

    public static void DFS(int x, int y){
        //탈출조건
        if(x==6 && y==6) answer++;
        else {
            for(int i=0; i<4; i++){
                int nextX=x+dx[i];
                int nextY=y+dy[i];
                if (nextX >= 0 && nextY >= 0 && nextX <= 6 && nextY <= 6 && board[nextX][nextY]==0){
                    board[x][y]=1;
                    DFS(nextX, nextY);
                    board[x][y]=0;
                }
            }
        }
    }
}
