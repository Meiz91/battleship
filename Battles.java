import java.util.Scanner;

public class Battles {
    mySolution a = new mySolution();
    public Battles(){

    }
    char[][] computerBoard = new char[10][10];
    char [] [] keepTrack = new char[10][10];
    char[][] playerBoard = new char[10][10];

    int[] boatSize = {5, 4, 3, 3, 2};
    char[] boatNames = {'A', 'B', 'D', 'S', 'P'};

    public void initiateBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerBoard[i][j] = '-';
                playerBoard[i][j] = '-';
                keepTrack[i][j] = '-';

            }
        }
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(playerBoard[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(keepTrack[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void computerSetup() {
        int col;
        int row;
        for (int i = 0; i < 5; i++) {
            int a = (int) (Math.random() * 2);
            boolean spot = false;
            if (a == 1) {
                while (!spot) {
                    col = (int) (Math.random() * (10 - boatSize[i]));
                    row = (int) (Math.random() * 10);
                    spot = checkSpot(col, row, boatSize[i], a);
                    if (spot) {
                        for (int j = 0; j < boatSize[i]; j++) {
                            computerBoard[row][col + j] = boatNames[i];
                        }
                        //spot=false;

                    }
                }
            } else {
                while (!spot) {
                    col = (int) (Math.random() * 10);
                    row = (int) (Math.random() * (10 - boatSize[i]));
                    spot = checkSpot(col, row, boatSize[i], a);
                    if (spot) {
                        for (int j = 0; j < boatSize[i]; j++) {
                            computerBoard[row + j][col] = boatNames[i];
                        }
                        // spot=false;

                    }
                }
            }

        }
    }

    public boolean checkSpot(int col, int row, int size, int a) {

        for (int j = 0; j < size; j++) {
            if (a == 1) {
                if (computerBoard[row][col + j] != '-') {
                    return false;
                }
            } else {
                if (computerBoard[row + j][col] != '-') {
                    return false;
                }

            }
        }
        return true;
    }

    public void playerSetup() {
        Scanner askPlayer = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        int ans;
        ans = askPlayer.nextInt();
        if (ans == 1){
            for (int i = 0; i <5 ; i++) {
                System.out.println("You are now placing boat size " + boatSize[i] + "\nplease choose an x y location.\nfor vertical/horizontal (0/1).");
                int x;
                int y;
                int position;

                x = scn.nextInt();
                y = scn.nextInt();
                position= scn.nextInt();

                if(position==1)
                    for (int j = 0; j < boatSize[i]; j++) {
                        playerBoard[x][y+j]= boatNames[i];
                    }
                else{
                    for (int j = 0; j <boatSize[i] ; j++) {
                        playerBoard[x+j][y]= boatNames[i];

                    }
                }
            }

        }else if (ans == 2){
            compSetupPlayer();

        }else playerSetup();


    }
    public void compSetupPlayer(){
        int col;
        int row;
        for (int i = 0; i < 5; i++) {
            int a = (int) (Math.random() * 2);
            boolean spot = false;
            if (a == 1) {
                while (!spot) {
                    col = (int) (Math.random() * (10 - boatSize[i]));
                    row = (int) (Math.random() * 10);
                    spot = checkSpot(col, row, boatSize[i], a);
                    if (spot) {
                        for (int j = 0; j < boatSize[i]; j++) {
                            playerBoard[row][col + j] = boatNames[i];
                        }
                        //spot=false;

                    }
                }
            } else {
                while (!spot) {
                    col = (int) (Math.random() * 10);
                    row = (int) (Math.random() * (10 - boatSize[i]));
                    spot = checkSpot(col, row, boatSize[i], a);
                    if (spot) {
                        for (int j = 0; j < boatSize[i]; j++) {
                            playerBoard[row + j][col] = boatNames[i];
                        }
                        // spot=false;

                    }
                }
            }

        }

    }
}

