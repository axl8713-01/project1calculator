package functions;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Product is a composite class that can be made with variable number of function arguments
 * to represent a product function.
 *
 * @author Albin Liang
 */

public class Product extends Function{

    //Fields
    /**
     * the native array of terms held by the product function.
     */
    private Function[] terms;


    //Constructor
    /**
     * The product constructor checks for several cases. The initial coefficient is set to 1.0, and the non constants
     * are held in an array list and the coefficient is multiplied by the constants in the arguments. Then the
     * coefficient is check to see it is an identity. If it is 0 , zero out the product and lastly create a product
     * with the nonconstant terms and the coefficient.
     *
     * @param terms the variable arguments of Functions object, passed as individual functions or a native array of
     *              functions.
     */
    public Product(Function... terms){
        double totalCoefficient = 1.0;
        ArrayList<Function> nonConstants = new ArrayList<>();
        for (Function term : terms) {
            if (term.isConstant()) {
                totalCoefficient = term.evaluate(1.0)*totalCoefficient;
            }
            else {
                nonConstants.add(term);
            }
        }
        Function coefficient = new Constant(totalCoefficient);
        if (coefficient.evaluate(0.0)==1) {
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
        else if (coefficient.evaluate(0.0)==0){
                Function[] zero = new Function[1];
                zero[0] = new Constant(0);
                this.terms = zero;
            }
        else{
            nonConstants.add(coefficient);
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
    }

    //Methods

    /**
     * the value of the product is the product multiplied by the the evaluations of each term in the product with the
     * value inputted.
     *
     * @param val the double value inputted by user for for the variable.
     * @return
     */
    public double evaluate(double val){
        double product=1.0;
        for (Function term: terms){
            product = product * term.evaluate(val);
//            if (term.isConstant()){
//                product = term.evaluate(0.0) * product;
//            }
//            else {
//                product = product * val;
            }
        return product;
    }


    /**
     * The derivative of a product is a sum of the product of the first term differentiated, with the rest of the terms,
     * and the product of the rest of the terms differentiated with the first time. I used a recursive approach where
     * I create native subarrays of all the terms, slicing the first and the rest and then differentiate the terms
     * separately. Holding the rest as a product of the rest of the terms and polymorphism would recursively
     * differentiate the term simulating the chain rule.
     */
    public Function derivative(){
        if (terms.length > 1){
        Function[] firstTerm = Arrays.copyOfRange(terms,0,1);
        Function[] rest = Arrays.copyOfRange(terms,1,terms.length);
        Product restTerm = new Product(rest);
        Product restTermDerivatives = new Product(restTerm.derivative());
        Product firstHalf = new Product(firstTerm[0].derivative(), restTerm);
        Product secondHalf = new Product(firstTerm[0], restTermDerivatives);
        return new Sum(firstHalf,secondHalf);
        }
        else {// if there is only one term, return the derivative of that one term.
            return terms[0].derivative();
        }
    }

    /**
     * the product is a constant if the base case is a constant and or all it's leaves are constants.
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
     * similiar to the Sum toString except it concatenates a asterisk(*) instead.
     * @return
     */
    @Override
    public String toString() {
        if (terms.length > 1) {
            StringBuilder string = new StringBuilder("( ");
            for (int i = 0; i < terms.length; i++)
                if (i != terms.length - 1) {
                    string.append(terms[i].toString());
                    string.append(" * ");
                } else {
                    string.append(terms[i].toString());
                }
            string.append(" )");
            return string.toString();
        }
        else {
            return terms[0].toString();
        }
    }

}



