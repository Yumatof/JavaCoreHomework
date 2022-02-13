public class Main {

    public static void main(String[]args){

        TeamBuilder team1 = new TeamBuilder("Cats", "Cats never eat bats");
        Course course1 = new Course();

        course1.passingCourse(team1);

        System.out.println(team1.lineUp[0].getMemberName());

    }

}
