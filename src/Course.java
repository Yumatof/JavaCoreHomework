public class Course {

    class ObstacleBuilder {
        private String nameObstacle;
        private float minNormativeResult;
        private float maxNormativeResult;

        public ObstacleBuilder(String nameObstacle,float minNormativeResult,float maxNormativeResult){
            this.nameObstacle=nameObstacle;
            this.minNormativeResult=minNormativeResult;
            this.maxNormativeResult=maxNormativeResult;
        }
    }

    private ObstacleBuilder[] obstacleCourse;

    Course(){
        obstacleCourse=createObstacleCourse();
    }

    private ObstacleBuilder[] createObstacleCourse(){
        ObstacleBuilder[] obstacleCourse = {new ObstacleBuilder("Бег на дистанцию 100 метров", 10.64f,14.4f),
        new ObstacleBuilder("Прыжки в длинну",4, 7.1f),
        new ObstacleBuilder("Прыжки в высоту", 1.3f,2)};
        return obstacleCourse;
    }

    public void passingCourse(TeamBuilder team){
        for (int i=0; i<obstacleCourse.length; i++){
            for (int j=0;j<team.lineUp.length; j++){
                System.out.println(team.lineUp[j].getMemberName());


            }
        }
    }

}
