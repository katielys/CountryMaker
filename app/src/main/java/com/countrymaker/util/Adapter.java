package com.countrymaker.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.countrymaker.Country;
import com.countrymaker.R;

import java.util.List;

public class Adapter extends ArrayAdapter<Country> {
    public Adapter(Context context, List<Country> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Country country = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);
        }
        TextView tvNome = (TextView) convertView.findViewById(R.id.tvNome);
        TextView tvCapital = (TextView) convertView.findViewById(R.id.tvCapital);
        tvNome.setText(country.getNome());
        tvCapital.setText(country.getCapital());
        return convertView;
    }
}