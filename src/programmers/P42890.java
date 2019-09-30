package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 후보키
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 */
public class P42890 {
    public static void main(String[] args) {
        String[][] relation = new String[][]{
                {"100","ryan","music","2"}
                ,{"200","apeach","math","2"}
                ,{"300","tube","computer","3"}
                ,{"400","con","computer","4"}
                ,{"500","muzi","music","3"}
                ,{"600","apeach","music","2"}
        };

        int solution = new P42890().solution(relation);

        System.out.println("so => "+solution);
    }

    public int solution(String[][] relation) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int columCnt = relation[0].length;

        String key="";
        a : for(int i=0; i<columCnt; i++) {
            queue.add(i);
            Map<String, Integer> map = new HashMap<>();

            for(String[] row : relation) {
                key += row[i];
                map.put(key, map.getOrDefault(key,0) + 1);
                if(map.get(key) > 1) {
                    continue a;
                }
            }
            key="";
            answer++;
        }

        return answer;
    }

}
