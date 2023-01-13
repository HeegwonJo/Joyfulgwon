package winterclass1;

import java.util.*;
class Solution {
	int [] dy=new int[101];
	public int DFS(int start, String s) {
		if(dy[start]>0) return dy[start];
		if(start<s.length()&& s.charAt(start)=='0') return 0;
		if(start ==s.length()-1 ||start==s.length()) return 1;
		
		else {
			int res =DFS(start+1 ,s);
			int num= Integer.parseInt(s.substring(start,start+2));
			if(num<26)res+=DFS(start+2,s);
			
			
			return dy[start]=res;
		}
		
	}
	public int solution (String s) {
		int answer=0;
		
		answer = DFS(0,s);
		
		
		
		return answer;
	}
	
	
    
    
   public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution("25114"));
		//System.out.println(Arrays.toString(T.solution("255003")));
		//System.out.println(Arrays.toString(T.solution("155032012")));
	}
}