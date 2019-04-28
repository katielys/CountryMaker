package com.countrymaker.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.countrymaker.Country;
import java.util.ArrayList;
import java.util.List;


public class Repositorio {

    private SQLHelper helper;
    private SQLiteDatabase db;

    public Repositorio(Context ctx){
        helper = new SQLHelper(ctx);
    }

    public long inserir(Country ubs){
        db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLHelper.COLUNA_NOME, ubs.getNome());
        cv.put(SQLHelper.COLUNA_capital, ubs.getCapital());
        cv.put(SQLHelper.COLUNA_regiao, ubs.getRegiao());
        cv.put(SQLHelper.COLUNA_subregiao, ubs.getSubregiao());



        long id = db.insert(SQLHelper.TABELA_COUNTRY, null, cv);


        db.close();
        return id;
    }

    public void excluirAll(){
        db = helper.getWritableDatabase();
        db.delete(SQLHelper.TABELA_COUNTRY, null, null);
        db.close();
    }

    public List<Country> listarUbs() {
        String sql = "SELECT * FROM " + SQLHelper.TABELA_COUNTRY;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList list = new ArrayList();

        while (cursor.moveToNext()) {

            String nome = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_NOME)
            );
            String capital = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_capital)
            );
            String regiao = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_regiao)
            );
            String subreg = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_subregiao)
            );


            Country ubs = new Country(nome, capital, regiao, subreg);
            list.add(ubs);
        }
        cursor.close();
        return list;
    }

}