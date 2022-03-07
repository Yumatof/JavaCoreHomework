package Homework3.MyGeneric;

import Homework3.Fruit.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class FruitBox<B extends Fruit>{

    private ArrayList<B> box=new ArrayList<>(100);
    //private B[] box;

    public FruitBox(B...inputBox){
        box.addAll(Arrays.asList(inputBox));
    }


    public float getWeightBox(){
        if(box.size()==0) return 0;
        return box.size()*box.get(0).getWeight();
    }
    public void putInBox(B obj){
        box.add(obj);
    }

    public ArrayList<B> getBox() {
        return box;
    }

    private void clearBox(){
        box.clear();
    }

    public boolean compare(FruitBox<? extends Fruit> anotherBox){
       return getWeightBox() == anotherBox.getWeightBox();
    }

    public void shiftInThisBox(FruitBox<B> anotherBox){

        box.addAll(anotherBox.getBox());
        anotherBox.clearBox();

    }

}
