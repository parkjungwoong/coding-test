package programmers.kakao2019;

import java.util.Stack;

/**
 * 1번
 */

public class P33723 {
    public static void main(String[] args) {
        String a = "xababcdcdababcdcd";
        int solution = new P33723().solution(a);
        System.out.println("so => "+solution);
    }

    public int solution(String s) {
        int answer = s.length();
        final int strLne = s.length();

        for(int i=1; i<strLne-1; i++) {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            int tempCnt = 1;

            for(int j=0; j+i<=strLne; j+=i) {
                String sub = s.substring(j, j+i);
                if(temp.equals(sub)) {
                    tempCnt++;
                } else {
                    if (tempCnt > 1) {
                        sb.append(tempCnt + temp);
                    } else if (temp.length() > 0){
                        sb.append(temp);
                    }
                    temp = sub;
                    tempCnt = 1;
                }
            }

            if (tempCnt > 1) {
                sb.append(tempCnt + temp);
            } else if (temp.length() > 0) {
                sb.append(temp);
            }

            int len = sb.toString().length();
            len += strLne % i;
            //나머지 붙여주기
            answer = Math.min(answer, len);
        }

        return answer;
    }
}
