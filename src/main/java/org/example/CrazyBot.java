package org.example;

public class CrazyBot {
    boolean[][] visited = new boolean[100][100];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    double[] prob = new double[4];

    public static void main(String[] args) {
        CrazyBot C = new CrazyBot();
        System.out.println(C.getProbability(1,25,25,25,25));

    }

    public double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;
        return dfs(50, 50, n);
    }

    double dfs(int x, int y, int n) {
        if (visited[x][y]) return 0;
        if (n == 0) return 1;

        visited[x][y]=true;
        double ret = 0 ;
        for(int i =0; i<4; i++){
            ret+= dfs(x+dx[i], y+dy[i], n-1) * prob[i];
        }
        visited[x][y]=false;

        return ret;
    }
}
