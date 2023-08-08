package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B28278 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        B28278 T = new B28278();
        stack = new Stack<Integer>();
        for(int i = 0; i < N; i++) {
            System.out.println(T.solution(br.readLine()));
        }
    }

    public int solution(String operation){

        if (operation.startsWith("1")) {
            StringTokenizer st = new StringTokenizer(operation, " ");
            stack.push(Integer.parseInt(st.nextToken()));
            return 0;
        }

        return 0;
    }

}
