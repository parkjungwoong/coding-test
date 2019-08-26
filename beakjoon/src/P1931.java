import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Stet> list = new ArrayList<>(N);

        for(int i=0; N>i; i++) {
            String[] inputs = br.readLine().split(" ");
            list.add(new Stet(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }
        br.close();

        //sorting
        list.sort((o1,o2)-> {
            if(o1.getEt() > o2.getEt()) return 1;
            else if(o1.getEt() < o2.getEt()) return -1;
            else if(o1.getEt() == o2.getEt() && o1.getSt() > o2.getSt()) return 1;
            else return -1;
        });

        int count = 0;

        int i = 0;
        aa : while (N > i) {
            int preEt = list.get(i).getEt();

            for(int j=i+1; N>j; j++) {
                int curSt = list.get(j).getSt();
                if(curSt >= preEt) {
                    count++;
                    i=j;
                    continue aa;
                }
            }
            count++;
            break;
        }

        System.out.println(count);
    }

    public static class Stet {
        private int st;
        private int et;

        public Stet(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int getSt() {
            return st;
        }

        public int getEt() {
            return et;
        }
    }
}
