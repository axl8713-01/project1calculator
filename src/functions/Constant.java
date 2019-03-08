/**
 *
 * @author Albin Liang
 */

package functions;

/**
 *
 */
public class Constant extends Function{
    /**
     *
     */
    private double value;

    /**
     *
     */
    public Constant (double value){
        super();
        this.value = value;
    }

    /**
     *
     */
    public double evaluate(double value){
        return this.value;
    }

    /**
     *
     */
    @Override
    public String toString(){
        return Double.toString(value);
    }

    /**
     *
     */
    public Function derivative(){
        return new Constant(0);
    }

    /**
     *
     */
   @Override
    public double integral(double A, double B, int num){
       Variable var = Variable.X;
       Product closedFormConstant = new Product(this, var);
       double difference = closedFormConstant.evaluate(B) - closedFormConstant.evaluate(A);
       return difference;
    }

    /**
     *
     */
    public boolean isConstant(){
        return true;
    }
}