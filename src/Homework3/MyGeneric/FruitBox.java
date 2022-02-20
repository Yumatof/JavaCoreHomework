package Homework3.MyGeneric;

import Homework3.Fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<B extends Fruit> {

    private ArrayList<B> boxList=new ArrayList<>();
    //private B[] box;

    public FruitBox(B...inputboxList){
        boxList.addAll(Arrays.asList(inputboxList));
    }


    public float getWeightBox(){

        return boxList.size()*boxList.get(0).getWeight();
    }

    public boolean compare(FruitBox<?> anotherBox){
       return getWeightBox() == anotherBox.getWeightBox();
    }

    public void putInThisBox(FruitBox<B> anotherBox){

    }
}
