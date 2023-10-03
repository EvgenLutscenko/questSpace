package ua.javarush.lutsenko.quest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.javarush.lutsenko.quest.dbo.DBI;
import ua.javarush.lutsenko.quest.dbo.JSONParser;
import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.errors.RepoProblem;
import ua.javarush.lutsenko.quest.repo.StorageUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;


//Servlet fot initialize storage, session and else
@WebServlet(name = "InitializeServlet", value = "/initialize-servlet")
public class InitializeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StorageUtils.init(getRepo());

        RepoProblem problem;
        if((problem = StorageUtils.check()) != null){
            request.setAttribute("problem", problem);
            request.getRequestDispatcher("WEB-INF/errorPage.jsp").forward(request, response);
        }

        HttpSession session = request.getSession(true);

        session.setAttribute("currentStep", 0);
        session.setAttribute("currentQuestion", StorageUtils.getPart(0));

        request.getRequestDispatcher("/quest-servlet").forward(request, response);
    }

    private Map<Integer, PartI> getRepo(){
        DBI parser = new JSONParser();
        Properties properties = new Properties();

        try {
            InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/jsonStor/json.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser.parse(properties);
    }
}