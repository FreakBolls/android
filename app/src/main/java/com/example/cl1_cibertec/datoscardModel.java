package com.example.cl1_cibertec;

public class datoscardModel {

    private String userNameCard;
    private int pictureCard;
    private int numero_me_gusta;

    public datoscardModel(String userNameCard, int pictureCard, int numero_me_gusta) {
        this.userNameCard = userNameCard;
        this.pictureCard = pictureCard;
        this.numero_me_gusta = numero_me_gusta;
    }

    public String getUserNameCard() {
        return userNameCard;
    }

    public void setUserNameCard(String userNameCard) {
        this.userNameCard = userNameCard;
    }

    public int getPictureCard() {
        return pictureCard;
    }

    public void setPictureCard(int pictureCard) {
        this.pictureCard = pictureCard;
    }

    public int getNumero_me_gusta() {
        return numero_me_gusta;
    }

    public void setNumero_me_gusta(int numero_me_gusta) {
        this.numero_me_gusta = numero_me_gusta;
    }

}
