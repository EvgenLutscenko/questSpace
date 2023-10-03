package ua.javarush.lutsenko.quest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.javarush.lutsenko.quest.entity.Exodus;
import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.entity.Question;
import ua.javarush.lutsenko.quest.entity.Quit;
import ua.javarush.lutsenko.quest.repo.StorageUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//Servlet that is main for quest
@WebServlet(name = "QuestServlet", value = "/quest-servlet")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        int choice = Integer.parseInt(request.getParameter("choice"));

        PartI part = StorageUtils.getPart(choice);

        session.setAttribute("currentStep", choice);
        session.setAttribute("currentQuestion", StorageUtils.getPart(choice));

        String ipAddress = request.getRemoteAddr();

        String userAgent = request.getHeader("User-Agent"); // Получить юзер-агент
        String referer = request.getHeader("Referer");

        Map<String, String> inf = new HashMap<>();
        inf.put("ip", ipAddress);
        inf.put("agent", userAgent);
        inf.put("referer", referer);

        session.setAttribute("inf", inf);

        if(part instanceof Question){
            request.getRequestDispatcher("WEB-INF/quest.jsp").forward(request, response);
        }else {
            if(((Quit)part).getExodus() == Exodus.NEGATIVE){
                request.getRequestDispatcher("WEB-INF/bad_quit.jsp").forward(request, response);
            }else if(((Quit)part).getExodus() == Exodus.POSITIVE) {
                request.getRequestDispatcher("WEB-INF/good_quit.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer currentStep = (Integer) session.getAttribute("currentStep");

        String ipAddress = request.getRemoteAddr();

        String userAgent = request.getHeader("User-Agent"); // Получить юзер-агент
        String referer = request.getHeader("Referer");

        Map<String, String> inf = new HashMap<>();
        inf.put("ip", ipAddress);
        inf.put("agent", userAgent);
        inf.put("referer", referer);

        session.setAttribute("inf", inf);

        if(currentStep == 0){
            session.setAttribute("currentStep", 1);
            request.getRequestDispatcher("WEB-INF/hello.jsp").forward(request, response);
        }else {
            session.setAttribute("currentQuestion", StorageUtils.getPart(1));
            request.getRequestDispatcher("WEB-INF/quest.jsp").forward(request, response);
        }
    }
}