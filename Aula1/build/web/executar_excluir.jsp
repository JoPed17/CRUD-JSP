<%@page import="DAO.DAOExcluir"%>
<%@page import="MODEL.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cliente cli = new Cliente();
    DAOExcluir cld = new DAOExcluir();
    
    try{
        //pega o valor do formulario no navegador
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        //condicao para verificar se valores sao nulos
        if(nome.equals(null) || email.equals(null)){
            
        }else{
            cli.setNome(nome);
            cli.setEmail(email);
            cld.ExcluirCliente(cli);
            response.sendRedirect("index.jsp");
        }
    }catch (Exception erro){
        throw new RuntimeException("Erro  executar excluir : ", erro);
    }


%>