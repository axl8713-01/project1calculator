/**
 *
 *
 * @author Albin Liang
 */

package functions;


public class Variable extends Function{

    //Fields
     public final static Variable X = new Variable();

    //Constructor
    private Variable(){
        super();
    }

    //Methods

    public double evaluate(double val){
        return val;
    }

    public Function derivative(){
        return new Constant(1);
    }

    @Override
    public double integral(double A, double B, int num){
        Product closedFormConstant = new Product(this, this, new Constant(0.5));
        double difference = (closedFormConstant.evaluate(B) - closedFormConstant.evaluate(A));
        return difference;
    }

    public boolean isConstant(){
        return false;
    }

    @Override
    public String toString(){
        return "x";
    }
}