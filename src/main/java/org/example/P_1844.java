package org.example;
import java.util.*;
public class P_1844 {
    public static void main(String[] args){
        P_1844 P = new P_1844();
        System.out.println(P.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }


    public int solution(int[][] maps) {

        int n= maps.length;
        int m= maps[0].length;
        int[] dx= new int[] {-1,0,1,0};
        int[] dy=new int[] {0,1,0,-1};
        int[][] dis=new int[n][m];
        Queue<Point> q= new LinkedList<>();
        q.offer(new Point(0,0));
        maps[0][0]=0;
        while(!q.isEmpty()){
            Point tmp=q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<5 && ny>=0 && ny<5 && maps[nx][ny]==1){
                    maps[nx][ny]=0;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }

        System.out.println(Arrays.deepToString(dis));
        if(dis[n-1][m-1]==0) return -1;
        return dis[n-1][m-1]+1;
    }
}
class Point{
    public int x;
    public int y;

    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
