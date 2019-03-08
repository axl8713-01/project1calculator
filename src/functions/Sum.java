package functions;

import java.util.ArrayList;

public class Sum extends Function{

    //Fields
    private Function[] terms;
    private double total;

    //Constructor
    public Sum(Function... terms) {
        double totalConstant = 0.0;
        ArrayList<Function> nonConstants = new ArrayList<>();
        for (Function term : terms) {
            if (term.isConstant()) {
                totalConstant += term.evaluate(0.0);
            } else {
                nonConstants.add(term);
            }
        }
        if (totalConstant == 0.0) {
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
        else {
            Function total = new Constant(totalConstant);
            nonConstants.add(total);
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
    }
    //Methods
    public double evaluate(double val){
        this.total=0;
        for (Function term: terms){
            if (term.isConstant()){
                this.total += term.evaluate(0.0);
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
    public String toString() {
        if (terms.length > 1) {
            StringBuilder string = new StringBuilder("( ");
            for (int i = 0; i < terms.length; i++)
                if (i != terms.length - 1) {
                    string.append(terms[i].toString());
                    string.append(" + ");
                } else {
                    string.append(terms[i].toString());
                }
            string.append(" )");
            return string.toString();
        }
        else {
            return terms[0].toString();
        }
    }

}
