//Homework by Yumatov Maksim

package Homework3;

import Homework3.Fruit.Apple;
import Homework3.Fruit.Orange;
import Homework3.MyGeneric.VarToChange;

import java.util.Arrays;


public class Main {


    public static void main (String[] args){

        //case#1
        VarToChange<Integer> intArray = new VarToChange<>(15,62,237,4249,55);
        intArray.printToConsole();//print to console without changes

        intArray.elementChangePosition();
        intArray.printToConsole();//print to console with changes

        System.out.println("+++++++++++");

        VarToChange<String> strArray= new VarToChange<>("cat", "календарь", "phone", "router");
        strArray.printToConsole();

        strArray.elementChangePosition();
        strArray.printToConsole();
        System.out.println("===========");


        //case#2

//        Apple apple1 = new Apple();
//        System.out.println(apple1.getWeight());
//        Orange orange1 = new Orange();
//        System.out.println(orange1.getWeight());


    }



    }


