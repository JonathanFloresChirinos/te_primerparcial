package com.emergentes.controlador;

import com.emergentes.modelo.calificaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        calificaciones nc = new calificaciones();
        int id,pos;
        
        HttpSession ses = request.getSession();
        ArrayList<calificaciones> cal = (ArrayList<calificaciones>) ses.getAttribute("notas");
        switch (op) {
            case "nuevo":
                request.setAttribute("obj", nc);
                request.getRequestDispatcher("nuevo.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                nc = cal.get(pos);
                request.setAttribute("obj", nc);
                request.getRequestDispatcher("nuevo.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if (pos >= 0) {
                    cal.remove(pos);
                }
                request.setAttribute("notas", cal);
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int primer = Integer.parseInt(request.getParameter("primer"));
        int segundo = Integer.parseInt(request.getParameter("segundo"));
        int tercer = Integer.parseInt(request.getParameter("tercer"));
        int nota = primer + segundo + tercer;
        HttpSession ses = request.getSession();
        ArrayList<calificaciones> cal = (ArrayList<calificaciones>) ses.getAttribute("notas");
        calificaciones nc = new calificaciones();
        nc.setId(id);
        nc.setNombre(request.getParameter("nombre"));
        nc.setP1(primer);
        nc.setP2(segundo);
        nc.setP3(tercer);
        nc.setNota(nota);
        
        if (id == 0) {
            int idNuevo = obtenerId(request);
            nc.setId(idNuevo);
            cal.add(nc);
        }
        else {
            int pos = buscarPorIndice(request,id);
            cal.set(pos, nc);
        }
        request.setAttribute("notas", cal);
        response.sendRedirect("index.jsp");
    }
    
    public int buscarPorIndice (HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<calificaciones> cal = (ArrayList<calificaciones>)ses.getAttribute("notas");
        int pos  = -1;
        if (cal != null) {
            for (calificaciones item : cal) {
                pos++;
                if (item.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }
    
    public int obtenerId (HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<calificaciones> cal = (ArrayList<calificaciones>)ses.getAttribute("notas");
        
        int idn = 0;
        for (calificaciones item : cal) {
            idn = item.getId();
        }
        return idn+1;
    }
}
