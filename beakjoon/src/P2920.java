import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
 *
 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
 *
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
 *
 * 첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
 */
public class P2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final String input = bf.readLine();
        final String[] inArr = input.split(" ");

        boolean flag = true;

        for(int i=1; 8>=i; i++) {
            if(!inArr[i-1].equals(i+"")) {
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("ascending");
            return;
        }

        flag = true;
        for(int i=8; i>0; i--) {
            if(!inArr[8-i].equals(i+"")) {
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("descending");
            return;
        } else {
            System.out.println("mixed");
        }

    }
}
