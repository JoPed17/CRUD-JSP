
package DAO;
import MODEL.Cliente;
import java.sql.Connection; //importa a connection
import java.sql.PreparedStatement; //são instruções sql já preparadas, é rápido pois faz operações em binário e seguro contra SQL injection

public class DAOExcluir {
     private Connection conn; //declara Connection como conn
     private PreparedStatement stmt; //declara PreparedStatement como stmt
     
      public DAOExcluir(){
        conn = new Conexao().getConexao();
}

    public void ExcluirCliente(Cliente cliente){
        String sql = "DELETE FROM tb_clientes (nome,email) VALUES (?,?)";
        
        try{
            stmt = conn.prepareStatement(sql); //stmt vai fazer a conexao para executar sql
            stmt.setString(1, cliente.getNome()); //passar os valores do nome/email
            stmt.setString(2, cliente.getEmail());
            stmt.execute(); //executa as instruções
            stmt.close(); //fecha a conexao
            
        }catch(Exception erro){
            throw new RuntimeException ("Erro EXCLUIR Cliente :", erro);
        }
    }
}
    