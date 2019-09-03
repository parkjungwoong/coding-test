package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class P42888 {

    public static void main(String[] args) {
        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] solution = new P42888().solution(record);

        for(String e : solution) {
            System.out.println(e);
        }
    }

    public String[] solution(String[] record) {
        Map<String, String> userRecode = new HashMap<>();

        for(String e : record) {
            String[] s = e.split(" ");
            if(!s[0].equals("Leave")) userRecode.put(s[1],s[2]);
        }

        List<String> list = new ArrayList<>();

        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            if(!s[0].equals("Change")) list.add(userRecode.get(s[1])+"님이 "+ (s[0].equals("Enter") ? "들어왔습니다." : "나갔습니다."));
        }

        String[] answer = new String[list.size()];

        list.toArray(answer);

        return answer;
    }


}
