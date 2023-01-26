package winterclass1;

import java.util.*;


class Solution {
	int[]pow, student;
	int N, answer;
	Stack<Integer> st=new Stack<>();
	public void DFS (int s, int sum, int T) {
		Boolean flag=true;
		for(int i=0; i<N; i++) {
			if((sum & student[i])==student[i]) {
				flag=false;
				break;
			}
		}
		if(flag) {
			answer++;
		}
		for(int i=s; i<=T; i++) {
			DFS(i+1,sum+pow[i],T);
		}
	}
	
	
	public int solution(int T, int[][] hate){
		answer=0;
		pow=new int[T+1];
		pow[1]=1;
		N=hate.length;
		student= new int[100];
		for(int i=2; i<pow.length; i++) {
			pow[i]=pow[i-1]*2;
		}
		for(int i=0; i<N; i++) {
			for(int x: hate[i]) {
				student[i]+=pow[x];
			}
		}
		
		
		DFS(1,0,T);
	
		
		return answer;
	}
	
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(6,new int[][]{{1}, {4, 2}, {3, 2, 6}, {5}, {3, 4, 6}}));
	}
}