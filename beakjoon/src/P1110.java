import java.util.Scanner;

public class P1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        int cycle = 0;

        int temp = N;

        while (true) {
            cycle++;

            int f;
            int b;

            if(temp < 10) {
                f = 0;
                b = temp;
            } else {
                f = temp/10;
                b = temp%10;
            }

            int sum = f+b;
            temp = b*10 + sum%10;

            if(N == temp) break;

        }

        System.out.println(cycle);

    }
}
