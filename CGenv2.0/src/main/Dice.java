package main;

import java.util.Random;

public class Dice {
    Random rand= new Random();

    public Dice() {
    }

    public int d4(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(4)+1);
        }

        return total;
    }
    public int d6(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(6)+1);
        }

        return total;
    }
    public int d8(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(8)+1);
        }

        return total;
    }
    public int d10(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(10)+1);
        }

        return total;
    }
    public int d12(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(12)+1);
        }

        return total;
    }
    public int d20(int qty, int mod){
        int i, total = 0;
        for (i=0; i < qty; i++){
            total += (rand.nextInt(20)+1);
        }

        return total;
    }

}
