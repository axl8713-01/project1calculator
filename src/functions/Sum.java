package functions;

import java.util.ArrayList;

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
        Function[] derivatives = new Function[terms.length];
        for (int i=0; i<terms.length; i++){
            derivatives[i] = terms[i].derivative();
        }
        return new Sum(derivatives);
    }

    public boolean isConstant(){
        return false;
    }


}
