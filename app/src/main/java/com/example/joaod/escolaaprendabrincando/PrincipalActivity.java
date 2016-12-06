package com.example.joaod.escolaaprendabrincando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class PrincipalActivity extends Activity {

    Cliente cliente;
    String urlServidor = "http://localhost:8080/escolaAprendaBrincando/json/loginJson.xhtml?key=";
    String urlProjeto = "EscolaAprendaBrincandoV2";
    EditText editEmail;
    EditText editSenha;
    String chave = "eaf6c5fe009a07fb3ec3d7f33adcb932";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
    }


    public void entrar(View v) {
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        final AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("user-agent", "Mozilla Chrome");
        client.get(urlServidor + "/" + urlProjeto + "/json/loginJson.xhtml?email=" + email + "&senha=" + senha + "&key=" + chave, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String res = new String(bytes);
                Gson gson = new Gson();
                cliente = gson.fromJson(res, Cliente.class);
                if (cliente.isStatus() == true) {
                    Toast.makeText(PrincipalActivity.this, "Logado Com Sucesso", Toast.LENGTH_LONG).show();
                    Intent it = new Intent(PrincipalActivity.this, PrincipalActivity.class);
                    startActivity(it);
                } else {
                    Toast.makeText(PrincipalActivity.this, "Falha ao logar!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(PrincipalActivity.this, "Falhou", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void abrirMenu(View v) {
        Intent it = new Intent(this, MenuActivity.class);
        Toast.makeText(PrincipalActivity.this, "Logado Com Sucesso", Toast.LENGTH_SHORT).show();
        startActivity(it);
    }

}
