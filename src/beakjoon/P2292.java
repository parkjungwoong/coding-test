import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 벌집 문제
 *
 * 1을 중심으로 원으로 생각하면 쉬움, 한 원에서 다른 원으로 이동할때 count 증가하면됨
 * 원의 시작은 2부터 6의배수로 증가
 */
public class P2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int count = solution2(N);

        System.out.println(count);
    }

    //더 빠른거
    private static int solution2(final int N) {
        int count = 1;
        int number = 1;

        while(number < N) {
            count++;
            number += 6*count;
        }

        return count;
    }

    //처음 푼거
    private static int solution1(final int N) {
        int count = 0;
        int loopCnt = 6;
        int number = 1;

        while(N != number){
            count++;

            for(int i=0; loopCnt>i; i++){
                number++;

                if(N == number) break;
            }
            loopCnt+=6;
        }

        return count+1;
    }
}
