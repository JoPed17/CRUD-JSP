
package DAO;
import MODEL.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOAtualizar {
    private Connection conn; //declara Connection como conn
    private PreparedStatement stmt; //declara PreparedStatement como stmt
    
    //criar construtor de conexão
    public DAOAtualizar(){
        conn = new Conexao().getConexao();
    }
    
    //criar metodo inserir cliente
    public void AtualizarCliente(Cliente cliente){
        //Criar variavel para receber SQL
        String sql = "UPDATE INTO tb_clientes (nome,email) VALUES (?,?)";
        
        //try e catch para verificar erros
        try{
            stmt = conn.prepareStatement(sql); //stmt vai fazer a conexao para executar sql
            stmt.setString(1, cliente.getNome()); //passar os valores do nome/email
            stmt.setString(2, cliente.getEmail());
            stmt.execute(); //executa as instruções
            stmt.close(); //fecha a conexao
            
        }catch(Exception erro){
            throw new RuntimeException ("Erro Atualizar Cliente :", erro);
        }
    }
}

