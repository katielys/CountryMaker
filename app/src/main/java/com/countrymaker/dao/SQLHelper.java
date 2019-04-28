package com.countrymaker.dao;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbCountry";
    private static final int VERSAO_BANCO = 1;
    public static final String TABELA_COUNTRY = "tabelaCountry";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_capital = "capital";
    public static final String COLUNA_regiao = "regiaon";
    public static final String COLUNA_subregiao = "subregiao";


    public SQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABELA_COUNTRY + " ( " +
                        COLUNA_NOME + " TEXT, " +
                        COLUNA_capital + " TEXT, " +
                        COLUNA_regiao + " TEXT, " +
                        COLUNA_subregiao + " TEXT)"
        );

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // para as próximas versões
    }

}