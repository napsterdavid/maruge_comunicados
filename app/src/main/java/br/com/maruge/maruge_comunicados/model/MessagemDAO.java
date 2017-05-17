package br.com.maruge.maruge_comunicados.model;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class MessagemDAO extends MessagemGenericDAO<Messagem> {
    private SQLiteDatabase database;
    public MessagemDAO(Context context){
        super(context);
        database = getWritableDatabase();
    }
    @Override
    public boolean salvar( Messagem messagem) {
        database.execSQL("INSERT INTO messagens(titulo, msg) " +
                "VALUES ('"+messagem.getTitulo()+"'," +
                "'"+messagem.getMsg()+"')");
        return false;
    }

    @Override
    public List<Messagem> listar() {
        List<Messagem> messagems = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM messagens", null);
        cursor.moveToFirst();
        int indiceColunaId = cursor.getColumnIndex("idmessagem");
        int indiceColunaTitulo = cursor.getColumnIndex("titulo");
        int indiceColunaMsg = cursor.getColumnIndex("msg");
        do{
            Messagem messagem = new Messagem();
            messagem.setId(cursor.getInt(indiceColunaId));
            messagem.setTitulo(cursor.getString(indiceColunaTitulo));
            messagem.setMsg(cursor.getString(indiceColunaMsg));
            messagems.add(messagem);
        } while(cursor.moveToNext());
        return messagems;
    }
    @Override
    public boolean deletar(int id) {
        database.execSQL("DELETE FROM messagens WHERE idmessagem="+id);
        return false;
    }
}