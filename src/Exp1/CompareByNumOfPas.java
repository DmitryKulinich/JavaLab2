package Exp1;

import java.util.Comparator;

/**
 * Created by dmitry on 9/19/17.
 */

public class CompareByNumOfPas implements Comparator<hour> {
    public int compare(hour h1, hour h2){
        return Integer.compare(h2.getNumberOfPassenger(),h1.getNumberOfPassenger());
    }
}
