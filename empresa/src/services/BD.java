package services;
import java.sql.*;
public class BD{
	public Connection con = null;
	public ResultSet rs = null;
	public PreparedStatement st = null;
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DATABASENAME = "empresa";
	private final String URL   = "jdbc:mysql://localhost:3306/"+DATABASENAME+"?useTimezone=true&serverTimezone=UTC";;
	private final String LOGIN = "root";
	private final String SENHA = "1234";

	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		bd.close();
	}
	/** 
	 * metodo que faz conexao com o banco de dados
	 * retorna true se houve sucesso, ou false em caso negativo
	 */
	public boolean getConnection(){
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			System.out.println("Conectou");
			return true;
		}
		catch(ClassNotFoundException erro){
			System.out.println(erro.toString());
			return false;
		}
		catch(SQLException erro){
				System.out.println(erro.toString());	
			return false;
		}
	}

	public void close(){
		try{
           if(rs!=null)
              rs.close();
		}
		catch(SQLException erro){}
		try{
           if(st!=null)
			  st.close();
		}
		catch(SQLException erro){} 
		try{
			con.close();
			System.out.println("Desconectou");
		}
		catch(SQLException erro){
			System.out.println(erro.toString());
		} 
	}  
}
