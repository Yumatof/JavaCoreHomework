package Homework8;

public class Course {

    private String nameOfCourse;

    public Course(String nameOfCourse){
        this.nameOfCourse=nameOfCourse;
    }

    public String getNameOfCourse(){
        return nameOfCourse;
    }
    public boolean equals (Course obj){
        if(obj == null) return false;
        if( this == obj) return true;
        if(this.nameOfCourse == obj.nameOfCourse) return true;
        return false;
    }
    public int hashCode(){
        int result = 1;
        return result + this.nameOfCourse.hashCode();
    }
}
