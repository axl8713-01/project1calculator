package functions;

import java.util.ArrayList;

public class Sum extends Function{

    //Fields
    private Function[] terms;
    private double total;

    //Constructor
    public Sum(Function... terms){
        double totalConstant = 0.0;
        ArrayList<Function> nonConstants = new ArrayList<>();
        for (Function term : terms) {
            if (term.isConstant()) {
                totalConstant += term.evaluate(0.0);
            } else {
                nonConstants.add(term);
            }
        }
        Function total = new Constant(totalConstant);
        nonConstants.add(total);
        this.terms = new Function[nonConstants.size()];
        this.terms = nonConstants.toArray(this.terms);

    }

    //Methods
    public double evaluate(double val){
        for (Function terms: terms){
            if (terms.isConstant()){
                this.total += terms.evaluate(0.0);
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

//    public Function intergral(){}

    public boolean isConstant(){
       for (Function term : this.terms) {
           if (!term.isConstant()) {
               return false;
           }
       }
       return true;
    }

    @Override
    public String toString(){
        String ret = "( ";
        for (Function term: terms){
            ret += term.toString() + " + ";
        }
        return ret + " )";
    }

}
