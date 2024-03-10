package Domain.Exp;

import Domain.MyException;
import Domain.MyIDictionary;
import Domain.Value.Value;

public interface Exp {
    Value eval(MyIDictionary<String, Value> symTbl) throws MyException;

    Exp deepCopy();
}
