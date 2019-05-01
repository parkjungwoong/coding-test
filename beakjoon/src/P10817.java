import java.util.Scanner;

public class P10817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int[] num = {num1,num2,num3};

        int max = num[0];
        int maxIndex = 0;

        for(int i=0; num.length>i; i++){
            if(num[i] >= max) {
                max = num[i];
                maxIndex = i;
            }
        }

        num[maxIndex] = 0;

        max = 0;

        for(int i=0; num.length>i; i++){
            if(num[i] >= max) {
                max = num[i];
            }
        }


        System.out.println(max);
    }
}
