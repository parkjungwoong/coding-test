import java.util.Scanner;

public class P2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=1; N>=i; i++){
            for(int j=0; N-i>j; j++){
                System.out.print(" ");
            }
            for(int j=0; i>j; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
