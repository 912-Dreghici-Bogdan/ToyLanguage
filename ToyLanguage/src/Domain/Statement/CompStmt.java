package Domain.Statement;

import Domain.MyException;
import Domain.MyIStack;
import Domain.PrgState;

public class CompStmt implements IStmt {
    IStmt first;
    IStmt snd;
    public CompStmt(IStmt first,IStmt snd){
        this.first=first;
        this.snd=snd;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk=state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new CompStmt(first.deepCopy(),snd.deepCopy());
    }

    public String toString(){
        return "("+first.toString()+";"+snd.toString()+")";
    }
}
