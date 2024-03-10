package View;

import Domain.*;
import Domain.Exp.ArithExp;
import Domain.Exp.ValueExp;
import Domain.Exp.VarExp;
import Domain.Statement.*;
import Domain.Type.BoolType;
import Domain.Type.IntType;
import Domain.Value.BoolValue;
import Domain.Value.IntValue;
import Repo.*;
import Controller.*;

import java.util.Scanner;

public class View {
    static public void main(String[] args) throws MyException {
        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));
        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp('+', new ValueExp(new IntValue(2)),
                                new ArithExp('*', new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b", new ArithExp('+', new VarExp("a"),
                                        new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()), new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                        new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new IntValue(2))),
                                new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
        IStmt ex;
        Scanner scn = new Scanner(System.in);
        while (true) {
                while (true) {
                    System.out.println("1. Example 1");
                    System.out.println("2. Example 2");
                    System.out.println("3. Example 3");
                    System.out.println("0. Exit");
                    System.out.print("Input: ");
                    String input = scn.nextLine();
                    if (input.equals("1")) {
                        ex = ex1;
                        break;
                    } else if (input.equals("2")) {
                        ex = ex2;
                        break;
                    } else if (input.equals("3")) {
                        ex = ex3;
                        break;
                    } else if (input.equals("0")) {
                        return;
                    } else {
                        System.out.println("Invalid input");
                    }
                }
                PrgState prg1 = new PrgState(ex);
                Repository repo1 = new Repository(prg1);
                Controller ctrl1 = new Controller(repo1);
                try {
                    ctrl1.allStep();
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
}