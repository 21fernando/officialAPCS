import java.util.Arrays;

public class TokenPass {

    private static int[] board;
    private static int currentPlayer = 3;

    public TokenPass(int playerCount){
        board = new int[playerCount];
        for(int i = 0; i<playerCount; i++){
            board[i] = (int)(Math.random()*9+1);
        }
    }
    public static void distributeCurrentPlayerTokens(){
        int numTokens = board[currentPlayer];
        int i = currentPlayer;
        board[currentPlayer] = 0;
        while (numTokens>0){
            if(i == board.length-1){
                i=0;
            }else{
                i++;
            }
            board[i]++;
            numTokens--;
        }
    }

    public static void main(String[] args) {
        TokenPass game=   new TokenPass(4);
        System.out.println(Arrays.toString(board));
        distributeCurrentPlayerTokens();
        System.out.println(Arrays.toString(board));
    }

}
