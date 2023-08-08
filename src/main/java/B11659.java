import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sums[] = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }
        B11659 T = new B11659();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(T.solution(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),sums));
        }

    }

    public int solution(int s, int e, int[] sums) {
        return sums[e]-sums[s-1];
    }
}
