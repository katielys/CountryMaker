package com.countrymaker;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Country implements  Serializable {

    @SerializedName("name")
    private String nome;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String regiao;
    @SerializedName("subregion")
    private String subregiao;
    @SerializedName("callingCodes")
    private String codarea;
    @SerializedName("latlng")
    private String latLong;

    public Country( String nome, String capital, String regiao, String subregiao, String codarea, String latLong) {

        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
        this.subregiao = subregiao;
        this.codarea = codarea;
        this.latLong = latLong;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subregiao='" + subregiao + '\'' +
                ", codarea='" + codarea + '\'' +
                '}';
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubregiao() {
        return subregiao;
    }

    public void setSubregiao(String subregiao) {
        this.subregiao = subregiao;
    }

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }
}
