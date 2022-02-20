package Homework3.MyGeneric;

import java.util.Arrays;
import java.util.Random;

public class VarToChange <T>{
    public static Random rand = new Random();

    private T[] arrayObj;

    public VarToChange(T... arrayObj){
        this.arrayObj=arrayObj;
    }

    public void elementChangePosition(){
        int i=0, j=0;
        T tmpVar;

        do {
            i = rand.nextInt(arrayObj.length);
            j = rand.nextInt(arrayObj.length);
        } while(i == j);
        tmpVar = (arrayObj[i]);

        arrayObj[i] = arrayObj[j];
        arrayObj[j] = tmpVar;
    }
    public void printToConsole(){
        System.out.println(Arrays.toString(arrayObj));
    }
}
