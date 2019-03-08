package functions;



/**
 *Sine represents the trigonometric function sine in our composite design.
 *
 * @author Albin Liang
 */

public class Sine extends Function {

    //Fields
    /**
     * Trig functions always only holds one subordinate which can be either a composite or primitive function.
     */
    private Function subordinate;

    //Constructor

    /**
     * Create a sine function with it's subordinate assigned.
     * @param subordinate the trig function's subordinate
     */
    public Sine (Function subordinate){
        this.subordinate = subordinate;
    }

    //Methods

    /**
     * the value of sin is calculated using the Math class sin, on the subordinate evaluated on val.
     *
     * @param val the double value inputted by user for for the variable.
     */
    public double evaluate(double val){
        return Math.sin(subordinate.evaluate(val));
    }

    /**
     * the derivative of sine is product of the subordinate differentiated, with the
     * outer function differentiated at the original subordinate function : represented by (fog)(x)' = g'(x) * f'(g(x))
     * where the derivative of sine is cosine.
     */
    public Function derivative() {
        Product sinDerivative = new Product(subordinate.derivative(), new Cosine(subordinate));
        return sinDerivative;
    }

    /**
     * the trig function is constant if the subordinate is constant.
     */
    public boolean isConstant(){
        return (this.subordinate.isConstant());
    }

    /**
     * the trig function prints out in the form : sin( *subordinate* )
     */
    @Override
    public String toString() {
            StringBuilder string = new StringBuilder("sin( ");
            string.append(subordinate.toString());
            string.append(" )");
            return string.toString();
    }
}
