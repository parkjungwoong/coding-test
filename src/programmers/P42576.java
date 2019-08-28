package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 완주하지 못한 선수
 */
public class P42576 {
    public static void main(String[] args) {

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> p = new HashMap<>();

        for(String a : participant) {
            p.put(a, p.getOrDefault(a,0)+1);
        }

        for(String a : completion) {
            p.put(a, p.get(a)-1);
        }

        Set<String> keys = p.keySet();

        for(String key : keys) {
            if(p.get(key) != 0) answer = key;
        }

        return answer;
    }
}
