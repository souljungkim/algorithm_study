package algorithm.test.backtracking;

public class NQueen {


    public static void main(String[] args){
        getNQueen(4);
//        getNQueen(5);
//        getNQueen(10);
    }


    public static void getNQueen(int col){
        int[] cols = new int[col]; //- 값은 열의 위치
        back_tracking(0, cols);
    }

    public static void back_tracking(int level, int[] cols){
        //back_tracking 함수
        //level: 현재의 따질 행의 위치
        if (level == cols.length){
            //현재 따질 위치가 N열인가?
            //N-1까지 행이 있는데 N열까지 왔다는건
            //N-1까지 모두 조건을 만족한다는 얘기이므로 답을 출력.
            for(int i=0; i<cols.length; i++){
                System.out.print(cols[i] +" ");
            }
            System.out.println("");
        }
        else{
            //현재 상황 level-1까지는 모두 조건대로 되어있고
            //level열에 퀸을 놓는 상황.

            for (int i=0; i<cols.length; i++){//퀸을 0번부터 N-1번까지 놓는 경우를 전부 따져본다.
                cols[level] = i; //퀸을 i에 놓는다.
                if (isPossible(level, cols)){//퀸을 i에 놓은것이 가능한가?
                    back_tracking(level+1, cols); //그렇다면 퀸을 그 자리에 넣고 다음 행으로 진입
                }
            }
        }
    }

    public static boolean isPossible(int level, int[] cols){
        for(int i=0; i<level; i++){
            //level 위치에 현재 시험할 퀸이 놓여져 있는 상태이고
            //우리는 그 퀸과 i= 0 ~ level-1 에 놓여있는 퀸이 문제를 일으키는지만 보면 된다.

            if (cols[i] == cols[level] || Math.abs(level -i) == Math.abs(cols[level] - cols[i])){
                //i번째 퀸의 위치와 level위치의 퀸이 같은 일직선상에 있는경우
                //또는
                //i번째 퀸의 위치와 level위치의 퀸이 대각선상에 있는 경우.
                //밑변과 높이가 같으면 대각선상에 있다고 볼수 있다.
                //이 경우는 불가능 하므로 false를 리턴
                return false;

            }
        }
        //위의 경우를 제외하면 가능하므로 true 리턴
        return true;
    }




}
