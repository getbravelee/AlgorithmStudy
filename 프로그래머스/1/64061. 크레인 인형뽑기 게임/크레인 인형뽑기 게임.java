/*
moves 원소의 숫자는 1~n 번 째 칸 중에서 해당하는 칸의 맨위 캐릭터를 바구니에 담는다.
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
[1,5,3,5,1,2,1,4]
moves 원소가 1이라면 board[?][0]의 원소를 빼서 바구니에 담는다.
*/
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int num = board[j][moves[i]-1]; // 꺼낸 숫자
                if(num != 0) {
                    if(st.size() > 0 && st.peek() == num) {
                        answer += 2;
                        st.pop();
                    } 
                    else {
                        st.push(num);
                    }
                    board[j][moves[i]-1] = 0; // 꺼내면 빈칸
                    break; // 꺼냈는데 탐색 횟수가 남았으면 다음꺼에 영향을 주기때문에 반드시 break한다.
                }
            }
        }
        return answer;
    }
}