public class Course {

    class ObstacleBuilder {
        private String titleObstacle;
        private String nameObstacle;
        private float minNormativeResult;
        private float maxNormativeResult;

        public ObstacleBuilder(String titleObstacle, String nameObstacle,float minNormativeResult,float maxNormativeResult){
            this.titleObstacle=titleObstacle;
            this.nameObstacle=nameObstacle;
            this.minNormativeResult=minNormativeResult;
            this.maxNormativeResult=maxNormativeResult;
        }
        public String getTitleObstacle(){
            return titleObstacle;
        }
        public String getNameObstacle(){
            return nameObstacle;
        }

        public float getMinNormativeResult() {
            return minNormativeResult;
        }

        public float getMaxNormativeResult() {
            return maxNormativeResult;
        }
    }

    private ObstacleBuilder[] obstacleCourse;

    Course(){
        obstacleCourse=createObstacleCourse();
    }

    private ObstacleBuilder[] createObstacleCourse(){
        ObstacleBuilder[] obstacleCourse = {new ObstacleBuilder("run","Бег на дистанцию 100 метров", 10.64f,14.4f),
        new ObstacleBuilder("jumpLong", "Прыжки в длинну",4, 7.1f),
        new ObstacleBuilder("jumpHeight","Прыжки в высоту", 1.3f, 2.1f)};
        return obstacleCourse;
    }

    public void passingCourse(TeamBuilder team){
        for (int i=0; i<obstacleCourse.length; i++){
            for(TeamBuilder.TeamMember t:team.lineUp){
            //for (int j=0;j<team.lineUp.length; j++){
                System.out.println(t.getMemberName());


            }
        }
    }

}
