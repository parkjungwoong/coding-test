package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 가장 큰 수
 */
public class P42746 {
    public static void main(String[] args) {
//        int[] test = new int[]{6,10,2};
        int[] test = new int[]{0,0,0};

        System.out.println(solution(test));
    }

    public static String solution(int[] numbers) {
        String answer;

        List<String> strings = new ArrayList<>(numbers.length);

        for(int n : numbers) {
            strings.add(String.valueOf(n));
        }

        strings.sort((String a, String b) -> (b+a).compareTo(a+b));

        answer = String.join("", strings);

        return answer.startsWith("0") ? "0" : answer;
    }
}
