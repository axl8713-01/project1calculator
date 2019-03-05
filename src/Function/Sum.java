package Function;

public class Sum extends Function{

    //Fields
    private Function[] terms;
    private double total;
    //Constructor
    public Sum(Function... terms){
        this.terms = terms;
    }

    //Methods
    public double evaluate(double val){
        for (Function terms: terms){
            double total = 0;
            if (terms.isConstant()){
                this.total += terms.evaluate();
            }
            else {
                this.total += val;
            }
        }
        return total;
    }

    public Function derivative(){
        for (Function terms: terms){
            terms.derivative()
        }
    }
}
