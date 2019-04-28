package com.countrymaker;
import java.io.Serializable;
public class Country implements  Serializable {
    private String id;
    private String nome;
    private String capital;
    private String regiao;
    private String subregiao;
    private String codarea;

    public Country(String id, String nome, String capital, String regiao, String subregiao, String codarea) {
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.regiao = regiao;
        this.subregiao = subregiao;
        this.codarea = codarea;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subregiao='" + subregiao + '\'' +
                ", codarea='" + codarea + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
