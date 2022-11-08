package src;

import java.text.DecimalFormat;

/*
 * Gradebook for ----------ECE433: Advanced Digital System Design with Verilog----------
 * Most functions are taken care of by GradebookFunctions.java
 * The first set or arrays is for grades in each category, add grades as needed
 * The second set of ints is for the weight of each category
 */
public class ECE433_VERILOG {

    // Set arrays for our grade calculations
    public final double[] examGrade = { 77 };
    public final double[] homeworkGrade = { 21.82, 82.4, 52 };
    public final double[] labGrade = { 100, 100, 100, 70, 70, 70, 100, 90 };
    public final double[] finalProjectGrade = { 100 };
    // Set our individual weights
    public final int examWeight = 20;
    public final int homeworkWeight = 10;
    public final int labWeight = 50;
    public final int finalProjectWeight = 20;
    // This will help us to round our final grade at the end
    public final DecimalFormat df = new DecimalFormat("0.00");
    public GradebookFunctions gradebookFunctions;

    public double exam() {

        return this.gradebookFunctions.evaluateArray(this.examGrade);
    }

    public double homework() {

        return this.gradebookFunctions.evaluateArray(this.homeworkGrade);
    }

    public double lab() {

        return this.gradebookFunctions.evaluateArray(this.labGrade);
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
        double finalPercent = ((this.exam() * this.examWeight) + (this.homework() * this.homeworkWeight)
                + (this.lab() * this.labWeight) + (this.finalProject() * this.finalProjectWeight)) / 100;
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
        ECE433_VERILOG gradebook = new ECE433_VERILOG();
        gradebook.calculateGrade();
        System.out.println("End of Gradebook");
        System.out.println("");
    }
}
