import java.util.*;


class Solution {
	
	public int solution(int[][] apple, int s, int k){
		
		
		Map <Integer, Integer> map=new HashMap<>();
		for(int [] x:apple) {
			map.put(x[0],x[1]);
		}
		int[] maxL=new int [k+1];
		int[] maxR=new int [k+1];
		maxL[0]=map.getOrDefault(s, 0);
		maxR[0]=map.getOrDefault(s, 0);
		int answer=maxL[0];
		
		for(int i=1; i<=k; i++) {
			if(s-i>=0) {
				maxL[i]=maxL[i-1]+map.getOrDefault(s-i, 0);
					}
			else {
				maxL[i]=maxL[i-1];
			}
			answer=Math.max(answer, maxL[i]);
			maxR[i]=maxR[i-1]+map.getOrDefault(s+i, 0);
			answer=Math.max(answer, maxR[i]);
		}
		for(int j=1; j<(k+1)/2;j++) {
			answer=Math.max(answer, maxL[j]+maxR[k-2*j]-maxR[0]);
			answer=Math.max(answer, maxR[j]+maxL[k-2*j]-maxL[0]);
			
		}
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{0, 10}, {2, 3}, {5, 8}, {6, 5}, {8, 6}, {9, 5}, {10, 2}, {12, 3}},7,5));

	}
}
