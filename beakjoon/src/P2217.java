import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> ropeW = new ArrayList<>(N);

        for(int i=0; N>i; i++){
            ropeW.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        ropeW.sort((o1,o2)-> o1.compareTo(o2));

        int maxW = ropeW.get(0)*N;

        for(int i=1; N>i; i++) {
            int ropeMaxW = ropeW.get(i)*(N-i);
            if(ropeMaxW > maxW){
                maxW = ropeMaxW;
            }
        }

        System.out.println(maxW);
    }
}
