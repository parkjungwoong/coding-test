package programmers;

import java.util.*;

/**
 * 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class P42840 {
    public static void main(String[] args) {
        int[] solution = new P42840().solution(new int[]{1,2,2,1});

        for(int e : solution) {
            System.out.println("["+e+"]");
        }
    }

    public int[] solution(int[] answers) {
        int[][] list = new int[3][];
        list[0] = new int[]{1, 2, 3, 4, 5};
        list[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        list[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Student> studentList = new ArrayList<>();

        int maxScore = 0;

        for(int i=0; i<3; i++) {
            int[] w = list[i];
            int wLne = w.length;
            int score = 0;

            for(int j=0; j<answers.length; j++) {
                if(answers[j] == w[j % wLne]) {
                    score++;
                }
            }

            if(score != 0) {
                maxScore = Math.max(maxScore, score);
                studentList.add(new Student(i+1, score));
            }
        }

        int[] result;

        int loopCnt;

        if(studentList.size() > 0) {
            loopCnt = 0;
            studentList.sort((o1, o2) -> o2.score != o1.score ? Integer.compare(o2.score, o1.score) : Integer.compare(o1.num, o2.num) );

            for(int i=0; i<studentList.size(); i++) {
                if(studentList.get(i).score >= maxScore) {
                    loopCnt++;
                }
            }
        } else {
            loopCnt = 3;
            studentList = new ArrayList<>();
            studentList.add(new Student(1,0));
            studentList.add(new Student(2,0));
            studentList.add(new Student(3,0));
        }

        result = new int[loopCnt];

        for(int i=0; i<loopCnt; i++) {
            result[i] = studentList.get(i).num;
        }

        return result;
    }

    class Student {
        int num;
        int score;

        public Student(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }
}
