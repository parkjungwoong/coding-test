import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();

        final String A = input[0];
        final String B = input[1];

        solution(A,B);
    }

    private static void solution(String A, String B) {
        if(B.equals(A)) System.out.println(0);
        else {
            final int ALen = A.length();
            final int BLen = B.length();

            int min = 50;
            int BstIndex = 0;
            while(BLen-ALen >= BstIndex) {
                int cnt = 0;
                for(int i=0; ALen>i; i++) {
                    if(A.charAt(i) != B.charAt(BstIndex+i)) cnt++;
                }
                BstIndex++;
                if(min > cnt) min = cnt;
            }
            System.out.println(min);
        }

    }
}
