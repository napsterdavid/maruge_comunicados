package br.com.maruge.maruge_comunicados;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import br.com.maruge.maruge_comunicados.model.Messagem;
import br.com.maruge.maruge_comunicados.model.MessagemDAO;

public class postagens extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagens);
        ListView listView = (ListView) findViewById(R.id.listView);
        MessagemDAO messagemDAO = new MessagemDAO(this);
        List<Messagem> messagems = new ArrayList<>();
        if (messagemDAO.listar()!=null){
            if (messagemDAO.listar().size()>0){
                messagems = messagemDAO.listar();
            }
        }
        ArrayAdapter<Messagem> adapter = new ArrayAdapter<Messagem>(this, android.R.layout.simple_list_item_1,messagems);
        listView.setAdapter(adapter);
    }
    /*Listando Usuarios
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postagens);
        ListView listView = (ListView) findViewById(R.id.listView);
        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
      List<Usuario> usuarios = new ArrayList<>();
        if (usuarioDAO.listar()!=null){
            if (usuarioDAO.listar().size()>0){
                usuarios = usuarioDAO.listar();
            }
        }
        ArrayAdapter<Usuario> adapter =
                new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1,
                        usuarios);
        listView.setAdapter(adapter);
    }

*/
}
