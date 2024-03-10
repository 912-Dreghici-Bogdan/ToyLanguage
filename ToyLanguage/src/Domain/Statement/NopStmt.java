package Domain.Statement;

import Domain.MyException;
import Domain.PrgState;

public class NopStmt implements IStmt {
    NopStmt(){}
    public String toString(){
        return "";
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new NopStmt();
    }
}
