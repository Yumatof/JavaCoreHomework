package Homework8;

import net.datafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] Args){

        Course courseStat = new Course("DANCING");

        List<Student> students = getListStudent();//создание рандомного массива данных

        List<String> uniqueCourse = getUniqueNamesCourse(students);
        printList(uniqueCourse);

        List<String> inquisitiveStudents = getInquisitiveStudents(students);
        printList(inquisitiveStudents);

        List<String> nameStudentRecordToCourse = getNameStudentRecordToCourse(students, courseStat);
        printList(nameStudentRecordToCourse);

    }

    public static void printList(List<String> inputList) {
        for (String element : inputList) {
            System.out.println(element);
        }
    }

    private static List<Student> getListStudent(){
        List<Student> studentsTmp = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i++){
            studentsTmp.add(new Student(faker.name().fullName(), getListCourse()));
        }
        return studentsTmp;
    }

    private static List<Course> getListCourse(){
        List<Course> courseTmp = new ArrayList<>();
        Random randLength = new Random();
        Random randValue= new Random();
        for(int i = 1; i < randLength.nextInt(Course.NameCourses.values().length) +1; i++){
            courseTmp.add(new Course(Course.NameCourses.values()[randValue.nextInt(Course.NameCourses.values().length)].toString()));
        }
        return courseTmp;
    }

    public static List<String> getUniqueNamesCourse(List<Student> students){
        return new ArrayList<>(students.stream()
                .flatMap(student -> student.courses.stream())
                .map(courses -> courses.getNameOfCourse())
                .collect(Collectors.toSet()));
    }

    public static List<String> getInquisitiveStudents(List<Student> students){
        return students.stream()
                .sorted((s1,s2) -> s2.courses.size() - s1.courses.size())
                .limit(3)
                .map(obj -> obj.getFullName())
                .collect(Collectors.toList());
    }

    public static List<String> getNameStudentRecordToCourse(List<Student> students, Course inputCourse){
        return students.stream()
                        .map(student ->{
                            for (Course element: student.courses) {
                                if(element.equals(inputCourse)) return student.getFullName();
                            }
                            return null;
                        })
                        .filter(obj -> obj !=null)
                        .collect(Collectors.toList());
    }
}
