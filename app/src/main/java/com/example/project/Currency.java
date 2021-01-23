package com.example.project;

public class Currency {
    private String country;
    private String amount;
    private String difference;
    private String iconUrl;
    private String initials;

    public String getCountry() {
        return country;
    }

    public String getAmount() {
        return amount;
    }

    public String getDifference() {
        return difference;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "country='" + country + '\'' +
                ", amount='" + amount + '\'' +
                ", difference='" + difference + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", initials='" + initials + '\'' +
                '}';
    }
}
