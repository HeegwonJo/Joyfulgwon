package winterclass1;

import java.util.*;

public class Solution {
	
	 
	
	public String[] solution(String[] subjects, String[] course){
		
		int n= subjects.length;
		int[] indegree= new int[n];
		String[] answer= new String[n];
		HashMap<String,Integer> map= new HashMap <>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0; i<n; i++ ) map.put(subjects[i], i);
		
		for(int i=0; i<n; i++) graph.add(new ArrayList<Integer>());
		
		for(String x: course) {
			int a= map.get(x.split(" ")[0]);
			int b= map.get(x.split(" ")[1]);
			graph.get(b).add(a);
			indegree[a]++;
		}
		
		Queue<Integer> Q = new LinkedList<>();
		ArrayList<Integer> order = new ArrayList<>();
		System.out.println(Arrays.toString(indegree));
		
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) Q.offer(i);
		}
		while(!Q.isEmpty()) {
			int pre=Q.poll();
			order.add(pre);
			for(int x:graph.get(pre)) {
				indegree[x]--;
				if(indegree[x]==0) Q.offer(x);
				
			}
		}
		for(int i=0; i<order.size(); i++) {
			answer[i]=subjects[order.get(i)];
		}
		return answer;
	}
	
	public static void main(String[] args){
		Solution T = new Solution();
		
		System.out.println(Arrays.toString(T.solution(new String[] {"english", "math", "physics", "art", "music"},new String[] {"art math", "physics art", "art music", "physics math", "english physics"})));

	}
}
