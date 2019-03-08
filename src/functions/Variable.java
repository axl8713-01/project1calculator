/**
 * Variable is a primitive to represent the variable X. There is only ever one variable in the function.
 *
 * @author Albin Liang
 */

package functions;


public class Variable extends Function{

    //Fields
    /**
     * X is a final static instance of Variable that is used by other Functions.
     * Variable is not a constant and will return false;
     */
     public final static Variable X = new Variable();
    private boolean isConstant;

    //Constructor

    /**
     * the constructor is private since there will only be one instance type at a time.
     */
    private Variable(){
        super();
        isConstant=false; //variable is not a constant.
    }

    //Methods

    /**
     * a variable will evaluate the value passed into the method.
     *
     * @param val the double value inputted by user for for the variable.
     */
    public double evaluate(double val){
        return val;
    }

    /**
     * The derivative of a variable X is 1.
     * @return
     */
    public Function derivative(){
        return new Constant(1);
    }

    /**
     * The integral of a variable is in the closed form of x^n+1 / n+1, n in this case is always 1. so 1/2 * x ^ 2
     *
     * @param A the lower limit.
     * @param B the upper limit.
     * @param num unused parameter from the super class.
     */
    @Override
    public double integral(double A, double B, int num){
        Product closedFormConstant = new Product(this, this, new Constant(0.5));
        return (closedFormConstant.evaluate(B) - closedFormConstant.evaluate(A));

    }

    /**
     * Variable is not a constant return false.
     */
    public boolean isConstant(){
        return isConstant;
    }

    /**
     * a string of the variable is "x".
     */
    @Override
    public String toString(){
        return "x";
    }
}