package com.pack.poo_fast_restaurant_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CadastroAdmin extends Activity implements OnClickListener{
	
	EditText etnome; 
	EditText etsenha; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cadastro_admin);
		
		etnome = (EditText) findViewById(R.id.etnome);
		etsenha = (EditText) findViewById(R.id.etsenha);
		
		Button btGeraCadastro = (Button) findViewById(R.id.btGeraCadastro);
		
		btGeraCadastro.setOnClickListener(this);
		
		
	
	}

	@Override
	public void onClick(View v) {
		
Admin admin = new Admin();
		
		admin.setNome(etnome.getText().toString());
		admin.setSenha(etsenha.getText().toString());

		DbHelper dbHelper = new DbHelper(this);
		dbHelper.insertAdmin(admin);
		
		finish();
		
		
	}

}
