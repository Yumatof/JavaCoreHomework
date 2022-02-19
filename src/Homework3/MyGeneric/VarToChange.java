package Homework3.MyGeneric;

public class VarToChange <T>{

    private T obj;

    public VarToChange(T obj){
        this.obj=obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
