package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ClimaDTO;
import dto.LocalizacaoDTO;
import dto.PrevisaoDTO;
import services.ClimaService;

@WebServlet("/clima")   
public class ClimaController extends HttpServlet {
    private ClimaService service = new ClimaService();

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String cidade = request.getParameter("cidade");

        if (cidade == null || cidade.isBlank()) {
            cidade = "Rio de Janeiro";
        }

        LocalizacaoDTO localizacao = service.buscarLocalizacao(cidade);
        ClimaDTO clima = service.buscarClima(cidade);
        List<PrevisaoDTO> previsoes = service.buscarPrevisao(cidade);

        request.setAttribute("cidade", localizacao.getName());
        request.setAttribute("estado", localizacao.getEstado());
        request.setAttribute("pais", localizacao.getPais());
        request.setAttribute("clima", clima);
        request.setAttribute("previsoes", previsoes);
        request.setAttribute("previsoes", previsoes);

        String pagina = request.getParameter("pagina");

        if ("semana".equals(pagina)) {
            request.getRequestDispatcher("/semana.jsp").forward(request, response);
        } else if("sobre".equals(pagina)) {
            request.getRequestDispatcher("/sobre.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
