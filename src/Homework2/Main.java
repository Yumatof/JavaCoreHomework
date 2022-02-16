//Homework by Yumatov Maksim

package Homework2;

import Homework2.MyException.MyArrayDataException;
import Homework2.MyException.MyArraySizeException;

public class Main {

    public static void main (String[] args) throws MyArraySizeException,MyArrayDataException {

        String [][] rightArray = {{"1","2","3","4"},
                                  {"2","3","4","5"},
                                  {"3","4","5","6"},
                                  {"4","5","6","7"}};

        String [][] wrongSizeArray = {{"1","2","3","4"},
                                      {"2","3","4","5","9"},
                                      {"3","4","5","6"},
                                      {"4","5","6","7"}};


        String[][] wrongContentArray = {{"1","piu-piu","3","4"},
                                      {"2","3","4","5"},
                                      {"3","4","5","6"},
                                      {"4","5","6","7"}};

        //checkSizeArray(rightArray);
        //checkSizeArray(wrongSizeArray);

        //sumContentArray(rightArray);
        sumContentArray(wrongContentArray);



    }

    public static void checkSizeArray(String[][] array) throws MyArraySizeException {
        if(array.length !=4){
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
    }
    public static void sumContentArray(String[][] array) throws MyArrayDataException {
        int sum =0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                try{
                    int y = Integer.parseInt(array[i][j]);
                    sum += y;
                }
                catch (NumberFormatException nfe){
                    throw new MyArrayDataException(nfe.getMessage() + " ошибка в яйчейке массива с координатами " + "["+i+"]"+"["+j+"]");
                }
            }
        }
        System.out.println("Сумма элементов массива = " + sum);
    }
}
