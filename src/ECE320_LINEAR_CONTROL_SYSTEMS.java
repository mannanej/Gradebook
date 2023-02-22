package src;

import java.text.DecimalFormat;

/*
 * Gradebook for ----------CSSE490: BioInspired Artificial Intelligence----------
 * Most functions are taken care of by GradebookFunctions.java
 * The first set or arrays is for grades in each category, add grades as needed
 * The second set of ints is for the weight of each category
 */
public class ECE320_LINEAR_CONTROL_SYSTEMS {

    // Set arrays for our grade calculations
    public final double[] homeworkGrade = { 86.36, 88.23, 66.19, 64.81, 60, 91.66, 73.07, 61.53, 75 };
    public final double[] labGrade = { 60, 90, 95, 100, 70, 60, 60, 60, 60 };
    public final double[] quizGrade = { 80.95, 61.53, 57.14, 60.00, 83.84, 92.3, 81.81, 56.25 };
    public final double[] examGrade = { 42, 59 };
    public final double[] finalExamGrade = { 79 };
    // Set our individual weights
    public final int examWeight = 30;
    public final int homeworkWeight = 15;
    public final int quizWeight = 10;
    public final int finalExamWeight = 35;
    public final int labWeight = 10;
    // This will help us to round our final grade at the end
    public final DecimalFormat df = new DecimalFormat("0.00");
    public GradebookFunctions gradebookFunctions;

    public double exam() {

        return this.gradebookFunctions.evaluateArray(this.examGrade);
    }

    public double homework() {

        return this.gradebookFunctions.evaluateArray(this.homeworkGrade);
    }

    public double quiz() {

        return this.gradebookFunctions.evaluateArray(this.quizGrade);
    }

    public double finalExam() {

        return this.gradebookFunctions.evaluateArray(this.finalExamGrade);
    }

    public double lab() {

        return this.gradebookFunctions.evaluateArray(this.labGrade);
    }

    /*
     * This function will use the averages for each category and its weight to
     * calculate a final grade
     */
    public void calculateGrade() {

        // Get the Gradebook Functions ready
        this.gradebookFunctions = new GradebookFunctions();
        // Calculate the final grade based off of weights and averages
        double finalPercent = ((this.exam() * this.examWeight) + (this.homework() * this.homeworkWeight)
                + (this.quiz() * this.quizWeight) + (this.finalExam() * this.finalExamWeight)
                + (this.lab() * this.labWeight)) / 100;
        finalPercent = Math.round(finalPercent * 100.0) / 100.0;
        // Print info for the user
        System.out.println("Final Grade: " + this.gradebookFunctions.convertToLetter(finalPercent));
        System.out.println("Final Percentage: " + finalPercent + "%");
    }

    /*
     * The Main function. Just gets the ball rolling and gets rid of stupid static
     * calls
     */
    public static void main(String[] args) {
        ECE320_LINEAR_CONTROL_SYSTEMS gradebook = new ECE320_LINEAR_CONTROL_SYSTEMS();
        gradebook.calculateGrade();
        System.out.println("End of Gradebook");
        System.out.println("");
    }
}
