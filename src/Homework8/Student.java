package Homework8;

import java.util.List;

public class Student {

    private String fullName;
    List<Course> coureses;

    public Student(String fullName, List<Course> coureses){
        this.fullName = fullName;
        this.coureses =  coureses;
    }

    public String getFullName(){
        return fullName;
    }

    public List<Course> getCoureses() {
        return coureses;
    }
    public boolean equals (Student obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.fullName == this.fullName && obj.coureses == this.coureses) return true;
        return false;
    }
    public int hashcode(){
        int result = 1;
        return result + fullName.hashCode() + coureses.hashCode();
    }

}
