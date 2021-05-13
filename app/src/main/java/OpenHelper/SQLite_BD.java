package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_BD extends SQLiteOpenHelper {
    public SQLite_BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(ID integer primary key autoincrement, nombre text, apellido text, correo text, contrasena text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertarRegistro(String nombre, String apellido, String correo, String contrasena){
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("apellido", apellido);
        valores.put("correo", correo);
        valores.put("contrasena", contrasena);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    public void abrirBD(){
        this.getReadableDatabase();
    }

    public void cerrarBD(){
        this.close();
    }
}
