public class Main {

    abstract class SocialStudiesCourse {
        protected int grade;

        public void setGrade(int grade) {
            if (grade >= 0 && grade <= 100) {
                this.grade = grade;
            } else {
                throw new IllegalArgumentException("Grade must be between 0 and 100");
            }
        }

        public int getGrade() {
            return grade;
        }
    }

    interface ScienceCourse {
        void setGrade(String grade);
        String getGrade();
    }

    class English extends SocialStudiesCourse { }

    class History extends SocialStudiesCourse {}

    class Mathematics implements ScienceCourse {
        private String grade;

        @Override
        public void setGrade(String grade) {this.grade = grade;}

        @Override
        public String getGrade() {return grade;}
    }

    class Physics implements ScienceCourse {
        private String grade;

        @Override
        public void setGrade(String grade) {this.grade = grade;}

        @Override
        public String getGrade() {
            return grade;
        }
    }

    class School {
        private SocialStudiesCourse socialStudiesCourse;
        private ScienceCourse scienceCourse;

        public void setSocialStudiesCourse(SocialStudiesCourse socialStudiesCourse) {
            this.socialStudiesCourse = socialStudiesCourse;
        }

        public void setScienceCourse(ScienceCourse scienceCourse) {
            this.scienceCourse = scienceCourse;
        }

        public void printGrades() {
            if (socialStudiesCourse != null) {
                System.out.println("Social Studies grade: " + socialStudiesCourse.getGrade());
            }
            if (scienceCourse != null) {
                System.out.println("Science grade: " + scienceCourse.getGrade());
            }
        }
    }


    public void main(String[] args) {
        School school = new School();

        English english = new English();
        english.setGrade(85);
        school.setSocialStudiesCourse(english);

        Mathematics math = new Mathematics();
        math.setGrade("A+");
        school.setScienceCourse(math);

        school.printGrades();
    }
}