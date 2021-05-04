public class mySolution {
    public int place1 = 0;
    public int place2 = 0;

    public int getPlace1() {
        return place1;
    }

    public void setPlace1(int place1) {
        this.place1 = place1;
    }

    public int getPlace2() {
        return place2;
    }

    public void setPlace2(int place2) {
        this.place2 = place2;
    }

    BattleLogic moveLogic;

    public mySolution() {
    }

    boolean smart1;
    boolean smart2;
    boolean smart3;
    boolean smart4;

    public void isMySolution(int x, int y) {
        x = place1;
        y = place2;
        if (smart1 && smart2 && smart3 && smart4) {
            try {
                smartMove1(x, y);

            } catch (ArrayIndexOutOfBoundsException e) {
                smart1 = false;
                isMySolution(x,y);
            }
            smart1 = false;
        } else if (!smart1 && smart2 && smart3 && smart4) {
            try {
                smartMove2(x, y);

            } catch (ArrayIndexOutOfBoundsException e) {
                smart2 = false;
                isMySolution(x,y);

            }
        } else if (!smart1 && !smart2 && smart3 && smart4) {
            try {
                smartMove3(x, y);

            } catch (ArrayIndexOutOfBoundsException e) {
                smart3 = false;
                isMySolution(x,y);

            }
        } else if (!smart1 && !smart2 && !smart3 && smart4) {
            try {
                smartMove4(x, y);

            } catch (ArrayIndexOutOfBoundsException e) {
                smart4 = false;
                isMySolution(x,y);

            }
        }

    }

    public void smartMove1(int x, int y) {
        moveLogic.HitOrMiss(x + 1, y);

    }

    public void smartMove2(int x, int y) {
        moveLogic.HitOrMiss(x, y + 1);
    }

    public void smartMove3(int x, int y) {
        moveLogic.HitOrMiss(x, y - 1);
    }

    public void smartMove4(int x, int y) {
        moveLogic.HitOrMiss(x - 1, y);
        moveLogic.hitMade=false;
    }


}

