package Function;

abstract class Function{

    private boolean isConstant;

    public Function(boolean isConstant){
           this.isConstant = isConstant;
    }

    abstract double evaluate();
//    public String toString();
    private void derivative(){

    }
//    public abstract double intergral();
     private boolean isConstant(){
        return this.isConstant;
     }
}
