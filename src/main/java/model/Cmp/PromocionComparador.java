package model.Cmp;

import java.util.Comparator;

import model.Promocion;

public class PromocionComparador implements Comparator<Promocion> {

    @Override
    public int compare(Promocion promocionA, Promocion promocionB) {
        return (int) Math.signum(promocionB.compareTo(promocionA));
    }
}
