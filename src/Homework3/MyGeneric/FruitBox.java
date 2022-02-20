package Homework3.MyGeneric;

import Homework3.Fruit.Fruit;

public class FruitBox<B> extends Fruit{

    private B[] box;

    public FruitBox(B... box){
        this.box = box;
    }
}
