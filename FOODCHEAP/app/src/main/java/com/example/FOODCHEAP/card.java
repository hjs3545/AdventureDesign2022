package com.example.FOODCHEAP;

public class card {
    private int id;
    private String CardName;
    private String CardNumber;
    private String ValidThru;
    private int CVC;

    card(int id, String CardName, String CardNumber, String ValidThru, int CVC) {
        this.id = id;
        this.CardName = CardName;
        this.CardNumber = CardNumber;
        this.ValidThru = ValidThru;
        this.CVC = CVC;
    }

    public int getID() {
        return id;
    }

    public String getCardName() {
        return CardName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getValidThru() {
        return ValidThru;
    }

    public int getCVC() {
        return CVC;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setCardName(String CardName) {
        this.CardName = CardName;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public void setValidThru(String ValidThru) {
        this.ValidThru = ValidThru;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }
}
