package com.kade.apecricket.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "date",
        "countryOne",
        "countryTwo"
})

@XmlRootElement(name = "match")
public class Match {

    @XmlElement(required = true)
    private String date;
    @XmlElement(required = true)
    private String countryOne;
    @XmlElement(required = true)
    private String countryTwo;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountryOne() {
        return countryOne;
    }

    public void setCountryOne(String countryOne) {
        this.countryOne = countryOne;
    }

    public String getCountryTwo() {
        return countryTwo;
    }

    public void setCountryTwo(String countryTwo) {
        this.countryTwo = countryTwo;
    }
}
