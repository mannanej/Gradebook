package src;

import java.text.DecimalFormat;

/*
 * Gradebook for ----------ECE434: Embedded Linux----------
 * Most functions are taken care of by GradebookFunctions.java
 * The first set or arrays is for grades in each category, add grades as needed
 * The second set of ints is for the weight of each category
 */
public class ECE434_EMBEDDED_LINUX {

    // Set arrays for our grade calculations
    public final double[] homeworkGrade = { 100, 80, 100, 70, 70, 60, 100, 70, 75 };
    public final double[] quizGrade = { 85, 90, 80, 70, 40, 40, 40, 80, 83.33 }; // Bonus quiz gave a five free points, added to first
    public final double[] finalProjectGrade = { 60 };
    // Set our individual weights
    public final int homeworkWeight = 20;
    public final int quizWeight = 20;
    public final int finalProjectWeight = 60;
    // This will help us to round our final grade at the end
    public final DecimalFormat df = new DecimalFormat("0.00");
    public GradebookFunctions gradebookFunctions;

    public double homework() {

        return this.gradebookFunctions.evaluateArray(this.homeworkGrade);
    }

    public double quiz() {

        return this.gradebookFunctions.evaluateArray(this.quizGrade);
    }

    public double finalProject() {

        return this.gradebookFunctions.evaluateArray(this.finalProjectGrade);
    }

    /*
     * This function will use the averages for each category and its weight to
     * calculate a final grade
     */
    public void calculateGrade() {

        // Get the Gradebook Functions ready
        this.gradebookFunctions = new GradebookFunctions();
        // Calculate the final grade based off of weights and averages
        double finalPercent = ((this.homework() * this.homeworkWeight)
                + (this.quiz() * this.quizWeight) + (this.finalProject() * this.finalProjectWeight)) / 100;
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
        ECE434_EMBEDDED_LINUX gradebook = new ECE434_EMBEDDED_LINUX();
        gradebook.calculateGrade();
        System.out.println("End of Gradebook");
        System.out.println("");
    }
}
