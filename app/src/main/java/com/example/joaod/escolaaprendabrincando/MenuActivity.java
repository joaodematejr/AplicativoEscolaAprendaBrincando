package com.example.joaod.escolaaprendabrincando;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void encerrar(View v) {
        Toast.makeText(this, "Encerrando a Aplicação", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void abrirTurma(View v) {
        Toast.makeText(this, "Em Desenvolvimento", Toast.LENGTH_SHORT).show();
    }

    public void abrirUpload(View v) {
        Toast.makeText(this, "Em Desenvolvimento", Toast.LENGTH_SHORT).show();
    }

    public void abrirPesquisa(View v) {
        Toast.makeText(this, "Em Desenvolvimento", Toast.LENGTH_SHORT).show();
    }

    public void abrirConfiguracao(View v) {
        Toast.makeText(this, "Em Desenvolvimento", Toast.LENGTH_SHORT).show();
    }

    public void abrirAgenda(View v) {
        Intent it = new Intent(this, CalendarioActivity.class);
        Toast.makeText(MenuActivity.this, "Carregando Agenda", Toast.LENGTH_SHORT).show();
        startActivity(it);
    }
}
