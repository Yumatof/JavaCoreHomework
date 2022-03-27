package Homework7.MyException;

public class invalidDateException extends Exception{
    public invalidDateException(String date){
        super("Вы ввели дату в неправильном формате или выбрали день для которого пока еще нет прогноза.\n"
                + "Пожалуйста проверьте - "+ date);
    }
}

