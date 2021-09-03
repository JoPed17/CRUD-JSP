

package DAO;
import MODEL.Cliente; //importa as informações da MODELCliente
import java.sql.Connection; //importa a connection
import java.sql.PreparedStatement; //são instruções sql já preparadas, é rápido pois faz operações em binário e seguro contra SQL injection

public class DAOCliente {
    private Connection conn; //declara Connection como conn
    private PreparedStatement stmt; //declara PreparedStatement como stmt
    
    //criar construtor de conexão
    public DAOCliente(){
        conn = new Conexao().getConexao();
    }
    
    //criar metodo inserir cliente
    public void inserirCliente(Cliente cliente){
        //Criar variavel para receber SQL
        String sql = "INSERT INTO tb_clientes (nome,email) VALUES (?,?)";
        
        //try e catch para verificar erros
        try{
            stmt = conn.prepareStatement(sql); //stmt vai fazer a conexao para executar sql
            stmt.setString(1, cliente.getNome()); //passar os valores do nome/email
            stmt.setString(2, cliente.getEmail());
            stmt.execute(); //executa as instruções
            stmt.close(); //fecha a conexao
            
        }catch(Exception erro){
            throw new RuntimeException ("Erro Inserir Cliente :", erro);
        }
    }
}
