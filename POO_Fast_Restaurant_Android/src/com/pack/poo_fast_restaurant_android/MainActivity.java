package com.pack.poo_fast_restaurant_android;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	DbHelper dbHelper = new DbHelper(this);	
	
	//Admin admin1 = new Admin(0,"admin1","senha1");
	//dbHelper.insertAdmin(admin1);
	//dbHelper.insertAdmin(new Admin(0,"admin2","senha2"));
	
	List<Admin> listaAdmins = dbHelper.selectTodosOsAdmins();
	
	for (Iterator<Admin> iterator = listaAdmins.iterator(); iterator.hasNext();) {
		Admin admin = (Admin) iterator.next();
		
		Log.i("AppFastRestaurant", admin.toString());
		
	}
	
	}
}

