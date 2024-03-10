package Domain;

import Domain.Statement.IStmt;
import Domain.Value.Value;

public class PrgState {
    MyIStack<IStmt> stk;
    MyIDictionary<String, Value> symTbl;
    MyIList<Value> out;
    IStmt originalProgram;
    public PrgState(IStmt prg){
        stk= new MyStack<>();
        symTbl= new MyDictionary<>();
        out= new MyList<>();
        originalProgram=prg.deepCopy();
        stk.push(prg);
    }
    PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symTbl, MyIList<Value> out, IStmt prg){
        this.stk=stk;
        this.symTbl=symTbl;
        this.out=out;
        this.originalProgram=prg.deepCopy();
        stk.push(prg);
    }
    public IStmt get_originalProgram(){
        return originalProgram;
    }

    public MyIStack<IStmt> getStk() {
        return stk;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTbl;
    }

    public MyIList<Value> getOut() {
        return out;
    }
    public void setStk(MyIStack<IStmt> stk){
        this.stk=stk;
    }
    public void setSymTable(MyIDictionary<String, Value> symTbl){
        this.symTbl=symTbl;
    }
    public void setOut(MyIList<Value> out){
        this.out=out;
    }
    @Override
    public String toString(){
        return "ExeStack:\n"+stk.toString()+"\nSymTable:\n"+symTbl.toString()+"\nOut:\n"+out.toString()+"\n";
    }
}
