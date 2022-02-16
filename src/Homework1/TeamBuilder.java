package Homework1;

public class TeamBuilder {

    class TeamMember{
        private String memberName;
        private int age;
        private float weight;
        private float runTime100m;
        private float longJump;
        private float highJump;
        private boolean resultRun;
        private boolean resultLongJump;
        private boolean resultHighJump;

        public TeamMember(String MemberName, int age, float weight, float runTime100m,
                          float longJump, float highJump){
            this.memberName = MemberName;
            this.age = age;
            this.weight=weight;
            this.runTime100m=runTime100m;
            this.longJump=longJump;
            this.highJump=highJump;
            resultRun=false;
            resultLongJump=false;
            resultHighJump=false;

        }
        public TeamMember(){
            memberName = "John Dou";
            age = 18;
            weight=80.5f;
            runTime100m=153.7f;
            longJump=3.7f;
            highJump=0f;
        }

        public String getMemberName() {
            return memberName;
        }

        public String getMemberInfo(){
            return "Имя участника команды: "+memberName+", возраст: "+age+" полных лет, вес: "+weight+" кг.";
        }

        public float getRunTime100m() {
            return runTime100m;
        }

        public float getLongJump() {
            return longJump;
        }

        public float getHighJump() {
            return highJump;
        }
        public void setResultRun(boolean result){
            resultRun=result;
        }
        public void setResultLongJump(boolean result){
            resultLongJump=result;
        }
        public void setResultHighJump(boolean result){
            resultHighJump=result;
        }


    }


    private String teamName;
    private String slogan;
    public TeamMember[] lineUp;

    public TeamBuilder(String teamName,String slogan){
        lineUp = createLineUp();

        this.teamName=teamName;
        this.slogan=slogan;




    }
    private TeamMember[] createLineUp(){
        TeamMember[] lineUp = {new TeamMember("Иванов Иван", 21, 79.1f, 12.7f,4.25f,1.1f),
                new TeamMember("Сидоров Сидор", 22, 81.32f, 14.1f,1.7f,2.05f),
                new TeamMember("Петров Петр", 20, 75.8f, 12.1f,2.05f,2.3f),
                new TeamMember()};
        return lineUp;
    }
    public void getFullTeamInfo(){
        System.out.println("Название команды: " + teamName);
        for(int i=0; i<lineUp.length;i++){
            System.out.println(lineUp[i].getMemberInfo());
        }
    }
    public void resultPassing(Course course){
        for(TeamMember t:lineUp){
            for(Course.ObstacleBuilder c:course.obstacleCourse){
                switch(c.getTitleObstacle()){
                    case "run":
                        if(t.resultRun){
                          System.out.println(t.getMemberName() + " прошел препятствие: " + c.getNameObstacle());
                       } else {
                          System.out.println(t.getMemberName() + " не смог пройти препятствие " + c.getNameObstacle());
                         }
                        break;
                    case "jumpLong":
                        if(t.resultLongJump){
                            System.out.println(t.getMemberName() + " прошел препятствие: " + c.getNameObstacle());
                        } else {
                            System.out.println(t.getMemberName() + " не смог пройти препятствие " + c.getNameObstacle());
                        }
                        break;
                    case "jumpHeight":
                        if(t.resultHighJump){
                            System.out.println(t.getMemberName() + " прошел препятствие: " + c.getNameObstacle());
                        } else {
                            System.out.println(t.getMemberName() + " не смог пройти препятствие " + c.getNameObstacle());
                        }
                        break;
                }
            }



        }
    }






}



