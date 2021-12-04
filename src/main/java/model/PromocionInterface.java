package model;

public interface PromocionInterface extends Comparable<PromocionInterface> {
    Object retornarPromocion();
    Atraccion getAtraccionA();
    Atraccion getAtraccionB();
}
