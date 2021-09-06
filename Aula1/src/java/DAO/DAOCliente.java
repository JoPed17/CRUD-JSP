

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
    
    public void deletarCliente(int cod) throws Exception{
        open();
            stmt = conn.prepareStatement("delete from cliente where idCliente = ?");
            stmt.setInt(1, cod);
            stmt.execute();
            stmt.close();
        close();    
    }
    
    public void update(Cliente c) throws Exception{
        open();
            stmt = conn.prepareStatement("update cliente set nome = ? , email = ? where idCliente = ?");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.execute();
            stmt.close();
        close();   
    }
    
    public List findAll() throws Exception{
        open();
            stmt = conn.prepareStatement("select * from cliente");
            rs = stmt.execute Query();
                List lista = new ArrayList();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setidCliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEmail(rs.getString(3));
                lista.add(cliente);
            }    
            stmt.close();
         close();
         return lista;
    }
    
     public Cliente findByCode(int cod) throws Exception{
         open();
            stmt = conn.prepareStatement("select * from Cliente where idCliente = ?");
            stmt.setInt(1, cod);
            rs = stmt.executeQuery();
                Cliente cliente = null;
            if(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setEmail(rs.getString(3));
            }    
            stmt.close();
         close();
         return cliente;
     }
}
