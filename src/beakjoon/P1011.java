package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1011 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int TEST_CNT = Integer.parseInt(br.readLine());

        for(int i=0; TEST_CNT>i; i++){
            int[] testCase = getTestCase(br);

            int x = testCase[0];
            int y = testCase[1];
            int dist = y-x;
            int xS = 1;
            int yS = 1;
            int moveCnt = 0;

            //이동 횟수만 구하기
            while (true){
                moveCnt++;
                dist -= xS;
                xS++;
                if(0 >= dist) break;

                moveCnt++;
                dist -= yS;
                yS++;
                if(0 >= dist) break;
            }

            System.out.println(moveCnt);
        }

        br.close();

    }

    private static int[] getTestCase(BufferedReader br) throws IOException{

        int[] testCase = new int[2];

        String[] inputs = br.readLine().split(" ");

        testCase[0] = Integer.parseInt(inputs[0]);
        testCase[1] = Integer.parseInt(inputs[1]);

        return testCase;
    }
}
