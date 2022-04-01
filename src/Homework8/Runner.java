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
           //List<String> inquisitiveStudents = getInquisitiveStudents(students);
         //printList(inquisitiveStudents);


        //набор статичных тестовых данных
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

        //List<String> inquisitiveStudentsStat = getInquisitiveStudents(studentsStat);
        //printList(inquisitiveStudentsStat);

        //List<String> uniqueNamesCourse = getUniqueNamesCourse(studentsStat);
        //printList(uniqueNamesCourse);


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
            //должно записывать только уникальные значения, но Java heap space
            /*
            while (true){
                String nameTmp = Course.NameCourses.values()[rand.nextInt(valuesNC.length)].toString();
                if (courseTmp.size() == 0){
                    courseTmp.add(new Course(nameTmp));
                    break;
                } else {
                    for(Course element:courseTmp){
                        if(!element.getNameOfCourse().equals(nameTmp)){
                            courseTmp.add(new Course(nameTmp));
                            break;
                        }
                    }
                }
            }
             */
        }
        return courseTmp;
    }

    public static List<String> getUniqueNamesCourse(List<Student> students){
        return new ArrayList<>(students
                .stream()
                .flatMap(student -> student.courses.stream())
                .map(courses -> courses.getNameOfCourse())
               .distinct()
               .collect(Collectors.toSet()));
    }

    public static List<String> getInquisitiveStudents(List<Student> students){
        return students
                .stream()
                .sorted((s1,s2) -> s2.courses.size() - s1.courses.size())
                .limit(3)
                .map(obj -> obj.getFullName())
                .collect(Collectors.toList());
    }

    public static List<String> getNameStudentRecordToCourse(List<Student> students, Course course){

        return null;
    }
}
