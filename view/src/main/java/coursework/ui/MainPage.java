package coursework.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import coursework.dao.TasksDAOImpl;
import coursework.dao.interfaces.TasksDAO;
import coursework.datatypes.Priority;
import coursework.datatypes.Status;
import coursework.entities.TaskEntity;
import coursework.utils.EnumItemCaptionGenerator;
import coursework.utils.EnumRenderer;
import coursework.utils.LocalDateRenderer;

import javax.servlet.annotation.WebServlet;
import java.util.Arrays;
import java.util.Set;


@Title("Bugtrack")
@Theme("valo")
public class MainPage extends UI {
    public static final float WIDTH = 1400;
    public static final float PRIORITY_COLUMN_WIDTH = 100;
    public static final float STATUS_COLUMN_WIDTH = 120;
    public static final float DUE_DATE_COLUMN_WIDTH = 100;
    
    public static final String DATE_FORMAT = "dd.MM.YY";
    
    private final LocalDateRenderer localDateRenderer = new LocalDateRenderer(DATE_FORMAT);
    
    private final GridLayout wrapPane = new GridLayout(1, 1);
    private final HorizontalLayout mainLayout = new HorizontalLayout();
    private final VerticalLayout rightPane = new VerticalLayout();
    private final HorizontalLayout buttonsPane = new HorizontalLayout();
    private final FormLayout filterFormLayout = new FormLayout();
    private final Grid<TaskEntity> tasksGrid = new Grid<>();
    
    private final Button btnDelete = new Button("Delete");
    private final Button btnNew = new Button("New");
    
    private final TextField filterText = new TextField("Search by text");
    private final ComboBox<Priority> filterPriority = new ComboBox<>("Priority");
    private final ComboBox<Status> filterStatus = new ComboBox<>("Status");
    private final DateField filterStartDate = new DateField("Start Date");
    private final DateField filterDueDate = new DateField("Due Date");
    
    private TasksDAO tasksDAO = new TasksDAOImpl(); // todo: change
    
    private Set<TaskEntity> selectedItems;
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        initLayout();
        tasksGridInit();
        rightPaneInit();
    
        wrapPane.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        wrapPane.setSizeFull();
        wrapPane.addComponent(mainLayout);
        
        mainLayout.setWidth(WIDTH, Unit.PIXELS);
        mainLayout.setHeight("100%");
        mainLayout.setMargin(new MarginInfo(true, false, false, false));
    
        rightPane.setMargin(true);
    }

    private void initLayout() {
        setContent(wrapPane);
        
        mainLayout.addComponent(tasksGrid);
        mainLayout.addComponent(rightPane);
        
        rightPane.addComponent(buttonsPane);
        rightPane.addComponent(filterFormLayout);
    
        buttonsPane.addComponent(btnNew);
        buttonsPane.addComponent(btnDelete);
        
        filterFormLayout.addComponent(filterText);
        filterFormLayout.addComponent(filterPriority);
        filterFormLayout.addComponent(filterStatus);
        filterFormLayout.addComponent(filterStartDate);
        filterFormLayout.addComponent(filterDueDate);
    }
    
    public void tasksGridInit() {
        tasksGrid.setSizeFull();
        tasksGrid.setSelectionMode(Grid.SelectionMode.MULTI);
        
        tasksGrid.addColumn(TaskEntity::getName)
                .setCaption("Name")
                .setResizable(false);
        tasksGrid.addColumn(TaskEntity::getPriority, new EnumRenderer<Priority>())
                .setCaption("Priority")
                .setWidth(PRIORITY_COLUMN_WIDTH)
                .setResizable(false);
        tasksGrid.addColumn(TaskEntity::getStatus, new EnumRenderer<Status>())
                .setCaption("Status")
                .setWidth(STATUS_COLUMN_WIDTH)
                .setResizable(false);
        tasksGrid.addColumn(TaskEntity::getDueDate, localDateRenderer)
                .setCaption("DueDate")
                .setWidth(DUE_DATE_COLUMN_WIDTH)
                .setResizable(false);
        
        tasksGrid.addItemClickListener(event -> {
            if (event.getMouseEventDetails().isDoubleClick()) {
                TaskEntity task = event.getItem();
                TaskEditWindow taskEditWindow = new TaskEditWindow(task);
                taskEditWindow.addCloseListener(e -> refreshTasks());
                getUI().getUI().addWindow(taskEditWindow);
            }
        });
        
        refreshTasks();
    }
    
    private void rightPaneInit() {
        filterFormLayout.setSizeFull();
        
        filterText.setWidth("100%");
        filterPriority.setItems(Arrays.asList(Priority.values()));
        filterPriority.setItemCaptionGenerator(new EnumItemCaptionGenerator<>());
        filterStatus.setItems(Arrays.asList(Status.values()));
        filterStatus.setItemCaptionGenerator(new EnumItemCaptionGenerator<>());
        
        btnNew.addClickListener(event -> {
            TaskCreateWindow taskCreateWindow = new TaskCreateWindow();
            taskCreateWindow.addCloseListener(e -> refreshTasks());
            getUI().getUI().addWindow(taskCreateWindow);
        });
        
        btnDelete.addClickListener(event -> {
            selectedItems = tasksGrid.getSelectedItems();
                int cnt = selectedItems.size();
                if (cnt > 0) {
                    for (TaskEntity taskEntity : selectedItems) {
                        tasksDAO.delete(taskEntity);
                    }
                    String message = (cnt > 1) ? "Successfully deleted " + cnt + " tasks" : "Task Successfully deleted";
                    Notification successDeleteNotification = new Notification(message, Notification.Type.HUMANIZED_MESSAGE);
                    successDeleteNotification.show(Page.getCurrent());
        
                    refreshTasks();
            }
        });
    }
    
    public void refreshTasks() {
        tasksGrid.setItems(tasksDAO.readAll(0, 0));
    }
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainPage.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
