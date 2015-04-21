package com.pack.poo_fast_restaurant_android;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UsuarioDAO {

	public boolean inserirUsuario(Usuario usuario){
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?)";
			java.sql.PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, usuario.getCpf());
			ppStm.setInt(2, usuario.getSenha());
			ppStm.setString(3, usuario.getNome());
			ppStm.setInt(4, usuario.getIdade());
			ppStm.setInt(5, usuario.getTelefone());
			
			ppStm.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	public boolean atualizarUsuario(Usuario usuario){
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "UPDATE usuario SET senha = ?, nome = ?, idade = ?, telefone = ? WHERE cpf = ?";
			java.sql.PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, usuario.getSenha());
			ppStm.setString(2, usuario.getNome());
			ppStm.setInt(3, usuario.getIdade());
			ppStm.setInt(4, usuario.getTelefone());
			ppStm.setInt(5, usuario.getCpf());
			
			
			ppStm.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	//Excluir usuario pelo objeto
	public boolean excluirUsuario(Usuario usuario){
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "DELETE FROM usuario WHERE cpf = ?";
			java.sql.PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ppStm.setInt(1, usuario.getCpf());
			//ppStm.setInt(2, usuario.getSenha());

			ppStm.executeUpdate();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	//Excluir usuario apartir do CPF.
	public boolean excluirUsuario(int cpf){
		//O return abaixo faz chama o metodo excluir usuário
		return excluirUsuario(new Usuario(cpf, 0, "", 0, 0));
	}
	
	
	
	//Faz a busca e listagem de todos os usuarios.
	public ArrayList<Usuario> buscarTodosUsuarios(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "SELECT * FROM usuario";
			java.sql.PreparedStatement ppStm = conn.prepareStatement(queryInserir);
			
			ResultSet rSet = ppStm.executeQuery();
			
			while (rSet.next()){
				Usuario usr = new Usuario();
				
				usr.setCpf(rSet.getInt(1));
				usr.setSenha(rSet.getInt(2));
				usr.setNome(rSet.getString(3));
				usr.setIdade(rSet.getInt(4));
				usr.setTelefone(rSet.getInt(5));
				
				lista.add(usr);
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	//Realiza a busca por apenas um usuario a partir do CPF.
	public Usuario buscarUsuarioPorCPF(int cpf){
		Usuario usr = null;
		
		try {
			Connection conn = ConectaMySql.obtemConexao();
			String queryInserir = "SELECT * FROM usuario WHERE cpf = ?";
			java.sql.PreparedStatement ppStm = conn.prepareStatement(queryInserir);

			ppStm.setInt(1, cpf);
			
			ResultSet rSet = ppStm.executeQuery();
			
			if (rSet.next()){
				usr = new Usuario();
				
				usr.setCpf(rSet.getInt(1));
				usr.setSenha(rSet.getInt(2));
				usr.setNome(rSet.getString(3));
				usr.setIdade(rSet.getInt(4));
				usr.setTelefone(rSet.getInt(5));
			}
			
			else {
				return usr;
			}
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		return usr;
	}
	
	
}
