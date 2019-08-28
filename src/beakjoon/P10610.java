import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P10610 {
    public static void main(String[] args) throws IOException {
        //30의 배수가 각자리의 합이 3의 배수이고 0으로 끝나는것이라는 조건을 기본으로 풀이
        //solution1();//756 ms
        solution2();//164 ms
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        br.close();

        //조건1 : N => 10^5개의 숫자
        final int MAX = N.length();
        int[] nums = new int[10];
        int sum = 0;
        boolean noZero = true;

        for(int i=0; MAX>i; i++) {
            int temp = Integer.parseInt(N.substring(i,i+1));
            if(temp == 0) noZero = false;
            sum+=temp;
            nums[temp]++;
        }

        if(sum%3 == 0 && !noZero) {
            StringBuilder sb = new StringBuilder();

            for(int i=9; i>=0; i--) {
                while(nums[i] > 0) {
                    sb.append(i);
                    nums[i]--;
                }
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("-1");
        }

    }

    public static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        br.close();

        int len = N.length();
        List<Integer> eachNum = new ArrayList<>(len);

        int sum = 0;
        boolean noZero = true;

        for(int i=0; len>i; i++){
            int temp = Integer.parseInt(N.substring(i,i+1));
            if(temp == 0) noZero = false;
            eachNum.add(temp);
            sum+=temp;
        }

        if(sum%3 == 0 && !noZero) {
            eachNum.sort((o1,o2) -> o1.compareTo(o2)*-1);
            for(Integer e : eachNum) {
                System.out.print(e);
            }
        } else {
            System.out.println("-1");
        }
    }
}
