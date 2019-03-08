package functions;


/**
 *
 *
 * @author Albin Liang
 */

public class Cosine extends Function{
    //Fields
    private Function subordinate;

    //Constructor
    public Cosine (Function subordinate){
        this.subordinate = subordinate;
    }

    //Methods

    public double evaluate(double val){
        return Math.cos(subordinate.evaluate(val));
    }

    public Function derivative() {

        Product cosDerivative = new Product(new Constant(-1.0),subordinate.derivative(), new Sine(subordinate));
        return cosDerivative;
    }

    public boolean isConstant(){
        return (this.subordinate.isConstant());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("cos( ");
        string.append(subordinate.toString());
        string.append(" )");
        return string.toString();
    }
}

