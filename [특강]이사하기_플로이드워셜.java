package winterclass1;

import java.util.*;



class Solution {
	
	
	public String solution(String[] cities, String[] roads, String[] cars, String customer){
		String answer = "";
		int n = cities.length;
		HashMap<String, Integer> node = new HashMap<>();
		for(int i = 0; i < n; i++) node.put(cities[i], i);
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(dist[i],1000000000);
			dist[i][i] = 0;
		}
		for(String x : roads){
			int a = node.get(x.split(" ")[0]);
			int b = node.get(x.split(" ")[1]);
			int c = Integer.parseInt(x.split(" ")[2]);
			dist[a][b] = c;
			dist[b][a] = c;
		}
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(dist[i][k] + dist[k][j] < dist[i][j]){
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		ArrayList<ArrayList<int[]>> carList =new ArrayList<>();
		for(int i=0; i<n; i++)carList.add(new ArrayList<int[]>());
		for(String x: cars) {
			int a=node.get(x.split(" ")[0]);
			int b=Integer.parseInt(x.split(" ")[1]);
			int c=Integer.parseInt(x.split(" ")[2]);
			carList.get(a).add(new int[] {b,c});
		}
		
		for (int i=0; i<n; i++) carList.get(i).sort((a,b)->a[0]-b[0]);
		int s=node.get(customer.split(" ")[0]);
		int e=node.get(customer.split(" ")[1]);
		int g=Integer.parseInt(customer.split(" ")[2]);
		int minCost=Integer.MAX_VALUE;
		int num=-1;
		for(int i = 0; i < n; i++){
			int dis = dist[i][s] + dist[s][e];
			if(dis >= 100000000) continue;
			int idx = lower_bound(carList.get(i), g);
			if(idx >= carList.get(i).size()) continue;
			int cost = carList.get(i).get(idx)[1];
			cost *= dis;
			if(cost < minCost){
				minCost = cost;
				num = i;
			}
			else if(cost == minCost && cities[i].compareTo(cities[num]) < 0) num = i;
		}
		answer = cities[num];
		return answer;
	}
	
	
	public int lower_bound(ArrayList<int[]> list, int target){
		int left = 0;
		int right = list.size();
		while(left < right){
			int mid = (left + right) / 2;
			if(list.get(mid)[0] < target) left = mid + 1;
			else right = mid;
		}
		return right;
	} 
	
	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"rome", "busan", "daegu"}, new String[]{"rome busan 1", "rome daegu 1", "busan daegu 2"}, new String[]{"rome 50 10", "busan 100 20", "daegu 40 8"}, "busan daegu 40"));
	}
}