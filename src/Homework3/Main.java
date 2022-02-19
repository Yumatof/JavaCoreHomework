//Homework by Yumatov Maksim

package Homework3;

import Homework3.MyGeneric.VarToChange;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random rand = new Random();

    public static void main (String[] args){

        //case#1
        int[] intArray = {15,62,237,4249,55};
        System.out.println(Arrays.toString(intArray));//print to console without changes

        changePosition(intArray);
        System.out.println(Arrays.toString(intArray));//print to console with changes

        //case#2


    }

    public static void changePosition(int[] array){
        int i=0, j=0;

        do {
            i = rand.nextInt(array.length);
            j = rand.nextInt(array.length);
        } while(i == j);
        VarToChange<Integer> X = new VarToChange<>(array[i]);

        array[i] = array[j];
        array[j] = X.getObj();
    }

    }


