package Homework8;
import com.github.javafaker.Faker;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

public class Runner {

    public static void main(String[] Args){

        List<Student> students = getListStudent();
        System.out.println(getListUniqalCourses(students));

        /*
        for(Student element:students){
            System.out.println(element.getCoureses().size());
            System.out.println("**********");
        }
         */


    }

    private static List<Student> getListStudent(){
        List<Student> studentsTmp = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i++){
            studentsTmp.add(new Student(faker.name().toString(), getListCourse()));
        }
        return studentsTmp;
    }

    private static List<Course> getListCourse(){
        List<Course> courseTmp = new ArrayList<>();
        Course.NameCourses[] valuesNC = Course.NameCourses.values();
        Random rand = new Random();
        for(int i = 0; i < rand.nextInt(valuesNC.length); i++){
            int randomInt = rand.nextInt(valuesNC.length);
            courseTmp.add(new Course(valuesNC[randomInt].toString()));
        }
        return courseTmp;
    }
    public static String getListUniqalCourses(List<Student> students){
        String nameCourseTmp = students.stream()


        return nameCourseTmp;
    }

}
