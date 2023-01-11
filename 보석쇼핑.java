package winterclass1;

import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[] {1,gems.length}; // 제일 길게 초기
        HashMap<String, Integer> hm= new HashMap<>(); // 보석 개수 체
        HashSet<String> hs= new HashSet<>(Arrays.asList(gems));// hashset은 중복저장이 안되니까 보석개수 알아보기 쉬
        
        int lt=0; // 왼쪽포인터 
        int k=hs.size(); // 보석 종류 개
       
            
        for (int rt=0; rt<gems.length; rt++) { // 오른쪽 밀고가면서 보석 하나 나올 때마다 해
        	hm.put(gems[rt], hm.getOrDefault(gems[rt], 0)+1);
        	while(hm.size()==k) { //보석 종류 다 있을 때까
        		hm.put(gems[lt], hm.getOrDefault(gems[lt], 0)-1); //왼쪽 포인터 옮겨주면서 하나씩 지워줌 만약 value가 0이면 키 삭
        		if(answer[1] - answer[0] > rt - lt) {
                    answer = new int[]{lt + 1, rt + 1};
                }
        		if(hm.get(gems[lt])==0) hm.remove(gems[lt]);
        		lt++;
        		
        		
        	}
        }
        
       
        
        return answer;
        
        
    }
    
   public static void main(String[] args){
		Solution T = new Solution();
		String[] arr = new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] arr1 = new String[]{"AA", "AB", "AC", "AA", "AC"};
		String[] arr2 = new String[]{"XYZ", "XYZ", "XYZ"};
		
		System.out.println(Arrays.toString(T.solution(arr)));
		System.out.println(Arrays.toString(T.solution(arr1)));
		System.out.println(Arrays.toString(T.solution(arr2)));
		
	}
}