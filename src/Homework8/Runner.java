package Homework8;
import com.github.javafaker.Faker;

import java.util.*;

import java.util.stream.Collectors;

public class Runner {

    Course courseRand = new Course(getCourseName());
    Course courseStat = new Course("DANCING");

    public static void main(String[] Args){

        List<Student> students = getListStudent();
        List<Course> uniqueCourse = getUniqueNamesCourse(students);
        List<String> inquisitiveStudents = getInquisitiveStudents(students);




        List<Course> coursesStat1 = new ArrayList<Course>(Arrays.asList
                (new Course("FOREIGN_LANGUAGE"),
                        new Course("HIGHER_MATHEMATICS"),
                        new Course("ELECTRICAL_ENGINEERING"),
                        new Course("DANCING")));

        List<Course> coursesStat2 = new ArrayList<Course>(Arrays.asList
                (new Course("FOREIGN_LANGUAGE"),
                        new Course("HIGHER_MATHEMATICS"),
                        new Course("ELECTRICAL_ENGINEERING")));

        List<Course> coursesStat3 = new ArrayList<Course>(Arrays.asList
                (new Course("FOREIGN_LANGUAGE"),
                        new Course("HIGHER_MATHEMATICS"),
                        new Course("HISTORY_OF_THE_MIDDLE_AGES"),
                        new Course("BIOLOGY"),
                        new Course("ELECTRICAL_ENGINEERING"),
                        new Course("NETWORK_TECHNOLOGIES")));
        List<Course> coursesStat4 = new ArrayList<Course>(Arrays.asList
                (new Course("FOREIGN_LANGUAGE")));
        List<Course> coursesStat5 = new ArrayList<Course>(Arrays.asList
                (new Course("FOREIGN_LANGUAGE"),
                        new Course("HIGHER_MATHEMATICS"),
                        new Course("HISTORY_OF_THE_MIDDLE_AGES"),
                        new Course("BIOLOGY"),
                        new Course("ELECTRICAL_ENGINEERING"),
                        new Course("NETWORK_TECHNOLOGIES"),
                        new Course("DRAWING")));


        List<Student> studentsStat = new ArrayList<>(Arrays.asList
                (new Student("Jhon Konnor", coursesStat4),
                        new Student("Sara Konnor", coursesStat3),
                        new Student("T800", coursesStat1),
                        new Student("T1000", coursesStat2),
                        new Student("alex", coursesStat5)));

        List<String> inquisitiveStudents2 = getInquisitiveStudents(studentsStat);
        for (String element:inquisitiveStudents2){
            System.out.println(element);
        }



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
            courseTmp.add(new Course(getCourseName()));
        }
        return courseTmp;
    }

    private static String getCourseName(){
        Course.NameCourses[] valuesNC = Course.NameCourses.values();
        Random rand = new Random();
        int randomInt = rand.nextInt(valuesNC.length);
        return valuesNC[randomInt].toString();
    }
    public static List<Course> getUniqueNamesCourse(List<Student> students){
       /*
       Set<Course> setTmp = students
                .stream()
                .filter(student -> student.courses.size() !=0)
                .map(student ->{
                    for(Course element:student.courses){
                        return element.getNameOfCourse();
                    }
                    return null;
                        })
               .collect(Collectors.toSet();
        */

        return null; // listTmp;
    }

    public static List<String> getInquisitiveStudents(List<Student> students){
        return students
                .stream()
                .sorted((obj1,obj2) -> obj2.courses.size() - obj1.courses.size())
                .limit(3)
                .map(obj -> obj.getFullName())
                .collect(Collectors.toList());
    }

}
