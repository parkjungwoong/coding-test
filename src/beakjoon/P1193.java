import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        int sum = 0;
        int startNum = 0;

        for(int i=1; X>sum; i++) {
            sum += i;
            startNum = i;
        }

        boolean isJaSu = startNum%2 == 0;

        int p = 1;
        int loop = X-(sum-startNum)-1;

        if(isJaSu) {
            System.out.println((p+loop) + "/" + (startNum-loop));
        } else {
            System.out.println((startNum-loop) + "/" + (p+loop));
        }
    }
}
