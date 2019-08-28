import java.util.Scanner;

public class P2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; 10 > i; i++) {
            System.out.println(N+" * "+i+" = "+N*i);
        }
    }
}
