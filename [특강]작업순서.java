package winterclass1;

import java.util.*;



class Solution {
	
	
	public int[] solution (int[][] tasks) {
		
		//linkedlist 로 소트 Q에서 뽑아내면 curT+= 작업시간 
		PriorityQueue<int[]> pQ=new PriorityQueue<>((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
		ArrayList<Integer> res = new ArrayList<>();
		LinkedList <int[]> List = new LinkedList<>();
		int n=tasks.length;
		for(int i=0; i<tasks.length; i++) {
			List.add(new int[] {tasks[i][0],tasks[i][1],i});
		}
		List.sort((a,b)->a[0]-b[0]);
		int curT=0;
		
		while(!List.isEmpty()|| !pQ.isEmpty()) {
			if(pQ.isEmpty()) curT=Math.max(curT, List.peek()[0]);
			while(!List.isEmpty() && List.peek()[0]<=curT) {
				int[] x= List.pollFirst();
				pQ.add(new int[] {x[1],x[2]});
			}
			
			int[] e = pQ.poll();
			curT=curT + e[0];
			res.add(e[1]);
			
		}
		int[] answer= new int[n];
		for(int i=0; i<n; i++) answer[i]=res.get(i);
		
		return answer;
	
	
	}
		public static void main(String[] args){
			Solution T = new Solution();
			int[][] arr= new int[][] {{2, 3}, {1, 2}, {4, 2}, {3, 1}};
			System.out.println(Arrays.toString(T.solution(arr)));
			
		}
	}