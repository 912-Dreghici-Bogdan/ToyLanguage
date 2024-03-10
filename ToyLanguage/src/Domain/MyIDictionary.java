package Domain;

import Domain.Value.Value;

public interface MyIDictionary<T, T1> {

    boolean isDefined(T id);

    Value lookup(T id);

    void update(T id, T1 val);

    void add(T name, T1 val);

    int size();

    boolean isEmpty();
}
