package goorm.wadiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 와디즈 개발팀으로, 사용자가 시도한 키워드를 바탕으로 자동 완성을 만들어 달라는 요청이 들어왔습니다. 또한 여러번 시도한 키워드 일수록 상위에 노출되도록 해달라고도 합니다.
 *
 * 이전 사용자가 시도한 키워드 전체를 등록하고, 새로운 사용자가 입력한 글자를 받았을 때 요청이 많은 순서대로 노출되는 프로그램을 만드시오.
 *
 * 예를 들어, 이전에 wadizian, wadiz, wadiz, reward 키워드 시도가 있었을 때, 새로운 사용자가 wa 를 입력한 경우, wadiz, wadizian 순서로 출력되어야 합니다.
 *
 *
 *
 * 입력 형식
 *
 *  첫번째 라인 입력 : 이전 사용자가 시도한 키워드를 콤마(,) 로 구분
 *
 *  두번째 라인 입력 : 새로운 사용자가 입력한 글자
 *
 * 출력 형식
 *
 *    입력한 글자가 포함된 키워드 리스트. 두개 이상일 경우 콤마(,) 로 구분하여 시도 횟수 높은 순으로 노출
 *
 * 입출력
 *
 *   [입력]
 *
 *     wadizian, wadiz, wadiz, reward, equity
 *
 *    wa
 *
 *   [출력]
 *
 *      wadiz, wadizian
 */
public class Two {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(",");
        final String keyWord = br.readLine().trim();
        br.close();

        new Two().solution(inputs, keyWord);
    }

    public void solution(String[] inputs, final String keyWord) {
        Map<String, Integer> keyWordMap = new HashMap<>();

        for(String e : inputs) {
            String str = e.trim();
            if(str.startsWith(keyWord)) {
                keyWordMap.put(str, keyWordMap.getOrDefault(str,0)+1);
            }
        }

        List<Word> wordList = new ArrayList<>(keyWordMap.size());

        for(String key : keyWordMap.keySet()) {
            wordList.add(new Word(key,keyWordMap.get(key)));
        }

        wordList.sort( (o1, o2) -> Integer.compare(o2.cnt, o1.cnt));

        for(int i=0; i<wordList.size(); i++) {
            System.out.print(wordList.get(i).word);
            if(i != wordList.size()-1) System.out.print(",");
        }
    }

    class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

}
