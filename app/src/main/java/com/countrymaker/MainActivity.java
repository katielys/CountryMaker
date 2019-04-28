package com.countrymaker;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.countrymaker.util.Adapter;
import com.countrymaker.util.HttpRetro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private Adapter adapter;
    private List<Country> ubsList;
    private ListView listView;
    private SwipeRefreshLayout swiperefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swiperefresh =  findViewById((R.id.swiperefresh));
        //seta cores
        swiperefresh.setColorScheme(R.color.colorPrimary, R.color.colorAccent);
        swiperefresh.setOnRefreshListener(this);

        listView =  findViewById(R.id.listView);
        ubsList = new ArrayList<>();
        adapter = new Adapter(this, ubsList);
        getDataRetro();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), ubsList.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getData() {
        String[] nomes = {"UBS LUIZ MONTENEGRO", "UBS AJURICABA", "UBS REDENÇÃO", "UBS SANTOS DUMONT"};
        String[] bairros = {"CHAPADA", "LÍRIO DO VALE", "COMPENSA", "PLANALTO"};
        ubsList.clear();
        for (int i=0; i<20; i++){
            int nextInt = new Random().nextInt(4);
            Country ubs = new Country("", nomes[nextInt], "",  bairros[nextInt]);
            ubsList.add(ubs);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        getDataRetro();
    }

    private void getDataRetro(){
        HttpRetro.getCountryClient().getCountry().enqueue(new Callback<List<Country>>() {
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    List<Country> cBody = response.body();
                    ubsList.clear();
                    ubsList.addAll(cBody);
                    adapter.notifyDataSetChanged();
                } else {
                    System.out.println(response.errorBody());
                }
                swiperefresh.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public class CountryTask extends AsyncTask<String, Void, List<String>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            swiperefresh.setRefreshing(true);
        }
        @Override
        protected List<String> doInBackground(String... strings) {
            // ex.: Buscar na internet
            return null;
        }
        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            // ex.: Processamento dos dados vindos do Servidor
        }
    }

}