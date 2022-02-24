package Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TelephoneHandbook {

    private HashMap<String,String> handbook = new HashMap<>();



    public String getToString(){
        return handbook.toString();
    }
    public HashMap<String,String> getHashMap(){
        return handbook;
    }

    public void addInHandbook(String key, String value){
        handbook.put(key, value);
    }

    public void testFilling(){
        Integer number = 7635513;
        for(int i=10;i<70; i+=13){
            number += i;
            handbook.put(number.toString(), "Иванов");//add key - number, value - phone surname
        }
        handbook.put("+7(900) 000 0000", "Петров");
        handbook.put("5553322","Сергеев");
        handbook.put("558877","Массивов");
        handbook.put("9955334","Зеленый");
        handbook.put("3355771","Корзинкин");
    }
    public String getNumber(String surname){
        ArrayList<String> resultSerch = new ArrayList<>(100);
        Iterator iter=handbook.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry tmpStr = (Map.Entry)iter.next();
            if(tmpStr.getValue() == surname){
                resultSerch.add(tmpStr.getKey().toString());
            }

        }
        return resultSerch.toString();

    }
}
