package Controller;

import Domain.Statement.IStmt;
import Domain.MyException;
import Domain.MyIStack;
import Domain.PrgState;
import Repo.RepoInterface;

public class Controller {
    RepoInterface repo;
    PrgState oneStep(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        if (stk.isEmpty())
            throw new MyException("program state stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    public void allStep() throws MyException {
        PrgState prg = repo.getCrtPrg();
        System.out.println(prg);
        while (!prg.getStk().isEmpty()) {
            oneStep(prg);
            System.out.println(prg);
        }
        //print everything from out
        System.out.println(prg.getOut());
    }
    public Controller(RepoInterface r) {
        repo = r;
    }
    public void display() {
        System.out.println(repo.getCrtPrg());
    }
}
