package Homework5;

import java.util.Random;



public class Main {
    public static Random rand = new Random();

    public static void main (String[] args){

        Byte[][] arrToFile = new Byte[4][3];
        filingByteArray2d(arrToFile);

        AppData<Byte> appData1 = new AppData(arrToFile);

        appData1.writeToFile();
        appData1.readFromFile();

    }

    public static  void filingByteArray2d(Byte[][] tmpArray){
        for(int i=0; i<tmpArray.length; i++){
            for(int j=0; j<tmpArray[i].length; j++){
                tmpArray[i][j]= (byte) rand.nextInt(125);


            }

        }
    }

}
