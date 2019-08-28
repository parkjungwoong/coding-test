package programmers;

import java.util.*;
//위장
public class P42578 {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, List<String>> cMap = new HashMap<>();

        for(String e[] : clothes) {
            String clothe = e[0];
            String type = e[1];

            if(cMap.containsKey(type)) {
                cMap.get(type).add(clothe);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(clothe);
                cMap.put(type, list);
            }
        }

        Set<String> keys = cMap.keySet();

        for(String key : keys) {
            answer += answer * cMap.get(key).size();
            answer += cMap.get(key).size();//해당 타입의 개수
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int solution = new P42578().solution(input);

        System.out.println("solution -> "+solution);
    }
}
