package Homework8;

import java.util.List;

public class Student {

    private String fullName;
    List<Course> courses;

    public Student(String fullName, List<Course> courses){
        this.fullName = fullName;
        this.courses =  courses;
    }

    public String getFullName(){
        return fullName;
    }

    public List<Course> getCoureses() {
        return courses;
    }
    public boolean equals (Student obj){
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.fullName == this.fullName && obj.courses == this.courses) return true;
        return false;
    }
    public int hashcode(){
        int result = 1;
        return result + fullName.hashCode() + courses.hashCode();
    }

}
