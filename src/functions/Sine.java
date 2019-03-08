package functions;



/**
 *
 *
 * @author Albin Liang
 */

public class Sine extends Function {

    //Fields
    private Function subordinate;

    //Constructor
    public Sine (Function subordinate){
        this.subordinate = subordinate;
    }

    //Methods

    public double evaluate(double val){
        return Math.sin(subordinate.evaluate(val));
    }

    public Function derivative() {
        Product sinDerivative = new Product(subordinate.derivative(), new Cosine(subordinate));
        return sinDerivative;
    }

    public boolean isConstant(){
        return (this.subordinate.isConstant());
    }

    @Override
    public String toString() {
            StringBuilder string = new StringBuilder("sin( ");
            string.append(subordinate.toString());
            string.append(" )");
            return string.toString();
    }
}
