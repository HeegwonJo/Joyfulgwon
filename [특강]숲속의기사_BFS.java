package winterclass1;

import java.util.*;


class Solution {
	
	public int solution (int [][] board) {
		int answer=Integer.MAX_VALUE;
		int[] dx=new int[] {-1,0,1,0};
		int[] dy=new int[] {0,1,0,-1};
		int n= board.length;// 좌표 가로길이 
		int m= board[0].length;// 좌표 세로 길이 
		int [][] dist= new int [n][m]; // 거리 담을 배열 선언 
		Queue<int[]> Q = new LinkedList<>(); // 방문위치 담을큐 
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(board[i][j]==2 || board[i][j]==3) { // 기사나 영희 만나면 
					Q.offer(new int[] {i,j}); // 현 위치 큐에 담고 
					int[][] ch= new int[n][m]; // 체크 배열 만들어서 체크 (반복문 안에서 초기화 해야함 )
					ch[i][j]=1;
					int L=0;
					while(!Q.isEmpty()) {
						int len =Q.size();
						L++;
						for(int r=0; r<len; r++) {
							int[] cur=Q.poll();
							for(int k=0; k<4; k++) { // 4방 탐색 
								int nx= cur[0]+dx[k];
								int ny= cur[1]+dy[k];
								if(nx>=0&& nx<n &&ny>=0 &&ny<m && board[nx][ny]!=1) { 
									if(ch[nx][ny]==0) {
										ch[nx][ny]=1;
										dist[nx][ny]+=L;
										Q.offer(new int[] {nx,ny});
									}
								}
							}
						}
							
					}
				}
			}
		}
	
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(board[i][j] == 4 && dist[i][j] > 0){
					answer = Math.min(answer, dist[i][j]);
				}
			}
		}
		return answer;
	}
		public static void main(String[] args){
			Solution T = new Solution();
			System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4}, 
													{0, 1, 1, 0, 0, 0, 1, 0}, 
				{0, 1, 4, 0, 1, 0, 0, 0}, 
				{0, 0, 0, 1, 0, 0, 0, 0}, 
				{1, 0, 1, 0, 0, 1, 1, 0}, 
				{4, 0, 0, 0, 1, 0, 0, 0}, 
				{4, 1, 0, 0, 1, 0, 0, 0}, 
				{4, 0, 0, 0, 0, 0, 1, 2}}));
		}
	}