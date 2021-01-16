import java.util.Scanner;
/*
Names: Ari Kamat, Michael Kasprzak, Sanket Bhalotia
Date: 1/15/2021
Exercise 8.09
(Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns
marking an available cell in a 3 * 3 grid with their respective tokens (either
X or O). When one player has placed three tokens in a horizontal, vertical, or
diagonal row on the grid, the game is over and that player has won. A draw (no
winner) occurs when all the cells on the grid have been filled with tokens and
neither player has achieved a win. Create a program for playing tic-tac-toe.
The program prompts two players to enter an X token and O token alternately.
Whenever a token is entered, the program redisplays the board on the
console and determines the status of the game (win, draw, or continue). Here
is a sample run:
 */
public class Eight09 {
    public static void main(String[] args) {
        //Create Scanner object named input
        Scanner input = new Scanner(System.in);

        //Create a array named ticTacToeArr of type char and 3 rows and 3 cols resembling a tictactoe board
        char[][] ticTacToeArr = new char[3][3];
        //Create a variable that keeps track of which player is playing at the moment
        char playerLetter='X';
        //A boolean representing whether the board has a win or a tie or if it still is being played
        boolean boardOver = false;
        //Call the printarr method to print out the board
        printArr(ticTacToeArr);

        //Using a while loop keep havng the players play until the board has x winning, o winning, or a board filled with no winner (tie)
        while(!boardOver){
            //Prompt the user to enter the row and column that they want to fill and store their input in an integer variable
            System.out.printf("Enter a row (0, 1, or 2) for player %c:", playerLetter);
            int row = input.nextInt();
            System.out.printf("Enter a column (0, 1, or 2) for player %c:", playerLetter);
            int col = input.nextInt();

            //Fill that index of the 2d array with their letter
            ticTacToeArr[row][col]=playerLetter;

            //Print out that array
            printArr(ticTacToeArr);

            //Using conditional and custom made methods check if there is a horizontal veritcal or diagonal win. If so print out that player x won and that board is over
            if(checkHorizontal(ticTacToeArr,'X')||checkVertical(ticTacToeArr,'X')||checkDiagonal(ticTacToeArr,'X')){
                boardOver=true;
                System.out.println("Player X won");
            }

            //Using conditional and custom made methods check if there is a horizontal veritcal or diagonal win. If so print out that player O won and that board is over
            else if(checkHorizontal(ticTacToeArr,'O')||checkVertical(ticTacToeArr,'O')||checkDiagonal(ticTacToeArr,'O')){
                boardOver=true;
                System.out.println("Player O won");
            }

            //If there is a tie print out that there is a tie and change the status of the game
            else if(tieExists(ticTacToeArr)){
                boardOver=true;
                System.out.println("There is a tie");
            }
            //After each turn switch the player
            if(playerLetter=='X'){
                playerLetter='O';
            }
            else {
                playerLetter='X';
            }

            //Close input and exit System
            input.close();
            System.exit(0);
        }
    }

    /**
     * Using proper formatting, print out the tictactoe board using a 2d character array
     * @param arr a 2d character array
     */
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

    /**
     * Given a tic tac toe board (2d array of chars) return a boolean indicating if there is a horizontal win for a specified player
     * @param arr the board
     * @param player the player ('x' or 'o')
     * @return a boolean indicating if there is a horizontal win for a specified player
     */
    public static boolean checkHorizontal(char[][] arr, char player){
        //Iterate through the rows and return false if there is a element in that row not equal to the player's character
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
    /**
     * Given a tic tac toe board (2d array of chars) return a boolean indicating if there is a vertical win for a specified player
     * @param arr the board
     * @param player the player ('x' or 'o')
     * @return a boolean indicating if there is a vertical win for a specified player
     */
    public static boolean checkVertical(char[][] arr, char player){
        //Iterate through the columns
        for(int j =0;j<3;j++){
            //Return false if it sees a single element in all 3 columns that is not equal to player's char
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

    /**
     * Given a tic tac toe board (2d array of chars) return a boolean indicating if there is a digonal win for a specified player
     * @param arr the board
     * @param player the player ('x' or 'o')
     * @return a boolean indicating if there is a diagonal win for a specified player
     */
    public static boolean checkDiagonal(char[][] arr, char player){
        //There are only 2 diagonals
        //Check if the characters at 0,0, 1,1 and 2,2 match the players character
        if(arr[0][0] ==player && arr[1][1] == player && arr[2][2] ==player){
            return true;
        }
        //Check if the characters at 0,2, 1,1 and 2,0 match the players character

        else if(arr[0][2] ==player && arr[1][1] == player && arr[2][0] ==player){
            return true;
        }
        //Otherwise there is no diagonal win
        else {
            return false;
        }
    }

    /**
     * returns a booleaen indicaing if there is a tie
     * @param arr the tic tac toe board
     * @return a booleaen indicaing if there is a tie
     */
    public static boolean tieExists(char[][] arr){
        //There is a tie if all indices are filled with an 'X' or an 'O' and if there is no win
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
