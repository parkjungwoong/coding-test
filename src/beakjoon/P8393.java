import java.util.Scanner;

public class P8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;

        for(int i=0; n>i; i++){
            sum += (i+1);
        }

        System.out.println(sum);

    }
}
