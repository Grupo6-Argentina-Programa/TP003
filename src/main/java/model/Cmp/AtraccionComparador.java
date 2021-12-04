package model.Cmp;

import java.util.Comparator;

import model.Atraccion;

public class AtraccionComparador implements Comparator<Atraccion> {

    @Override
    public int compare(Atraccion atraccionA, Atraccion atraccionB) {
        return (int) Math.signum(atraccionB.compareTo(atraccionA));
    }
}
