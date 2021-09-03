<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.Cliente"%>

<%
    
    Cliente cli = new Cliente();
    DAOCliente cld = new DAOCliente();
    
    try{
        //pega o valor do formulario no navegador
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        //condicao para verificar se valores sao nulos
        if(nome.equals(null) || email.equals(null)){
            
        }else{
            cli.setNome(nome);
            cli.setEmail(email);
            cld.inserirCliente(cli);
            response.sendRedirect("index.jsp");
        }
    }












%>