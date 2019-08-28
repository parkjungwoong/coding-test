package programmers;

import java.util.Arrays;

/**
 * K번째수
 */
public class P42748 {
    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        for(int e : solution) {
            System.out.println(e);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int srcPos;
        int splitLen;
        int pickPos;

        for(int i=0; commands.length>i; i++) {
            srcPos = commands[i][0];
            splitLen = commands[i][1] - srcPos + 1;
            pickPos = commands[i][2]-1;

            int[] temp = new int[splitLen];

            System.arraycopy(array, srcPos-1,temp, 0, splitLen);
            Arrays.sort(temp);
            answer[i] = temp[pickPos];
        }

        return answer;
    }
}
