package functions;

import java.util.ArrayList;
import java.util.Arrays;


public class Product extends Function{

    //Fields
    private Function[] terms;
    private double product;


    //Constructor
    public Product(Function... terms){
        double totalCoefficient = 1.0;
        ArrayList<Function> nonConstants = new ArrayList<>();
        for (Function term : terms) {
            if (term.isConstant()) {
                totalCoefficient = term.evaluate(0.0)*totalCoefficient;
            }
            else {
                nonConstants.add(term);
            }
        }
        Function coefficient = new Constant(totalCoefficient);
        if (coefficient.evaluate(0.0)==1) {
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
        else if (coefficient.evaluate(0.0)==0){
                Function[] zero = new Function[1];
                zero[0] = new Constant(0);
                this.terms = zero;
            }
        else{
            nonConstants.add(coefficient);
            this.terms = new Function[nonConstants.size()];
            this.terms = nonConstants.toArray(this.terms);
        }
    }

    //Methods

    public double evaluate(double val){
        this.product=1;
        for (Function term: terms){
            if (term.isConstant()){
                this.product = term.evaluate(0.0) * this.product;
            }
            else {
                this.product = this.product * val;
            }
        }
        return product;
    }

    public Function derivative(){
        if (terms.length > 1){
        Function[] firstTerm = Arrays.copyOfRange(terms,0,1);
        Function[] rest = Arrays.copyOfRange(terms,1,terms.length);
        Product restTerm = new Product(rest);
        Product restTermDerivatives = new Product(restTerm.derivative());
        Product firstHalf = new Product(firstTerm[0].derivative(), restTerm);
        Product secondHalf = new Product(firstTerm[0], restTermDerivatives);
        return new Sum(firstHalf,secondHalf);
        }
        else {
            return terms[0].derivative();
        }
    }

//    public double integral(double a, double b, int num){return 0;}

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
                    string.append(" * ");
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



