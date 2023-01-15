package winterclass1;

import java.util.*;
class Solution {
	LinkedList<String> tmp;
	ArrayList<String> res;
	
	public void DFS(int start, String s) {
		
		if(tmp.size()==4 && start==s.length()) {
			String Ts = ""; //임시 문자열 선언하고 점찍기 
			for(String x : tmp) Ts += x+".";
			res.add(Ts.substring(0, Ts.length()-1)); // 마지막에도 점이 들어가니까 한칸 앞까지만 점찍기 
			
		}
		
		else {
			for (int i = start; i<s.length(); i++) {
				if(s.charAt(start)=='0'&& i > start) return;// 맨 앞자리가 0인경우 예외처리 
				String num= s.substring(start, i+1);
				if(Integer.parseInt(num)>255) return;
				tmp.add(num);
				DFS(i+1,s);
				tmp.pollLast();
				
			}
		}
		
		
	}
	public String[] solution (String s) {
		tmp = new LinkedList<>();
	    res =new ArrayList<>();
	
		DFS(0,s); // 재귀함수 호출 
		String[] answer= new String[res.size()]; //answer 초기화 DFS의 동작이 끝나고 초기화 해야함 
		for(int i=0; i<res.size(); i++) answer[i]=res.get(i);
		return answer;
	}
	
	
    
    
   public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("2025505")));
		//System.out.println(Arrays.toString(T.solution("255003")));
		//System.out.println(Arrays.toString(T.solution("155032012")));
	}
}