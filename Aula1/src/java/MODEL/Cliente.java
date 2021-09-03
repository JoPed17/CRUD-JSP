
package MODEL; //está classe irá pegar informaçoes do index (forms) e envia para a DAO


public class Cliente {
        //criar atributos para o cliente
        private int id;     //id de cliente vai ser inteira 
        private String nome; //nome vai ser uma var string
        private String email;
        
        //agora criar métodos para o cliente usando o atalho botãodireito -> insert code -> getter and setter -> all -> gerar

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
}
