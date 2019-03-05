/**
 *
 * @author Albin Liang
 */

package Function;

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
    public double evaluate(){
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
//    public double integral(double A, double B, int n){

    /**
     *
     */
    public boolean isConstant(){
        return true;
    }
}