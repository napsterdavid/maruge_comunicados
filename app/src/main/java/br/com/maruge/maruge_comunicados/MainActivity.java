package br.com.maruge.maruge_comunicados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button btnLogar;
    TextView txtNovoUsuario;
    TextView nomeUsuario,senhaUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogar = (Button)findViewById(R.id.btnLogar);
        txtNovoUsuario = (TextView)findViewById(R.id.txtNovoUsuario);
        nomeUsuario = (TextView) findViewById(R.id.UsuarioLogin);
        senhaUsuario = (TextView) findViewById(R.id.SenhaLogin);


        // Verificando usuarios
        btnLogar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String usuario = nomeUsuario.getText().toString();
                String senha = senhaUsuario.getText().toString();
                if ("admin".equals(usuario) && "admin".equals(senha)){
                    Intent it = new Intent(MainActivity.this, menu_adm.class);
                    startActivity(it);
                }else if("user".equals(usuario) && "user".equals(senha)){
                    Intent it = new Intent(MainActivity.this, postagens.class);
                    startActivity(it);
                }
                alert("Usuário ou Senha Incorretos");
            }
        });

        // Intente Para Novo Usuário , layout
        txtNovoUsuario.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,novo_usuario.class);
                startActivity(it);
            }

        });




    }
    private void alert(String s){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}