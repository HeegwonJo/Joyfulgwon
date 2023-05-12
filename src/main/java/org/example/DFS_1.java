package org.example;
import java.util.*;

public class DFS_1 {
    int[][] dislikes;
    int count;
    int[] visited;
    public int solution(int[][] fight) {
        dislikes = new int[8][8];
        for (int[] dislike : fight) {
            dislikes[dislike[0]][dislike[1]] = 1;
            dislikes[dislike[1]][dislike[0]] = 1;
        }
        for(int i=0; i<8; i++){
            dislikes[i][0]=1;
            dislikes[0][i]=1;
        }
        System.out.println(Arrays.deepToString(dislikes));
        count = 0;
        visited = new int[8];
        dfs(1);

        return count;
    }

    public void dfs(int student) {
        if (student == 8) {
            count++;
            return;
        }


        for (int i = 1; i <= 7; i++) {
            if (dislikes[student][i] == 0 && visited[i]==0 ) {
                visited[i] = 1;
                dfs(student + 1);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        DFS_1 T = new DFS_1();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
    }
}