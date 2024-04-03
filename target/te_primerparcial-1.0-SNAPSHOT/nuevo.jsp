<%@page import="com.emergentes.modelo.calificaciones"%>
<%
    calificaciones nc = (calificaciones)request.getAttribute("obj");
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
        <h1 align="center">NUEVO REGISTRO</h1>
        <form action="MainServlet?id=<%=nc.getId()%>" method="post">
            <table align="center">
                <tr>
                    <td align="right">Nombre del estudiante:</td>
                    <td><input type="text" name="nombre" value="<%= nc.getNombre() %>"></td>
                </tr>
                <tr>
                    <td align="right">Primer Parcial (sobre 30 pts):</td>
                    <td><input type="text" name="primer" value="<%= nc.getP1() %>"></td>
                </tr>
                <tr>
                    <td align="right">Segundo Parcial (sobre 30 pts):</td>
                    <td><input type="text" name="segundo" value="<%= nc.getP2() %>"></td>
                </tr>
                <tr>
                    <td align="right">Examen Final (Sobre 40 pts):</td>
                    <td><input type="text" name="tercer" value="<%= nc.getP3() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
