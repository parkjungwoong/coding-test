import java.util.Scanner;

/**
 * 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
 * 예제 입력 1
 * 1 3
 * 예제 출력 1
 * 0.33333333333333333333333333333333
 */
public class P1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println((double)A/B);
    }
}
