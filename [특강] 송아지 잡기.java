package winterclass1;

import java.util.*;
class Solution {
	
	public int solution (int s, int e) {
		int answer =0;
		Queue<Integer> Q= new LinkedList<>();
		int [][] ch= new int[2][10001];
		int L=0;
		ch[0][s]=1;
		Q.offer(s);
		
		while(!Q.isEmpty()){
			int len=Q.size();
			L++;
			for(int i=0; i<len; i++){
				int x=Q.poll();
				for(int nx : new int[]{x+1, x-1, x*2}){
					if(nx>0 && nx<=2000000 && ch[L%2][nx]==0 ){
						ch[L%2][nx]=1;
						Q.offer(nx);
						}	
					
				}
			}
			e+=L;
			if(e>200000) return -1;
			if(ch[L%2][e]==1) return L;
		}
		return answer;
	}
	
	
    
    
   public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(1,11));
		System.out.println(T.solution(10,3));
		
	}
}