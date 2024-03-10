package Repo;

import Domain.PrgState;
import java.util.ArrayList;

public class Repository implements RepoInterface {

    ArrayList<PrgState> programstates;
    int currentpos=0;

    public Repository(PrgState prg) {
        programstates = new ArrayList<PrgState>();
        programstates.add(prg);
    }

    public PrgState getCrtPrg() {
        return programstates.get(currentpos);
    }
}
