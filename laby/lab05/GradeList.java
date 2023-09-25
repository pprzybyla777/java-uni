import java.util.ArrayList;

public class GradeList {

    private ArrayList<Double> grades = new ArrayList<Double>();

    public GradeList() {

    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public void calcMean() {

        int sizeOfGradesArr = this.grades.size();

        if (  sizeOfGradesArr == 0 ) {
            System.out.println("You have no grades");
            return;
        }

        double gradesSum = 0;

        for (int i = 0; i < sizeOfGradesArr; i++) {
            gradesSum += this.grades.get(i);
        }

        double mean = gradesSum / sizeOfGradesArr;

        System.out.println("The mean of grades is: " + mean);

    }

    public void printHighestGrade() {

        int sizeOfGradesArr = this.grades.size();

        if (  sizeOfGradesArr == 0 ) {
            System.out.println("You have no grades");
            return;
        }

        double highest = this.grades.get(0);

        for (int i = 1; i < sizeOfGradesArr; i++) {

            if (grades.get(i) > highest) {
                highest = grades.get(i);
            }

        }

        System.out.println("The highest grade is " + highest);
    }

    public void printLowestGrade() {

        int sizeOfGradesArr = this.grades.size();

        if (  sizeOfGradesArr == 0 ) {
            System.out.println("You have no grades");
            return;
        }

        double lowest = this.grades.get(0);

        for (int i = 1; i < sizeOfGradesArr; i++) {

            if (grades.get(i) < lowest) {
                lowest = grades.get(i);
            }

        }

        System.out.println("The lowest grade is " + lowest);
    }

}
