package Domain.Exp;

import Domain.MyException;
import Domain.MyIDictionary;
import Domain.Value.Value;

public class VarExp implements Exp {
    String id;
    public VarExp(String id){
        this.id = id;
    }
    public Value eval(MyIDictionary<String, Value> symTbl) throws MyException {
        return symTbl.lookup(id);
    }

    @Override
    public Exp deepCopy() {
        return new VarExp(id);
    }

    public String toString(){
        return id;
    }
}
