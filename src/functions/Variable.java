/**
 *
 *
 * @author Albin Liang
 */

package functions;


public class Variable extends Function{

    //Fields
     public final static Variable X = new Variable();
    private boolean isConstant;

    //Constructor
    private Variable(){
        super();
        isConstant=false;
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
        return (closedFormConstant.evaluate(B) - closedFormConstant.evaluate(A));

    }

    public boolean isConstant(){
        return isConstant;
    }

    @Override
    public String toString(){
        return "x";
    }
}