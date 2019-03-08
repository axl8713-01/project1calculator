package functions;


/**
 * Cosine represents the trigonometric function cosine in our composite design.
 *
 * @author Albin Liang
 */

public class Cosine extends Function{

    //Fields
    /**
     * same as sine, there is only one subordinate per cosine.
     */
    private Function subordinate;

    //Constructor

    /**
     * The cosine is constructed with one subordinate
     *
     * @param subordinate the trig function's subordinate.
     */
    public Cosine (Function subordinate){
        this.subordinate = subordinate;
    }

    //Methods
    /**
     * the value of cos is calculated using the Math class cos, on the subordinate evaluated on val.
     *
     * @param val the double value inputted by user for for the variable.
     */
    public double evaluate(double val){
        return Math.cos(subordinate.evaluate(val));
    }


    /**
     * the derivative of cosine is product of the subordinate differentiated, with the
     * outer function differetiated at the original subordinate function : represented by (fog)(x)' = g'(x) * f'(g(x))
     * where the derivative of cosine is (-1) sine.
     */
    public Function derivative() {

        Product cosDerivative = new Product(new Constant(-1.0),subordinate.derivative(), new Sine(subordinate));
        return cosDerivative;
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
        StringBuilder string = new StringBuilder("cos( ");
        string.append(subordinate.toString());
        string.append(" )");
        return string.toString();
    }
}

