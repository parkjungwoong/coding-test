package programmers.kakao2019;

import java.util.*;

/**
 * 4 번 문제
 *
 * 효율성 테스트 2 통과 못함 !
 */
public class P33726 {
    public static void main(String[] args) {
        int[] solution
                = new P33726()
                .solution(
                        new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}
                        , new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}
        );

        for(int e : solution) {
            System.out.print(e+",");
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        List<Word> wList = new ArrayList<>(words.length);
        for(String w : words) {
            wList.add(new Word(w));
        }
        wList.sort(  (o1, o2) -> Integer.compare(o1.word.length(), o2.word.length()) );

        Queue<Query> qList = new PriorityQueue<>();

        for(int i=0; i<queries.length; i++) {
            qList.add(new Query(queries[i],i));
        }

        //중복 검색값 결과 저장 용
        Map<String, Integer> queryResult = new HashMap<>();

        for(Query qu : qList) {

            if(!queryResult.containsKey(qu.q)) {
                int cnt = 0;

                boolean isSt = qu.q.charAt(0) != '?';
                String q = isSt ? qu.q.substring(0, qu.q.indexOf("?"))
                        : qu.q.substring(qu.q.lastIndexOf("?")+1);

                int qLen = qu.q.length();

                for(Word word : wList) {
                    if(word.word.length() > qLen) {
                        break;
                    } else if(word.word.length() == qLen) {
                        if(isSt && word.word.startsWith(q) ) {
                            cnt++;
                        } else if (!isSt && word.word.endsWith(q) ) {
                            cnt++;
                        }
                    }
                }

                queryResult.put(qu.q, cnt);
            }
        }

        for(Query q : qList) {
            answer[q.index] = queryResult.get(q.q);
        }

        return answer;
    }

    class Word {
        String word;

        public Word(String word) {
            this.word = word;
        }
    }

    class Query implements Comparable<Query> {
        String q;
        int index;

        public Query(String q, int index) {
            this.q = q;
            this.index = index;
        }

        @Override
        public int compareTo(Query o) {
            return Integer.compare(q.length(), o.q.length());
        }
    }
}


/*
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
Arrays.sort(words);
        //중복 검색값 결과 저장 용
        Map<String, Integer> queryResult = new HashMap<>();

        for(int i=0; i<queries.length; i++) {

            if(queryResult.containsKey(queries[i])) {
                answer[i] = queryResult.get(queries[i]);
            } else {
                int cnt = 0;

                boolean isSt = queries[i].charAt(0) != '?';
                String q = isSt ? queries[i].substring(0, queries[i].indexOf("?"))
                        : queries[i].substring(queries[i].lastIndexOf("?")+1);

                int qLen = queries[i].length();

                for(String word : words) {
                    if(isSt && word.length() == qLen && word.startsWith(q) ) {
                        cnt++;
                    } else if (!isSt && word.length() == qLen && word.endsWith(q) ) {
                        cnt++;
                    }
                }

                queryResult.put(queries[i], cnt);
                answer[i] = cnt;
            }
        }

        return answer;
    }
}



 */
