package javaCodingTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class P12891_DNA비밀번호 {

	
	static int checkArr[];
	static int myArr[];
	static int chPassword;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result=0;
		char A[]=new char[S];
		checkArr = new int[4];
		myArr= new int[4];
		chPassword=0;
		
		A=bf.readLine().toCharArray();
		st=new StringTokenizer(bf.readLine());
		
		for(int i=0; i<4; i++) {
			checkArr[i]=Integer.parseInt(st.nextToken());
			if(checkArr[i]==0)chPassword++;
		}
		for(int i=0;i<P; i++) {
			Add(A[i]);
		}
		if(chPassword ==4 ) Result++;
		
		for(int i=P; i<S; i++) {
			int j= i-P;
			Add(A[i]);
			Remove(A[j]);
			
			if(chPassword==4) Result++;
		}
		System.out.println(Result);
		bf.close();
		
		
		

	}
	
	private static void Add(char c) {
		switch(c) {
		case 'A':
			myArr[0]++;
			if(myArr[0]==checkArr[0])chPassword++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1]==checkArr[1])chPassword++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2]==checkArr[2])chPassword++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3]==checkArr[3])chPassword++;
			break;
		}
		
		
	}
	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if(myArr[0]==checkArr[0]) chPassword--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1]==checkArr[1]) chPassword--;
			myArr[0]--;
			break;
		case 'G':
			if(myArr[2]==checkArr[2]) chPassword--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3]==checkArr[3]) chPassword--;
			myArr[3]--;
			break;
		}
		
		
		
		
		
	}

}
