package winterclass1;

import java.util.*;


class Solution {
	int keys;
	
	public int solution(String[] board){

	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	int n=board.length;
	int m=board[0].length();
	char[][] map= new char[n][m];
	
	int cnt=0;
	for(int i =0; i<n; i++) {
		for(int j=0; j<m; j++) {
			char c=board[i].charAt(j);
			map[i][j]=c;
			if(c>=97 && c<=122)cnt++;
		}
	}
	
	int keys=(1<<cnt)-1;

	Queue<int[]> Q= new LinkedList<>();
	boolean[][][] ch= new boolean [n][m][keys+1];
	Q.offer(new int[] {0,0,0});
	ch[0][0][0]=true;
	
	int L=0;
	
	while(!Q.isEmpty()) {
		int size= Q.size();
		for(int i=0; i<size; i++) {
			int[] cur= Q.poll();
			for(int k=0; k<4; k++) {
				int x= cur[0]+dx[k];
				int y= cur[1]+dy[k];
				if(x<0||x>=n||y<0||y>=m||map[x][y]=='#') continue;
				char c=map[x][y];
				int ks= addKey(cur[2],(int)c);
				if(ks==keys)return L+1;
				if(ch[x][y][ks])continue;
				if(c>=65 && c<=90 &&!unlock(cur[2],(int)c)) continue;
				
				ch[x][y][ks]=true;
				Q.offer(new int[] {x,y,ks});	
			}	
			
		}
		L++;
	}
	
	return -1;
	}
	
	public int addKey(int keys, int c) {
		if(c>=97 && c<=122) {
			int index= c-97;
			return keys|(1<<index);
		}
		return keys;
	}
	
	public boolean unlock(int keys, int c) {
		int index=c-65;
		return(keys&(1<<index))>0;
		
	}
	
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"..a.b", "###B#", "..#A.", ".cC..", "....."}));
		System.out.println(T.solution(new String[]{"..a..", "###.#", "b.A.B"}));
	}
}
//.: 빈땅, #: 벽 ,소문자: 열쇠, 대문자: 자물쇠 열쇠가 있으면 자물쇠를 열 수 있음 모든 열쇠를 가지기 위한 최단거리 경로 구하기  