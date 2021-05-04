import java.util.Scanner;

public class BattleLogic {
    mySolution ms = new mySolution();
    int hitPlayer = 0;
    int hitComputer = 0;
    int turn = 0;
    boolean hitMade = false;
    int pX;
    int pY;
    Battles b1 = new Battles();


    char i;
    int boatsSank = 0;
    int aBoat;
    int bBoat;
    int dBoat;
    int sBoat;
    int pBoat;

    public mySolution getMs() {
        return ms;
    }

    public void setMs(mySolution ms) {
        this.ms = ms;
    }

    public BattleLogic() {
        System.out.println("would you like to set up your own board yes/no = 1/2?");
        b1.initiateBoard();
        b1.computerSetup();
        b1.playerSetup();
        b1.print();

        while (hitComputer != 17 || hitPlayer != 17) {
            // human player
            ask();
            turn++;

            //request cooridinates from user.
            //check hit or miss put down piece.
            // print boards
            // update turn
            //computer player
            computerAsk();
            b1.print();
            turn++;

            //if hit go spot next to it. if not random spot selection
            //check board
            // update player board

        }

    }

    public void ask() {
        Scanner hitInput = new Scanner(System.in);

        System.out.println("please enter your guess with coordinates");
        String x = hitInput.next();
        String  y = hitInput.next();
        while(x.length()>1 || y.length()>1|| (x.charAt(0) < '0' )||(x.charAt(0)>'9'))
        {
            System.out.println("invalid guess.");
            System.out.println("please enter your guess with coordinates");
            x = hitInput.next();
            y = hitInput.next();
        }


        if (b1.computerBoard[Integer.parseInt(x)][Integer.parseInt(y)] == '#' || b1.computerBoard[Integer.parseInt(x)][Integer.parseInt(y)] == '*') {
            System.out.println("why you dumb bro you lose your turn ");


        }
        else
        {


            try{

                HitOrMiss(Integer.parseInt(x),Integer.parseInt(y));


            }catch (ArrayIndexOutOfBoundsException e) {


                System.out.println("please enter a valid guess");
                //ask();
            }
        }//computerAsk();
    }


    public void computerAsk() {

        int row = (int) (Math.random() * 10);
        int col = (int) (Math.random() * 10);
        if (hitMade) {
            ms.isMySolution(ms.place1, ms.place2);
        }
        if (b1.playerBoard[row][col] == '*' || b1.playerBoard[row][col] == '#') {
            computerAsk();
        } else {

            HitOrMiss(row, col);
        }
    }


    public void HitOrMiss(int x, int y) {

        System.out.println("im in the hitormiss method");


        if (turn % 2 == 0) {
            if (b1.computerBoard[x][y] != '-') {
                System.out.println("HIT!!");
                b1.computerBoard[x][y] = '*';
                b1.keepTrack[x][y] = '*';
                hitComputer++;

            } else {
                System.out.println("Miss");
                b1.computerBoard[x][y] = '#';
                b1.keepTrack[x][y] = '#';


            }
        } else {
            if (b1.playerBoard[x][y] == '-') {
                System.out.println("computer missed ");
                b1.playerBoard[x][y] = '#';



            } else {
                System.out.println("computer hit");
                b1.playerBoard[x][y] = '*';

                hitPlayer++;
                hitMade = true;
                this.ms.place1 = x;
                this.ms.place2 = y;
            }
        }
    }


    public static void main(String[] args) {

        BattleLogic play = new BattleLogic();

    }

}


