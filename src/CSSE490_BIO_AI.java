package src;

import java.text.DecimalFormat;

/*
 * Gradebook for ----------CSSE490-Bio AI----------
 * Most functions are taken care of by GradebookFunctions.java
 * The first set or arrays is for grades in each category, add grades as needed
 * The second set of ints is for the weight of each category
 */
public class CSSE490_BIO_AI {

    // Set arrays for our grade calculations
    public final double[] examGrade = { 86.21, 64 };
    public final double[] homeworkGrade = { 100, 80, 100, 66.67, 74, 100, 100 };
    public final double[] quizGrade = { 100 };
    public final double[] finalProjectGrade = { 100 };
    public final double[] participationGrade = { 100 };
    // Set our individual weights
    public final int examWeight = 20;
    public final int homeworkWeight = 40;
    public final int quizWeight = 10;
    public final int finalProjectWeight = 20;
    public final int participationWeight = 10;
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

    public double finalProject() {

        return this.gradebookFunctions.evaluateArray(this.finalProjectGrade);
    }

    public double participation() {

        return this.gradebookFunctions.evaluateArray(this.participationGrade);
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
                + (this.quiz() * this.quizWeight) + (this.finalProject() * this.finalProjectWeight)
                + (this.participation() * this.participationWeight)) / 100;
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
        CSSE490_BIO_AI gradebook = new CSSE490_BIO_AI();
        gradebook.calculateGrade();
        System.out.println("End of Gradebook");
        System.out.println("");
    }
}
