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



    public Country( String nome, String capital, String regiao, String subregiao) {
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
        this.subregiao = subregiao;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subregiao='" + subregiao + '\'' +
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




}
