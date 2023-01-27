package winterclass1;

import java.util.*;

public class Solution {
	
	
	public int solution(int[][]board, int[] s, int[] e){
		int answer=0;
		int[] dx=new int[] {-1,0,1,0}; 
		int[] dy=new int[] {0,1,0,-1};
	
		int n=board.length;
		int m=board[0].length;
		boolean[][] visited= new boolean[n][m];
		int L=0;
		
		PriorityQueue<int[]> pQ= new PriorityQueue<>((a,b)->a[2]-b[2]);
		pQ.offer(new int[]{s[0],s[1],0});
		while(!pQ.isEmpty()) {
			int[] cur= pQ.poll();
			visited[cur[0]][cur[1]]= true;
			
			if(cur[0]==e[0] &&cur[1]==e[1]) return cur[2];
			
			for(int k=0; k<4; k++) {
				int x= cur[0];
				int y= cur[1];
				int len=cur[2];
				
				while(x>=0 && x<n && y>=0 && y<m && board[x][y]==0) {
					x+=dx[k];
					y+=dy[k];
					len++;
				}
				
				x-=dx[k];
				y-=dy[k];
				len--;
				
				if(!visited[x][y]) {
				
					pQ.offer(new int[] {x,y,len});
				}
			
				
			}
		}
			
		
		
		return -1;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		int[][] arr=new int[][] {{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}};
		
		System.out.println(T.solution(arr,new int[] {1,0},new int[] {4,5}));

	}
}
