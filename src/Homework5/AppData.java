package Homework5;

import java.io.*;

public class  AppData<T extends Number> {
//<T extends Number>


    private T dataArray[][];
    private String []header;

    public AppData(T [][] tmpArray){
        dataArray = tmpArray;
        createHeader();

    }

    private void createHeader(){
        header = new String[dataArray[0].length];
        for (int i=0; i<header.length; i++){
            header[i] = "Value " + (i+1);
        }

    }

    public void writeToFile(){

       try (BufferedWriter writer = new BufferedWriter
               (new FileWriter("src/Homework5/resurses/demoTab.csv"))){
           for (int i = 0; i<header.length; i++){
               writer.write(header[i] + ";");
           }
           writer.write("\n");

           for (int i=0; i<dataArray.length; i++){
               for (int j=0; j<dataArray[i].length; j++) {
                    writer.write(dataArray[i][j] + ";");
               }
               writer.write("\n");
           }
       } catch (IOException e){
           e.printStackTrace();
       }
   }

    public void readFromFile(){
        try(BufferedReader reader = new BufferedReader
                (new FileReader("src/Homework5/resurses/demoTab.csv"))){
            String tmpStr;
            while((tmpStr = reader.readLine()) != null){
                System.out.println(tmpStr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
