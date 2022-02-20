//Homework by Yumatov Maksim

package Homework3;

import Homework3.Fruit.Apple;
import Homework3.Fruit.Orange;
import Homework3.MyGeneric.FruitBox;
import Homework3.MyGeneric.VarToChange;

import java.util.ArrayList;
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

        FruitBox<Apple> aplleBox1 = new FruitBox<>(new Apple(), new Apple());
        FruitBox<Apple> aplleBox2 = new FruitBox<>(new Apple(), new Apple(), new Apple());

        FruitBox<Orange> orangeBox1 = new FruitBox<>(new Orange(), new Orange(),new Orange(),new Orange());
        System.out.println(aplleBox1.getWeightBox());
        System.out.println(orangeBox1.getWeightBox());
        System.out.println(aplleBox1.compare(orangeBox1));;
    }



    }


