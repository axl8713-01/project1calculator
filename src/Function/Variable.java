/**
 *
 *
 * @author Albin Liang
 */

package Function;


public class Variable extends Function{
    //Fields
     public final static Variable X = new Variable();

    //Constructor
    private Variable(){
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

}