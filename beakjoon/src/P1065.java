import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class P1065 {

    private static List<Integer> list = new ArrayList<>(1001);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int count = 0;

        for(int i=1; X>=i; i++) {
            setEachNum(i);
            if(ch()) count++;
        }

        System.out.println(count);
    }

    private static int setEachNum(int number) {
        if(number < 10) {
            list.add(number);
            return number;
        }
        else {
            list.add(number%10);
            return setEachNum(number/10);
        }
    }

    private static boolean ch() {

        for(int i=0; list.size()-2>i; i++){
            int f = list.get(i) - list.get(i+1);
            int b = list.get(i+1) - list.get(i+2);

            if(f != b) {
                list.clear();
                return false;
            }
        }

        list.clear();
        return true;
    }
}
