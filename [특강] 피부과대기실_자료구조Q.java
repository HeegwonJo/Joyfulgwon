package winterclass1;

import java.util.*;

class Solution {
	public int getTime(String time){ // 시간 쪼개서 분으로 환산하는 함수 
		int H = Integer.parseInt(time.split(":")[0]); // 시 
		int M = Integer.parseInt(time.split(":")[1]); // 분 
		return H*60+M;
	}
	
	public int solution (int[] laser, String[] enter) {
		int answer=0;
		int n= enter.length;
		int[][] inList =new int[n][2];
		Queue <Integer> Q= new LinkedList<>();
		for(int i=0; i<n; i++) {
			int a= getTime(enter[i].split(" ")[0]);
			int b= Integer.parseInt(enter[i].split(" ")[1]);
			inList[i][0]=a; //입장시간 분으로 환산 
			inList[i][1]=b; //레이저 종류 
		}
		
		Q.offer(inList[0][1]); // 첫번째 사람은 넣고 시작 
		int fT=inList[0][0]; // 시술 끝나는 시간 
		int pos=1; // 들어가는 사람 순서 
		for(int t=fT; t<=1200; t++) {
			
			if(pos<n && t==inList[pos][0]) { 
				if(Q.isEmpty() && inList[pos][0]>fT) fT=inList[pos][0];
				Q.offer(inList[pos][1]);
				pos++;
			}
			if(t==fT && !Q.isEmpty()) {
				int idx=Q.poll();
				fT+=laser[idx];
			}
			answer=Math.max(answer, Q.size());
		
		}
		
		
		
		return answer;
	
	
	
	
	}
		public static void main(String[] args){
			Solution T = new Solution();
			int[] arr= new int[] {30, 20, 25, 15};
			String[] arr1=new String[] {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"};
			int[] arr2= new int[] {30, 20, 25, 15};
			String[] arr3=new String[] {"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"};
			System.out.println(T.solution(arr,arr1));
			System.out.println(T.solution(arr2,arr3));
			
		}
	}