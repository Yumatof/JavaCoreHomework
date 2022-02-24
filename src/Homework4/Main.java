package Homework4;


import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args){
//case#1
        String[] duplicateStr = {"слово","пикник","сила","обочина","реверс",
                                 "повтор","стопор","ротор","слово","сила",
                                 "пикник","стопор","обочина","ротор","пикник"};

        System.out.println(findDuplicateInArray(duplicateStr).toString());

//case#2
        System.out.println("++++++++++");

        TelephoneHandbook handbook1 = new TelephoneHandbook();

        handbook1.testFilling();
        handbook1.addInHandbook("2232222","Котейский");

        System.out.println(handbook1.getNumber("Иванов"));

    }

    public static <T> HashMap<T, Integer> findDuplicateInArray (T[]tmpArray){

        HashSet hs = new HashSet();
        HashMap<T, Integer> hm = new HashMap<>();

        for(T element:tmpArray){
            if (hs.add(element)){
               hm.put(element, 1);
            } else{
                hm.put(element, (hm.get(element)+1));
            }

        }
        return hm;
    }
}
