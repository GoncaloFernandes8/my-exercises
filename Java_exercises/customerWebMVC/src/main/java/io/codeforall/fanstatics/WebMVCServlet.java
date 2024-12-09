package io.codeforall.fanstatics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebMVCServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ClientView.jsp");
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Gajo");
        customer.setEmail("gajo@gmail.com");
        customer.setPhone(123124124);
        req.getSession().setAttribute("customer", customer);
        dispatcher.forward(req, resp);
        resp.getWriter().println(dispatcher);
        resp.getWriter().close();
    }
}
