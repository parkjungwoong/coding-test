import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P42748 {
    public static void main(String[] args) {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}});
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

            List<Integer> sort = Arrays.stream(temp)
                    .boxed().sorted().collect(Collectors.toList());

            answer[i] = sort.get(pickPos);
        }

        return answer;
    }
}
