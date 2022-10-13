package no.hvl.dat108.mylist.util;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Login {
    @Value("${app.url.logouttimer}") private static int MAX_INTERVAL;
    public static void userLogOut(HttpSession session){
        session.invalidate();
    }
    public static void userLogIn(HttpServletRequest request, String password){
        userLogOut(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERVAL);
        session.setAttribute("password", password);
        session.setAttribute("list", new MyList());
    }
    public static boolean isNotLogedIn(HttpSession session){
        return session == null
                || session.getAttribute("password") == null
                || session.getAttribute("list") == null;
    }
}
