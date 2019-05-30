import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(bf.readLine());
        String[] inputs = bf.readLine().split(" ");
        bf.close();

        int[] times = new int[inputs.length];
        for(int i=0; inputs.length>i; i++) {
            times[i] = Integer.parseInt(inputs[i]);
        }

        for(int i=0; cnt>i; i++) {
            for(int j=i+1; cnt>j; j++) {

                if(times[i] > times[j]) {
                    int temp = times[j];
                    times[j] = times[i];
                    times[i] = temp;
                }
            }
        }

        int totalTime = 0;
        int allTime = 0;
        for(int e : times) {
            totalTime += e;
            allTime += totalTime;
        }
        System.out.println(allTime);
    }
}
