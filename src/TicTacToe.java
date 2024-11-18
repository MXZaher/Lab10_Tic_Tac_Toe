import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[][] board = new String[ROWS][COLS];
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    private static void clearBoard(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = " ";
            }
        }
    }
    private static void display(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2){
                System.out.println("---------");
            }
        }
    }
    private static boolean isValidMove(int row, int col){
        if (row < 0 || row >= 3 || col < 0 || col >= 3){
            return false;
        }
        return board[row][col].equals(" ");
    }
    private static boolean isWin(String player){
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    private static boolean isColWin(String player){
        for (int col = 0; col < 3; col++){
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)){
                return true;
            }
        }
        return false;
    }
    private static boolean isRowWin(String player){
        for (int row = 0; row < 3; row++){
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)){
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player){
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player) || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    private static boolean isTie(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return !isWin("X") && !isWin("O");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        clearBoard();
        String currentPlayer = PLAYER_X;
        boolean gameOver = false;
        display();

        while(!gameOver){
            System.out.println("It is Player " + currentPlayer + "'s move");
            int row, col;
            while(true) {
                System.out.print("Enter row (1-3): ");
                row = (scanner.nextInt() - 1);
                System.out.print("Enter column (1-3): ");
                col = (scanner.nextInt() - 1);
                if (isValidMove(row, col)) {
                    break;
                } else {
                    System.out.println("Invalid move.");
                }
            }
                board[row][col] = currentPlayer;
                display();

                if (isWin(currentPlayer)){
                    System.out.println("Player " + currentPlayer + " wins.");
                    gameOver = true;
                } else if (isTie()) {
                    System.out.println("It's a tie.");
                    gameOver = true;
                } else {
                    currentPlayer = currentPlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            }
            System.out.println("Game over.");
    }
}
