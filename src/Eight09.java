import java.util.Scanner;

public class Eight09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] ticTacToeArr = new char[3][3];
        char playerLetter='X';
        boolean boardOver = false;
        String finalMessage="";
        printArr(ticTacToeArr);
        while(!boardOver){
            System.out.printf("Enter a row (0, 1, or 2) for player %c:", playerLetter);
            int row = input.nextInt();
            System.out.printf("Enter a column (0, 1, or 2) for player %c:", playerLetter);
            int col = input.nextInt();
            ticTacToeArr[row][col]=playerLetter;
            printArr(ticTacToeArr);
            if(checkHorizontal(ticTacToeArr,'X')||checkVertical(ticTacToeArr,'X')||checkDiagonal(ticTacToeArr,'X')){
                boardOver=true;
                System.out.println("Player X won");
            }
            else if(checkHorizontal(ticTacToeArr,'O')||checkVertical(ticTacToeArr,'O')||checkDiagonal(ticTacToeArr,'O')){
                boardOver=true;
                System.out.println("Player O won");
            }
            else if(tieExists(ticTacToeArr)){
                boardOver=true;
                System.out.println("There is a tie");
            }
            if(playerLetter=='X'){
                playerLetter='O';
            }
            else {
                playerLetter='X';
            }
        }
    }
    public static void printArr(char[][] arr){
        System.out.println("———————————");
        for(int i =0; i<3;i++){
            for(int j=0;j<3;j++){
                System.out.printf("| %c ",arr[i][j]);
            }
            System.out.printf("|\n");
            System.out.println("———————————");
        }
    }
    public static boolean checkHorizontal(char[][] arr, char player){
        for(int i =0;i<3;i++){
            boolean win=true;
            for(int j=0; j<3;j++){
                if(arr[i][j] != player){
                    win = false;
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }
    public static boolean checkVertical(char[][] arr, char player){
        for(int j =0;j<3;j++){
            boolean win=true;
            for(int i=0; i<3;i++){
                if(arr[i][j] != player){
                    win = false;
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonal(char[][] arr, char player){
        if(arr[0][0] ==player && arr[1][1] == player && arr[2][2] ==player){
            return true;
        }
        else if(arr[0][2] ==player && arr[1][1] == player && arr[2][0] ==player){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean tieExists(char[][] arr){
        boolean filled = true;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j] != 'X' && arr[i][j] != 'O'){
                    filled = false;
                }
            }
        }
        return filled;
    }
}
