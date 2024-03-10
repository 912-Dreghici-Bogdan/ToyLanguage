package Domain.Statement;

import Domain.*;
import Domain.Type.BoolType;
import Domain.Type.IntType;
import Domain.Type.Type;
import Domain.Value.BoolValue;
import Domain.Value.IntValue;
import Domain.Value.Value;

public class VarDeclStmt implements IStmt {
    String name;
    Type typ;

    public VarDeclStmt(String name, Type typ) {
        this.name = name;
        this.typ = typ;
    }

    public String toString() {
        return typ.toString() + " " + name;
    }

    public PrgState execute(PrgState state) throws MyException {
        //verify if the variable is already declared if true the error, otherwise add it to table and set it to default value
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        if (!symTbl.isEmpty() && symTbl.isDefined(name)) {
            throw new MyException("Variable already declared");
        } else {
            if (typ.equals(new IntType())) {
                symTbl.add(name, new IntValue(0));
            } else if (typ.equals(new BoolType())) {
                symTbl.add(name, new BoolValue(false));
            }else {
                throw new MyException("Invalid type");
            }
        }
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new VarDeclStmt(name, typ);
    }
}
