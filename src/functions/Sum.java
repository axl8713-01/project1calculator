package functions;
import java.util.ArrayList;

/**
 * Sum is a composite that can be made of variable number of function objects.
 *
 * @author Albin Liang
 */

public class Sum extends Function{

    //Fields
    /**
     * the native array of terms held by the sum function.
     */
    private Function[] terms;

    //Constructor

    /**
     * The sum constructor checks for several cases. If it is a composite with multiple terms and constants, it will
     * sum up the constants to one term. It also has to check the sum for a zero case where there is just a zero and
     * it will return a zero constant in the sum by itself. If the constants are zero and there are non constant terms
     * return the sum of those terms as a sum, other wise, return all the non constants added with a constant.
     *
     * @param terms the variable arguments of Functions object, passed as individual functions or a native array of
     *              functions.
     */
    public Sum(Function... terms) {
        double totalConstant = 0.0;//total the constants
        ArrayList<Function> nonConstants = new ArrayList<>();//create an array list to hold constants.
        for (Function term : terms) {//for all the argumeents, check whether it is a constant term or not
            if (term.isConstant()) {
                totalConstant += term.evaluate(0.0);// if yes sum it up to the total constant counter.
            } else {
                nonConstants.add(term);//otherwise it is a non constant term.
            }
        }

        if (totalConstant == 0.0 && terms.length == 0){
            Function[] sum = new Function[1];
            sum[0] = new Constant(0);
            this.terms = sum;
        }

        if (totalConstant == 0.0 && terms.length == 1 && terms[0].isConstant()) {//the zero case by itself
            Function[] sum = new Function[1];
            sum[0] = new Constant(0);
            this.terms = sum;//pass the zero as the only term.
        }
//        else if (totalConstant == 0.0) {
//
//        }
        else if (totalConstant == 0.0) { //if it is just adding a zero to non constants, return only non constants
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
        else {//else return the non constants and the updated constant.
            Function total = new Constant(totalConstant);//instantiate the updated constant.
            nonConstants.add(total); //add it to the array list
            this.terms = new Function[nonConstants.size()]; //make it into a native array.
            this.terms = nonConstants.toArray(this.terms); //pass the native array into the terms.
        }
    }

    //Methods

    /**
     * The sum is evaluated as the sum of the constant's value with the variable's value the variable number of times.
     *
     * @param val the double value inputted by user for for the variable.
     */
    public double evaluate(double val){
        double total =  0.0;
        for (Function term: terms){
            total += term.evaluate(val);
        }
        return total;
    }

    /**
     * derivative of a sum is the sum of the derivatives of the terms.
     *
     */
    public Function derivative(){
        Function[] derivatives = new Function[terms.length];
        for (int i=0; i<terms.length; i++){
            derivatives[i] = terms[i].derivative();
        }
        return new Sum(derivatives);
    }

    @Override
    /**
     * the integral of a sum is the sum of the individual integrals of the terms.
     *
     * @param A the lower limit of the integral
     * @param B the upper limit of the integral
     * @param num unused parameter from the superclass.
     */
    public double integral(double A, double B, int num){
        double sumIntegrals = 0.0;
        for (int i=0; i<terms.length; i++){
            double integral = terms[i].integral(A, B, num);
            sumIntegrals += integral;
        }
        return sumIntegrals;
    }

    /**
     * a Sum is constant if the base case is a instance of constant or all of it's leaves are constant.
     */
    public boolean isConstant(){
       for (Function term : this.terms) {
           if (!term.isConstant()) {
               return false;
           }
       }
       return true;
    }

    /**
     * toString of Sum pretty prints it to have parenthesis and + in between each of the sums terms.
     */
    @Override
    public String toString() {
        if (terms.length > 1) {//if it's not a sum with only one term.
            StringBuilder string = new StringBuilder("( ");
            for (int i = 0; i < terms.length; i++)
                if (i != terms.length - 1) {
                    string.append(terms[i].toString());
                    string.append(" + ");
                } else {
                    string.append(terms[i].toString());
                }
            string.append(" )");
            return string.toString();
        }
        else {
            Function singleTerm = terms[0];
            return singleTerm.toString();
        }
    }
}
