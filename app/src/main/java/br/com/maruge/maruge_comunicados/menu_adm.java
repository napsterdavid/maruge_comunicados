package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class menu_adm extends AppCompatActivity {
    ImageButton btnNovaPostagem,btnPostagens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);
        btnNovaPostagem = (ImageButton)findViewById(R.id.btnNovaPostagem);
        btnPostagens = (ImageButton)findViewById(R.id.btnPostagens);
        // Intente para ir para pagina de listagem das postagens
        btnPostagens.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, Postagens.class);
                startActivity(it);
            }
        });
        // Intente para criar uma nova postagem
        btnNovaPostagem.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(menu_adm.this, NovaPostagem.class);
                startActivity(it);
            }
        });
    }
}