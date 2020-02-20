package algorithm.example;

public class TestTest {

    public static void main(String[] args){
        Solution solution = new TestTest.Solution();
        String[] arrForPat = new String[]{"leo", "kiki", "eden"};
        String[] arrForCom = new String[]{"kiki", "eden"};
        run(arrForPat, arrForCom);  // leo

        arrForPat = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        arrForCom = new String[]{"josipa", "filipa", "marina", "nikola"};
        run(arrForPat, arrForCom);  // vinko

        arrForPat = new String[]{"mislav", "stanko", "mislav", "ana"};
        arrForCom = new String[]{"stanko", "ana", "mislav"};
        run(arrForPat, arrForCom);  // mislav
    }

    public static void run(String[] arrForPat, String[] arrForCom){
        Solution solution = new TestTest.Solution();
        String answer = solution.solution2(arrForPat, arrForCom);
        System.out.println(answer);
    }



    public static class Solution {
        public Solution(){

        }

        public String solution(String[] participant, String[] completion) {
            String answer = "";
            if (participant.length > completion.length){
                for (int i=0; i<completion.length; i++){
                    for (int j=0; j<participant.length; j++){
                        if (participant[j].equals(completion[i])){
                            completion[i] = "";
                            participant[j] = "";
                            break;
                        }
                    }
                }
                for (int i=0; i<participant.length; i++){
                    if (participant[i].length() > 0){
                        answer = participant[i];
                        break;
                    }
                }
            }
            return answer;
        }

        public String solution2(String[] participant, String[] completion) {
            String answer = "";
            if (participant.length > completion.length){
                for (int i=0; i<participant.length; i++){
                    for (int j=0; j<completion.length; j++){
                        if (participant[i].equals(completion[j])){
                            completion[j] = "";
                            participant[i] = "";
                            break;
                        }
                    }
                    if (!participant[i].equals("")){
                        answer = participant[i];
                        break;
                    }
                }

            }
            return answer;
        }

    }

}
