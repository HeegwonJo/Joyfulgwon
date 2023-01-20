package winterclass1;

import java.util.*;
class Grade implements Comparable<Grade>{
	public Character grade;
	public int num;
	
	Grade(char grade, int num){
		this.grade=grade;
		this.num=num;
	}
	@Override
	public int compareTo(Grade ob) {
		return ob.num-this.num;
	}
	
}

class Solution {
	
	public String solution (String s) {
		String answer=" ";
		PriorityQueue <Grade> pQ= new PriorityQueue<>();
		HashMap <Character,Integer> map = new HashMap<>();
		
		for(char x: s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		
		for (Character key: map.keySet() ) {
			pQ.add(new Grade(key,map.get(key)));
		}
		
		while(pQ.size()>1) {
			Grade tmp1=pQ.poll();
			Grade tmp2=pQ.poll();
			answer+=tmp1.grade;
			answer+=tmp2.grade;
			if(tmp1.num>1)pQ.add(new Grade(tmp1.grade,tmp1.num-1));
			if(tmp2.num>1)pQ.add(new Grade(tmp2.grade,tmp2.num-1));
			
		}
		
		if(pQ.size()==1)answer+=pQ.poll().grade;
		
		return answer;
	}
		public static void main(String[] args){
			Solution T = new Solution();
			System.out.println(T.solution("AAABBCDEFFG"));
			System.out.println(T.solution("ABCDEFGAAABDEFGFFGE"));
		}
	}