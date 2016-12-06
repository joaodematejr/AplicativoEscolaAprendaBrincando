package com.example.joaod.escolaaprendabrincando;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class CalendarioActivity extends Activity {

    ListaCalendario listaCalendario;
    ArrayAdapter<Calendario> adapterCalendario;
    ListView listViewCalendario;

    String urlServidor = "http://192.168.25.4:8080";
    String urlProjeto = "escolaAprendaBrincando";
    String chave = "eaf6c5fe009a07fb3ec3d7f33adcb932";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        listViewCalendario = (ListView) findViewById(R.id.listViewCalendario);
    }

    public void pesquisar(View v) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("user-agent","Mozilla Chorme");
        String url = "http://192.168.173.1:8080/escolaAprendaBrincando/json/listarCalendarioJson.xhtml?key=eaf6c5fe009a07fb3ec3d7f33adcb932";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(CalendarioActivity.this, "Atualizando Agenda", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
                Toast.makeText(CalendarioActivity.this, "Tentativa " + retryNo, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String s = new String(bytes);
                s = "{\"listar\":" +s+"}";
                Gson gson = new Gson();
                listaCalendario = gson.fromJson(s, ListaCalendario.class);
                adapterCalendario = new ArrayAdapter<Calendario>(CalendarioActivity.this, android.R.layout.simple_list_item_1, listaCalendario.getListar());
                listViewCalendario.setAdapter(adapterCalendario);

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(CalendarioActivity.this, "Erro", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
