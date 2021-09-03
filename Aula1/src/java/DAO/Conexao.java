
package DAO; //vai fazer conexão com o banco de dados
import java.sql.Connection; //biblioteca  para usar recursos de conexão
import java.sql.DriverManager; //biblioteca para Drivers do banco de dados


public class Conexao {
    public Connection getConexao(){
        
        try{ //verica se existe algum erro de conexao, caso tenha envia para o catch
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //aponta onde estão os driver
            return DriverManager.getConnection("jdbc:derby://localhost/bdTreino", "joao", "123"); //aponta o bd e seu nome e senha
        
        }catch(Exception erro){
            throw new RuntimeException("Erro conexão: ", erro); //exibe o erro, caso houver
        }
    }
}
