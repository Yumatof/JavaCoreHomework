//homework#1 JavaCore by Yumatov Maksim

public class Main {

    public static void main(String[]args){

        TeamBuilder team1 = new TeamBuilder("Cats", "Cats never eat bats");
        Course course1 = new Course();
        team1.getFullTeamInfo();
        System.out.println("********");
        course1.passingCourse(team1);
        team1.resultPassing(course1);



    }

}
