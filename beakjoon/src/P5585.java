import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int pay = 1000;
        final int[] rs = {500,100,50,10,5,1};

        final int cost = Integer.parseInt(br.readLine());
        br.close();

        int r = pay-cost;

        int cnt = 0;
        int i=0;

        while (r > 0) {
            if(r >= rs[i]) {
                cnt += r/rs[i];
                r = r%rs[i];
            }
            i++;
        }

        System.out.println(cnt);

    }
}
