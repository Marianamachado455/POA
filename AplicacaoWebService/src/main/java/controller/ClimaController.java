package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ClimaDTO;
import dto.PrevisaoDTO;
import services.ClimaService;

@WebServlet("/clima")   
public class ClimaController extends HttpServlet {
    private ClimaService service = new ClimaService();

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cidade = request.getParameter("cidade");
        System.out.println("Cidade recebida: " + cidade);

        ClimaDTO clima = service.buscarClima(cidade);
        List<PrevisaoDTO> previsoes = service.buscarPrevisao();

        request.setAttribute("clima", clima);
        request.setAttribute("previsoes", previsoes);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
