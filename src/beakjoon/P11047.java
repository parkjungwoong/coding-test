import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]); //동전의 종류 개수
        int k = Integer.parseInt(inputs[1]); //가치
        int a[] = new int[n];//동전의 종류

        for(int i=0; n>i; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        int count = 0;

        int i = n;
        while (k > 0) {
            i--;
            if(i >= 0 && k >= a[i]) {
                count+=k/a[i];
                k = k%a[i];
            }
        }

        System.out.println(count);

    }
}
