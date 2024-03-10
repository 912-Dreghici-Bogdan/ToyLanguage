package Domain.Exp;

import Domain.*;
import Domain.Type.BoolType;
import Domain.Value.BoolValue;
import Domain.Value.Value;

public class LogicExp implements Exp {
    Exp e1;
    Exp e2;
    int op; // 1 - and, 2 - or
    LogicExp(Exp e1,Exp e2,int op){
        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        Value v1,v2;
        v1= e1.eval(tbl);
        if(v1.getType().equals(new BoolType())){
            v2=e2.eval(tbl);
            if(v2.getType().equals(new BoolType())){
                BoolValue i1=(BoolValue)v1;
                BoolValue i2=(BoolValue)v2;
                boolean n1,n2;
                n1=i1.getVal();
                n2=i2.getVal();
                if(op==1) return new BoolValue(n1 && n2);
                if(op==2) return new BoolValue(n1 || n2);
            }
            else throw new MyException("second operand is not a boolean");
        }
        else throw new MyException("first operand is not a boolean");
        return new BoolValue(false);
    }

    @Override
    public Exp deepCopy() {
        return new LogicExp(e1.deepCopy(),e2.deepCopy(),op);
    }
}
