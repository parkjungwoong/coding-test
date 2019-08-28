import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = sc.nextInt();
        String numberStr = sc.next();

        int sum = 0;

        for(int i=0; loop>i; i++) {
            sum += Integer.parseInt(numberStr.charAt(i)+"");
        }

        System.out.println(sum);

    }
}