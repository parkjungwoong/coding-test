import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1946 {
    public static void main(String[] args) throws Exception {
        new P1946().solution1();
    }

    private void solution1() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(bf.readLine());

        for(int i=0; T>i; i++) {
            final int N = Integer.parseInt(bf.readLine());

            List<Vo> voList = new ArrayList<>(N);

            //입력 값
            for(int j=0; N>j; j++) {
                String inputs[] = bf.readLine().split(" ");
                voList.add(new Vo(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1])));
            }

            //a 점수로 오름차순
            Collections.sort(voList);

            int result = 1;
            int maxB = voList.get(0).b;
            for(int j=1; N>j; j++) {
                if(voList.get(j).b < maxB) {
                    result++;
                    maxB = voList.get(j).b;
                }
            }

            //출력
            System.out.println(result);
        }
        bf.close();
    }

    class Vo implements Comparable<Vo>{

        Vo(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int a;
        int b;

        @Override
        public int compareTo(Vo o) {
            return Integer.compare(a, o.a);
        }
    }
}
