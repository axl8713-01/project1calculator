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

    public boolean isConstant(){
        return false;
    }

    @Override
    public String toString(){
        return "X";
    }
}