package Homework8;

public class Course {

    public enum NameCourses {
        FOREIGN_LANGUAGE,
        HIGHER_MATHEMATICS,
        DRAWING,
        HISTORY_OF_THE_MIDDLE_AGES,
        DANCING,
        LITERATURE,
        ELECTRICAL_ENGINEERING,
        BIOLOGY,
        NETWORK_TECHNOLOGIES,
        PROGRAMMING;
    }

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
