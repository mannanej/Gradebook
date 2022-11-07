package src;

public class GradebookFunctions {

    public double evaluateArray(double[] array) {

        double total = 0;

        for (double i : array) {
            total += i;
        }
        total = total / array.length;
        return total;
    }

    public String convertToLetter(double percent) {

        if (percent < 100 && percent >= 90) {
            return "A";
        } else if (percent < 90 && percent >= 87) {
            return "B+";
        } else if (percent < 87 && percent >= 83) {
            return "B";
        } else if (percent < 83 && percent >= 80) {
            return "B-";
        } else if (percent < 80 && percent >= 77) {
            return "C+";
        } else if (percent < 77 && percent >= 73) {
            return "C";
        } else if (percent < 73 && percent >= 70) {
            return "C-";
        } else if (percent < 70 && percent >= 67) {
            return "D+";
        } else if (percent < 67 && percent >= 63) {
            return "D";
        } else if (percent < 63 && percent >= 60) {
            return "D-";
        } else if (percent < 60) {
            return "F";
        } else {
            return "A";
        }
    }
}
