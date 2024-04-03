<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.calificaciones"%>
<%
    if (session.getAttribute("notas") == null) {
        ArrayList<calificaciones> calaux = new ArrayList<calificaciones>();
        session.setAttribute("notas", calaux);
    }
    ArrayList<calificaciones> cal = (ArrayList<calificaciones>) session.getAttribute("notas");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p align="center"><Strong>PRIMER PARCIAL TEM-742</Strong></p>
        <p align="center"><Strong>Nombre: </Strong>Jonathan Flores Chirinos</p>
        <p align="center"><Strong>Carnet: </Strong>10073709 LP</p>
        <h1 align="center">REGISTRO DE CALIFICACIONES</h1>
        
        <table border="1" cellspacing="0" align="center">
            <tr>
                <td><a href="MainServlet?op=nuevo">Nuevo</a></td>
            </tr>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <%
            if (cal != null) {
                for (calificaciones item:cal) {
            %>
            <tr>
                <td><%=item.getId() %></td>
                <td><%=item.getNombre() %></td>
                <td><%=item.getP1() %></td>
                <td><%=item.getP2() %></td>
                <td><%=item.getP3() %></td>
                <td><%=item.getNota() %></td>
                <td><a href="MainServlet?op=editar&id=<%=item.getId()%>">
                        Editar</a></td>
                <td><a href="MainServlet?op=eliminar&id=<%=item.getId()%>"
                       onclick="return(confirm('Esta seguro de eliminar??'))">
                       Eliminar</a></td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
