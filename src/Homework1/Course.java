package Homework1;

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

    public ObstacleBuilder[] obstacleCourse;
    private int countMemberTeamWin=0;

    Course(){
                obstacleCourse=createObstacleCourse();
    }


    private ObstacleBuilder[] createObstacleCourse(){
        ObstacleBuilder[] obstacleCourse = {new ObstacleBuilder("run","Бег на дистанцию 100 метров", 10.64f,14.4f),
        new ObstacleBuilder("jumpLong", "Прыжки в длинну",4.1f, 7.1f),
        new ObstacleBuilder("jumpHeight","Прыжки в высоту", 1.3f, 2.1f)};
        return obstacleCourse;
    }

    public void passingCourse(TeamBuilder team){
        for (Course.ObstacleBuilder c:obstacleCourse){
            for(TeamBuilder.TeamMember t:team.lineUp){
                switch(c.titleObstacle){
                    case "run":
                        t.setResultRun(
                                checkResultRun(t.getRunTime100m(), c.minNormativeResult, c.maxNormativeResult));
                        break;
                    case "jumpLong":
                        t.setResultLongJump(
                                checkResultJump(t.getLongJump(), c.minNormativeResult, c.maxNormativeResult));
                        break;
                    case "jumpHeight":
                        t.setResultHighJump(
                                checkResultJump(t.getHighJump(), c.minNormativeResult, c.maxNormativeResult));
                        break;
                }


            }
        }
    }

    private boolean checkResultRun(float personResult, float minResult, float maxResult){

        return personResult < minResult || personResult < maxResult;
    }
    private boolean checkResultJump(float personResult, float minResult, float maxResult){

        return personResult > minResult || personResult > maxResult;

    }

}
