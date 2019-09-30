package programmers;

/**
 * 틀렸어 다시해..
 * https://programmers.co.kr/learn/courses/30/lessons/42583?language=java
 */
public class P36787 {
    public static void main(String[] args) {
        int solution = new P36787().solution(3, 10, new int[]{10,2,8,2});
        System.out.println("s-> "+solution);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;

        int maxTime = bridge_length*truck_weights.length;

        for(int i=1; i<=maxTime; i++) {

            for(int j=0; j<truck_weights.length; j++) {

                int totalW = truck_weights[j];

                for(int k=j+1; k<truck_weights.length; k++) {
                    totalW += truck_weights[k];

                    if(weight >= totalW) {
                        answer+=1;
                        i++;
                        totalW-=truck_weights[j];
                    } else {
                        answer+=bridge_length;
                        break;
                    }
                }
            }
        }

        /*for(int i=0; i<truck_weights.length; i++) {
            int totalW = truck_weights[i];

            for(int j=i+1; j<truck_weights.length; j++) {
                totalW += truck_weights[j];

                if(weight >= totalW) {
                    answer+=1;
                    i++;
                    totalW-=truck_weights[i];
                } else {
                    answer+=bridge_length;
                    break;
                }
            }
        }*/

        return answer+bridge_length;
    }
}
