package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valor = request.getParameter("valor");
		String desconto = request.getParameter("desconto");

		double valorOriginal = Double.parseDouble(valor);
		double percentualDesconto = Double.parseDouble(desconto);

		double valorDescontado = valorOriginal * percentualDesconto / 100;

		double valorFinal = valorOriginal - valorDescontado;

		HttpSession session = request.getSession();

		session.setAttribute("valorOriginal", valorOriginal);
		session.setAttribute("percentualDesconto", percentualDesconto);
		session.setAttribute("valorDescontado", valorDescontado);
		session.setAttribute("valorFinal", valorFinal);

		response.sendRedirect("pag/res.jsp");
	}

}