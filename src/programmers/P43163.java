package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class P43163 {
    public static void main(String[] args) {
        int solution = new P43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println("solution => "+solution);
    }

    class Word {
        private String nm;
        private List<Word> list;
        private boolean visit;

        public Word(String nm) {
            this.nm = nm;
        }

        public void setList(List<Word> list) {
            int len = nm.length();
            this.list = new ArrayList<>();

            a: for(Word e : list) {
                int diffCnt = 0;

                for(int i=0; i<len; i++) {
                    if(e.nm.charAt(i) != this.nm.charAt(i)) diffCnt++;
                    if(diffCnt > 1) continue a;
                }

                if(diffCnt == 1) this.list.add(e);
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 51;
        //word 세팅
        List<Word> wordList = new ArrayList<>(words.length+1);
        wordList.add(new Word(begin));

        boolean flag = true;
        for(String e : words) {
            if(target.equals(e)) {
                flag = false;
            }
            wordList.add(new Word(e));
        }
        if(flag) return 0;

        for(Word e : wordList) {
            e.setList(wordList);
        }

        Queue<Word> queue = new LinkedList<>();

        queue.add(wordList.get(0));
        wordList.get(0).visit = true;

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            System.out.println("word poll=>"+word.nm);
            int tryCnt = 1;
            for(Word e : word.list) {
                if(!e.visit) queue.add(e);
                tryCnt++;
                System.out.println(e.nm);
                if(e.nm.equals(target)) {
                    System.out.println("match! => cnt = "+tryCnt);
                    answer = Math.min(answer,tryCnt);
                    break;
                }
                e.visit = true;
            }
        }

        return answer;
    }

    /**
     * DFS
     *
     * 큐에 첫번째 노드를 넣는다.
     * 첫번째 노드를 방문 표시한다.
     *
     * 1.큐에서 노드를 하나 꺼낸다.
     * 2.노드의 인접 노드를 방문한다.
     * 3.방문한 노드를 방문 표시한다.
     * 4.방문한 노드를 큐에 넣는다.
     *
     * 다시 1번부터 시작해서 큐에 값이 없을때 까지 반복한다.
     */

}
