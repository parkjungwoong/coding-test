import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loopCnt = Integer.parseInt(br.readLine());

        int[] num = new int[loopCnt];

        for(int i=0; loopCnt>i; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for(int i=0; loopCnt-1>i; i++){

            for(int j=i; num.length>j; j++){
                if(num[i] > num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for(int e : num) {
            System.out.println(e);
        }
    }
}
