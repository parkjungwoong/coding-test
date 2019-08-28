import java.util.Scanner;

public class P11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        String sumStr = "";

        for(int i=0; str.length()>i; i++){
            if(i != 0 && i%10 == 0){
                System.out.println(sumStr);
                sumStr = "";
            }
            sumStr += str.charAt(i);
        }
        System.out.println(sumStr);
    }
}
