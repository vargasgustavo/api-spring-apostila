package model;
import java.sql.SQLException;
import services.BD;
public class ProdutoDAO {
	private String sql,men;
	private BD bd;
	public ProdutoDAO() {
		bd = new BD();
	}
	/**
	 * Realiza a grava��o de um produto no banco de dados
	 * @param p -  o produto a ser salvo
	 * @return - uma mensagem informando o ocorrido
	 */
	public String salvar(Produto p) {
		sql = "insert into produtos values (?,?,?,?)";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, p.getCodigo());
			bd.st.setString(2, p.getNome());
			bd.st.setDouble(3, p.getPrecoUnitario());
			bd.st.setInt(4, p.getQuantEstoque());
			bd.st.executeUpdate();
			men = "Produto "+p.getNome() + " inserido com sucesso!";
		}
		catch(SQLException erro) {
			sql = "update produtos set nome=?,preco_unitario=?,quant_estoque=? where codigo = ?";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.st.setInt(4, p.getCodigo());
				bd.st.setString(1, p.getNome());
				bd.st.setDouble(2, p.getPrecoUnitario());
				bd.st.setInt(3, p.getQuantEstoque());
				bd.st.executeUpdate();
				men = "Produto "+p.getNome() + " alterado com sucesso!";
			}
			catch(SQLException erro2) {
				men = "Falha: "+ erro.toString();
			}
		}
		finally {
			bd.close();
		}
		return men;
	}
	/**
	 * Exclui um produto a partir de seu código
	 * @param codigo - o código do produto a ser excluido
	 * @return - uma mensagem informando o ocorrido
	 */
	public String excluir(int codigo) {
		sql = "delete from produtos where codigo = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,codigo);
			if (bd.st.executeUpdate()==1) {
				men = "Produto excluido com sucesso!";
			}
			else {
				men = "Produto não encontrado!";
			}
		}
		catch(SQLException erro) {
			men = "Falha: "+ erro.toString();
		}
		finally {
			bd.close();
		}
		return men;
	}
	/**
	 * Localiza um produto a partir de seu c�digo
	 * @param codigo - o c�digo do produto a ser localizado
	 * @return - o produto na forma de um objeto ou null caso n�o encontrado
	 */
	public Produto localizar(int codigo) {
		Produto p = new Produto();
		sql = "select * from produtos where codigo = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,codigo);
			bd.rs = bd.st.executeQuery();
			if(bd.rs.next()) {
				p.setCodigo(bd.rs.getInt(1));
				p.setNome(bd.rs.getString(2));
				p.setPrecoUnitario(bd.rs.getDouble(3));
				p.setQuantEstoque(bd.rs.getInt(4));
			}
			else {
				p = null;
			}
		}
		catch(SQLException erro) {
			p = null;
		}
		finally {
			bd.close();
		}
		return p;
	}	
}
