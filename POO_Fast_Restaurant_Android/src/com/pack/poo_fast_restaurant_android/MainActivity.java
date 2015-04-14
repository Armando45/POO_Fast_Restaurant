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
		
	Dbhelper dbhelper = new Dbhelper(this);
		
	Admin admin1 = new Admin(0,"admin1","senha1");
	
	dbhelper.insertAdmin(admin1);
	dbhelper.insertAdmin(new Admin(0,"admin2","senha2"));
	
	List<Admin> listaAdmins = dbhelper.selectTodosOsAdmins();
	
	for (Iterator<Admin> iterator = listaAdmins.iterator(); iterator.hasNext();) {
		Admin admin = (Admin) iterator.next();
		
		Log.i("AppFastRestaurant", admin.toString());
		
	}
	
	}
}

