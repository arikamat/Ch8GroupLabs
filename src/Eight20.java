import java.util.Arrays;
import java.util.Scanner;

public class Eight20 {

    public static void main(String[] args) {
        char[][] board = new char[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
             board[i][j] = '0';
            }
        }
        Scanner in = new Scanner(System.in);

        int c = 0;
        while(won(board) == -1) {
            printBoard(board);
            System.out.print("Drop a " + (c % 2 == 0 ? "red" : "yellow") +" disk at column (0–6): ");
            int column = in.nextInt();
            add(board, column, (c % 2 == 0 ? 'R' : 'Y'));
            c++;
        }
        printBoard(board);
        System.out.println("The " + (c % 2 == 1 ? "red" : "yellow") +" player won");

        //Closes
        in.close();
        System.exit(0);
    }


    static int won(char[][] board) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (searchPoint(board, i, j, 'Y'))
                    return 1;
                else if (searchPoint(board, i, j, 'R'))
                    return 0;
            }
        }
        return -1;
    }

    static boolean searchPoint(char[][] board, int row, int col, char color) {
        int l = board.length;
        int w = board[0].length;

        // Searches Up
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w-4; j++) {
                if (
                        board[i][j] == color &&
                        board[i][j+1] == color &&
                        board[i][j+2] == color &&
                        board[i][j+3] == color
                ) {
                    return true;
                }
            }
        }

        // Searches Sideways
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l-4; j++) {
                if (
                        board[j][i] == color &&
                        board[j+1][i] == color &&
                        board[j+2][i] == color &&
                        board[j+3][i] == color
                ) {
                    return true;
                }
            }
        }

        // Searches Diagonal
        for (int i = 0; i < w-4; i++) {
            for (int j = 0; j < l-4; j++) {
                if (
                        board[i][j] == color &&
                        board[i+1][j+1] == color &&
                        board[i+2][j+2] == color &&
                        board[i+3][j+3] == color
                ) {
                    return true;
                }
            }
        }


        // Searches Other Diagonal
        for (int i = 3; i < w; i++) {
            for (int j = 0; j < l-4; j++) {
                if (
                        board[i][j] == color &&
                        board[i-1][j+1] == color &&
                        board[i-2][j+2] == color &&
                        board[i-3][j+3] == color
                ) {
                    return true;
                }
            }
        }

        return false;
    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("|");
                if (board[j][i] == '0')
                    System.out.print(" ");
                else
                    System.out.print(board[j][i]);
            }
            System.out.print("|\n");
        }
        for (int i = 0; i < 15; i++) {
            System.out.print("_");
        }
        System.out.print("\n");
    }

    static void add(char[][] board, int column, char color) {
        for (int i = 5; i >= 0; i--) {
            if (board[column][i] == '0') {
                board[column][i] = color;
                break;
            }
        }
    }




}
