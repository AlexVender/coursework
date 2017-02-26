package coursework;

import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

@Title("Bugtrack")
public class MainPage extends UI {
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initLayout();
    }

    private void initLayout() {

    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainPage.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
