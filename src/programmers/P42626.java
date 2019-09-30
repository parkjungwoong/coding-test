package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class P42626 {
    public static void main(String[] args) {
        int solution = new P42626().solution2(new int[]{1, 2, 3, 9, 10, 12}, 30);
//        int solution = new P42626().solution2(new int[]{10}, 1);
//        int solution = new P42626().solution2(new int[]{0,1,2,3}, 40);

        System.out.println("so => "+solution);
    }


    public int solution2(int[] scoville, int K) {
        int answer = 0;

        if(scoville.length == 1) {
            if(K > scoville[0]) return -1;
            else return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>(scoville.length);

        for(int e : scoville) {
            //힙 정렬은 넣을때 정렬해서 넣는다.
            queue.add(e);
        }

        if(queue.peek() >= K) return answer;

        while (!queue.isEmpty()) {
            if( K > queue.peek() && queue.size() > 1) {
                queue.add(queue.poll() + ( queue.poll() * 2 ));
                answer++;
            } else if(queue.poll() >= K) return answer;
        }

        return -1;
    }

    /**
     * 이 건 효율성 검사를 통과 못함
     */
    public int solution(int[] scoville, int K) {
        int answer = 0;

        if(scoville.length == 1) {
            if(K > scoville[0]) return -1;
            else return 0;
        }

        Arrays.sort(scoville);

        while(true) {
            int a = answer;
            int b = answer+1;

            if( scoville[a] >= K) return answer;
            if(b>=scoville.length) return -1;

            if( K > scoville[a] ) {
                scoville[b] = scoville[a]+ (scoville[b]*2);
                answer++;
            }

            Arrays.sort(scoville, a+1, scoville.length);
        }
    }
}
