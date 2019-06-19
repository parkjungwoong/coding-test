import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        br.close();

        int N = Integer.parseInt(inputs[0]);//여학생
        int M = Integer.parseInt(inputs[1]);//남학생
        int K = Integer.parseInt(inputs[2]);//인턴수
        int notGroup;//그룹이 없는 사람 수
        int result = 0;

        int NgroupCnt = N/2;//여학생 그룹
        notGroup = N%2;

        for(int i=0; NgroupCnt>i && M>0; i++) {
            M--;
            result++;
        }

        notGroup += M + ((NgroupCnt-result)*2);

        int internCnt = notGroup;

        while (K>internCnt) {
            result--;
            internCnt+=3;
        }

        System.out.println(result);
    }
}
