package winterclass1;

import java.util.*;
class Solution {
	int[][] pos,answer,h,y,g;
	int cnt=0;
	boolean flag= false;
	public int find (int i, int j ) {
		return (i/3) *3 + (j/3);
	}
	
	public void DFS(int L, int[][] board) { // L=레벨값: 0 이었던 값 개수 하나 채울 때마다 다음칸으로 넘어감. 
		if(flag) return;
		if(L==cnt) { 
			for(int i =0; i <9; i++) {
				for(int j=0; j<9; j++) {
					answer[i][j]= board[i][j]; // answer 배열에 board  복
				}
			}
		flag=true;
		}
		else {
			int xx= pos[0][L]; //빈 공간의 행번호 
			int yy= pos[1][L]; // 빈 공간 열번호 
			int gg=find(xx,yy); // 빈 공간 그룹번호 
			
			for (int i=1; i<=9; i++) {
				if(h[xx][i]==0 && y[yy][i]==0 && g[gg][i]==0) { // 값 탐
					h[xx][i] = y[yy][i] = g[gg][i] = 1;
					board[xx][yy]=i;
					DFS(L + 1, board);
					h[xx][i] = y[yy][i] = g[gg][i] = 0;
					board[xx][yy] = 0;
				}
			}
			
			
			
			
		}
		
	}
	public int[][] solution (int [][] board) {
		pos =new int[2][100]; // 비어있는 인덱스 저장용 배열. 
		answer= new int [9][9];
		h= new int [10][10];
		y=new int[10][10];
		g= new int [10][10];
		for (int i =0; i<9; i++) {
			for(int j =0; j<9; j ++) {
				if(board[i][j]==0) {
					pos[0][cnt]=i;
					pos[1][cnt++]=j;
					
				}
				else {
					h[i][board[i][j]]=1;
					y[j][board[i][j]]=1;
					g[find(i,j)][board[i][j]]=1;
				}
			}
		}
		DFS(0,board);
		return answer;
	}
	
	
    
    
   public static void main(String[] args){
		Solution T = new Solution();
		for(int[] x :(T.solution(
				new int[][]{{0, 2, 3, 0, 5, 0, 7, 8, 9}, 
				{0, 5, 6, 0, 8, 9, 1, 0, 3}, 
				{0, 8, 9, 1, 0, 3, 0, 5, 6}, 
				{0, 1, 0, 0, 6, 0, 8, 9, 0}, 
				{3, 0, 5, 0, 9, 7, 0, 1, 4}, 
				{0, 9, 7, 0, 1, 0, 0, 6, 5}, 
				{5, 3, 0, 6, 0, 2, 9, 7, 8}, 
				{6, 0, 2, 9, 0, 8, 5, 3, 1}, 
				{9, 0, 8, 0, 3, 0, 6, 0, 2}}))){
				System.out.println(Arrays.toString(x));
			};		
		
	}
}