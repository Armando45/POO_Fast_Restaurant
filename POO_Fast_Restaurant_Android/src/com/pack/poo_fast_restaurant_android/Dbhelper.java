package com.pack.poo_fast_restaurant_android;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper{
	
	private static final String NOME_BASE = "FastRestaurant";
	private static final int VERSAO_BASE = 1;
	

	public Dbhelper(Context context) {
		super(context, NOME_BASE, null, VERSAO_BASE);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sqlCreateTabelaAdmin = "CREATE TABLE Admin("+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "nome TEXT,"+ "senha TEXT"+ ")";
		db.execSQL(sqlCreateTabelaAdmin);
		
	}
	
	//String sqlCreateTabelaAdmin = "CREATE TABLE Admin("+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"+ "nome TEXT,"+ "senha TEXT,"+ ")";

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		String sqlDropTabelaAdmin = "DROP TABLE Admin";
		
		db.execSQL(sqlDropTabelaAdmin);
		
		onCreate(db);
		
	}
	
	public void insertAdmin(Admin admin){
		
		SQLiteDatabase db = getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		
		cv.put("nome", admin.getNome());
		cv.put("senha", admin.getSenha());
		
		db.insert("Admin", null, cv);
		
		db.close();
		
	}
	
	public List<Admin> selectTodosOsAdmins(){
		
		List<Admin> listAdmins = new ArrayList<Admin>();
		
		SQLiteDatabase db = getReadableDatabase();
		
		String sqlSelectTodosAdmins = "SELECT * FROM Admin";
		
		Cursor c = db.rawQuery(sqlSelectTodosAdmins, null);
		
		if(c.moveToFirst()){
			
			do{
			Admin admin = new Admin();
			admin.setId(c.getInt(0));
			admin.setNome(c.getString(1));
			admin.setSenha(c.getString(2));
			
			listAdmins.add(admin);
			}while(c.moveToNext());
		}
		
		db.close();
		return listAdmins;
	}

}
