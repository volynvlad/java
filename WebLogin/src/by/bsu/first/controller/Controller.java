package by.bsu.first.controller;

import by.bsu.first.command.CommandProvideer;
import by.bsu.first.command.Command;
import by.bsu.first.manager.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        Optional<Command> commandOptional =
                CommandProvideer.defineCommand(request.getParameter("command"));
        Command command = commandOptional.orElseThrow(IllegalArgumentException::new);//get();

        String page = command.execute(request);

        if (page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            request.getSession().setAttribute("nullPage", MessageManager.EN.getMessage("message.nullpage"));
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }
}
