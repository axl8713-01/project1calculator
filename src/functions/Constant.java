package functions;

/**
 * Constant is a primitive in the composite design of representing a mathematical function.
 *
 * @author Albin Liang
 */


public class Constant extends Function{

    //Fields
    /**
     * fields are value, the value of the constant, and isConstant, which is true.
     */
    private double value;
    private boolean isConstant;

    //Constructor
    /**
     * the Constant constructor creates a new Constant Function instance with value passed by the caller.
     *
     * @param value the value the constant will be.
     */
    public Constant (double value){
        super();
        this.value = value;
        this.isConstant = true; //Constant is indeed a constant.
    }


    //Methods

    /**
     * A constant evaluates by returning it's value.
     *
     * @param value unused parameter required by the inherited method.
     */
    public double evaluate(double value){
        return this.value;
    }

    /**
     * toString will return the string of the value of the constant.
     */
    @Override
    public String toString(){
        return Double.toString(value);
    }

    /**
     *derivative of a constant is always 0.
     */
    public Function derivative(){
        return new Constant(0);
    }

    /**
     * integral of Constant are of the closed form KX where k is the value of the constant.
     *
     * @param A Lower limit to evaluate the integral from.
     * @param B Upper limit to evaluate the integral from.
     * @param num unused parameter from Function
     */
   @Override
    public double integral(double A, double B, int num){
       Variable var = Variable.X;
       Product closedFormConstant = new Product(this, var);
       double difference = closedFormConstant.evaluate(B) - closedFormConstant.evaluate(A);
       return difference;
    }

    /**
     * Constant is a constant, returns true.
     */
    public boolean isConstant(){
        return this.isConstant;
    }
}