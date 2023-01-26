package winterclass1;

import java.util.*;


class Solution {
	
	
	public int solution(String[] s, int k){
	int answer=0;
	HashMap<Character, Integer> map = new HashMap<>();
	int n=s.length;
	int m= 1<<n;
	
	for(int i=0; i<m; i++) {
		int shift=0;
		int sum=0;
		for(int j=0; j<n; j++) {
			if((i&1<<j)==0) continue;
			int score=s[j].length();
			for(char x : s[j].toCharArray()) {				
				if(x==' ') continue;
				if(x>='A' && x<='Z') { 
					x=(char)(x+32);
					shift=1;
					score++; 
					
				}
				map.put(x, 1);
			}
			sum+=score;
		}
		if(map.size()+shift<=k) answer = Math.max(answer, sum);
		map.clear();
	}
	
	
	
	return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"Ges Big", "Ges in Big", "Big size", "Ges size"},7));
	}
}