import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        final int testCaseCount = Integer.parseInt(bf.readLine());

        for(int i=0; testCaseCount>i; i++) {
            final int k = Integer.parseInt(bf.readLine()); //층
            final int n = Integer.parseInt(bf.readLine()); //호수

            int[] row = new int[n];

            for(int j=1; n>=j; j++){
                row[j-1] = j;
            }

            //0층 -> 1~14호
            for(int a=1; k>=a; a++) { //층
                int[] row2 = new int[n];

                for(int b=1; n>=b; b++) { //호

                    for(int j=0; b>j; j++) {
                        row2[b-1]+=row[j];
                    }
                }
                row = row2;
            }

            System.out.println(row[n-1]);

        }
        bf.close();
    }
}
