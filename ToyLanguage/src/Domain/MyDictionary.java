package Domain;

import Domain.Value.Value;

import java.util.Enumeration;

public class MyDictionary<T,T1> implements MyIDictionary<T,T1>{
    private java.util.Dictionary<T,T1> dict;
    public MyDictionary(){
        dict=new java.util.Hashtable<T,T1>();
    }
    @Override
    public int size() {
        return dict.size();
    }
    @Override
    public boolean isEmpty() {
        if (dict.isEmpty())
            return true;
        return false;
    }
    @Override
    public boolean isDefined(T id) {
        return dict.get(id) != null;
    }
    @Override
    public Value lookup(T id) {
        return (Value) dict.get(id);
    }
    @Override
    public void update(T id, T1 val) {
        dict.put(id,val);
    }
    @Override
    public void add(T name, T1 val) {
        dict.put(name,val);
    }
    @Override
    public String toString(){
        String s="";
        Enumeration<T> e = dict.keys();
        while (e.hasMoreElements()) {
            T key = e.nextElement();
            s+=key.toString()+"->"+dict.get(key).toString()+"\n";
        }
        return s;
    }
}