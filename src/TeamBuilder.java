public class TeamBuilder {

    class TeamMember{
        private String memberName;
        private int age;
        private float weight;
        private float runTime100m;
        private float longJump;
        private float highJump;

        public TeamMember(String MemberName, int age, float weight, float runTime100m,
                          float longJump, float highJump){
            this.memberName = MemberName;
            this.age = age;
            this.weight=weight;
            this.runTime100m=runTime100m;
            this.longJump=longJump;
            this.highJump=highJump;
        }
        public TeamMember(){
            memberName = "John Dou";
            age = 18;
            weight=80.5f;
            runTime100m=3.7f;
            longJump=3.7f;
            highJump=3.7f;
        }

        public String getMemberName() {
            return memberName;
        }

        public String getMemberInfo(){
            return memberName+" "+age+""+weight;
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
        TeamMember[] lineUp = {new TeamMember("Иванов Иван", 21, 79.1f, 12.7f,1.95f,2.1f),
                new TeamMember("Сидоров Сидор", 22, 81.32f, 14.1f,1.7f,2.05f),
                new TeamMember("Петров Петр", 20, 75.8f, 12.1f,2.05f,2.3f),
                new TeamMember()};
        return lineUp;
    }


}



