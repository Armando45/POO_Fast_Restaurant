package com.pack.poo_fast_restaurant_android;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MostraTodososAdmins extends Activity {
	
	
	private ListView LvMostratodososAdmins;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_listagem_admin);
		
		Button btAbreCadastro = (Button) findViewById(R.id.btAbreCadastro);
		LvMostratodososAdmins = (ListView) findViewById(R.id.LvMostratodososAdmins);
		
		btAbreCadastro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MostraTodososAdmins.this, CadastroAdmin.class);
				
				startActivity(it);
				
			}
		});		
				
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		DbHelper dbHelper = new DbHelper(this);
		List<Admin> listaAdmin = dbHelper.selectTodosOsAdmins();
		
		ArrayAdapter<Admin> adp = new ArrayAdapter<Admin>(this, android.R.layout.simple_list_item_1, listaAdmin);
		
		LvMostratodososAdmins.setAdapter(adp);
		
	}

}
