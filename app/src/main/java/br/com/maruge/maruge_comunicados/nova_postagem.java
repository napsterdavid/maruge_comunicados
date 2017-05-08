package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class nova_postagem extends AppCompatActivity {


    private static final String TAG = "aula_sq";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_postagem);
        final EditText titulo = (EditText) findViewById(R.id.EdtTitulo);
        final EditText msg = (EditText)findViewById(R.id.editMessagem);
        Button btnListar = (Button) findViewById(R.id.btnListar);
        Button btnSalvarMessagem = (Button) findViewById(R.id.btnSalvarMessagem);

        btnSalvarMessagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessagemDAO messagemDAO = new MessagemDAO(nova_postagem.this);
                Messagem messagem = new Messagem();

                messagem.setTitulo(titulo.getText().toString());
                messagem.setMsg(msg.getText().toString());
                messagemDAO.salvar(messagem);
                titulo.setText("");
                msg.setText("");
                Toast.makeText(nova_postagem.this, "Comunicado Salvo com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Lista todas as postagem existentes
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nova_postagem.this, postagens.class);
                startActivity(intent);
            }
        });
    }
}
