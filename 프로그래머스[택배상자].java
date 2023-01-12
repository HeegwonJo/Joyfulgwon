package winterclass1;

import java.util.*;
class Solution {
    	
    	    public int solution(int[] order) {
    	        int answer = 0;
    	        int i=0;
    	        
    	        //보조컨베이어 벨트는 LIFO라고 설명하니까 스택을 떠올리
    	        Stack<Integer> st= new Stack<>();
    	        for(int box=1; box<=order.length; box++){
    	            if(order[i]!=box){
    	                st.add(box);
    	                continue;
    	            }
    	            answer++;
    	            i++;
    	            
    	            while (st.isEmpty()&&st.peek()==order[i]) {
    	            	st.pop();
    	            	answer++;
    	            	i++;
    	            }
    	                
    	        }
    	        
    	        return answer;
    	    
        
    }
    
   public static void main(String[] args){
		Solution T = new Solution();
		int[] arr = new int[]{4, 3, 1, 2, 5};
		int[] arr1 = new int[]{5, 4, 3, 2, 1};
		
		
		System.out.println(T.solution(arr));
		System.out.println(T.solution(arr1));
		
		
	}
}