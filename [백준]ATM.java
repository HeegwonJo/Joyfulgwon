import java.util.*;
class Solution {
    	
    public int solution(int n, int[] order) {
    	int answer = 0;
    	int sum=0;
    	Arrays.sort(order);
    	
    	System.out.println(Arrays.toString(order));
    	        
    	for(int i=0; i<order.length; i++) {
    		sum+=order[i];
    		answer+=sum;
    	}       
    	return answer;
    	    
        
    }
    
   public static void main(String[] args){
		Solution T = new Solution();
		int[] arr = new int[]{3,1,4,3,2};

		
		
		System.out.println(T.solution(5,arr));

		
		
	}
}