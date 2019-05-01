import java.util.Scanner;

public class P10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int min = sc.nextInt();

        int[] numbers = new int[count];

        for(int i=0; count>i; i++){
            numbers[i] = sc.nextInt();
            if(min > numbers[i]) {
                System.out.print(numbers[i]+" ");
            }
        }
    }
}
