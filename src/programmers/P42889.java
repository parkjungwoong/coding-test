package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class P42889 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = new int[]{2, 1};

        int[] solution = new P42889().solution(N, stages);

        for(int e : solution) {
            System.out.println(e);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer;

        int[] failCnt = new int[N+2];

        //각 단계별 도전중인 사람 수
        for(int e : stages) {
            failCnt[e]+=1;
        }

        List<Player> players = new ArrayList<>();

        //각 단계별 실패율 계산
        for(int i=1; i<N+1; i++) {
            double totalPlayer = 0;

            //통과+진행중인 사람 수
            for(int j=i; j<N+2; j++) {
                totalPlayer+=failCnt[j];
            }

            System.out.println(i+" => "+failCnt[i]+"/"+totalPlayer);
            if(failCnt[i] != 0) {
                players.add(new Player(i, failCnt[i]/totalPlayer));
            } else {
                players.add(new Player(i, 0));
            }
        }

        players.sort( (o1, o2) -> o1.failPer == o2.failPer ? Integer.compare(o1.state, o2.state) : Double.compare(o2.failPer, o1.failPer) );

        answer = new int[players.size()];

        for(int i=0; i<players.size(); i++) {
            answer[i] = players.get(i).state;
        }

        return answer;
    }

    class Player {
        int state;
        double failPer;

        public Player(int state, double failPer) {
            this.state = state;
            this.failPer = failPer;
        }
    }
}
