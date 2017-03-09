package coursework.dao.interfaces;

import coursework.entities.TaskEntity;

import java.util.List;


public interface TasksDAO {
    Integer create(TaskEntity task);
    
    TaskEntity read(Integer id);
    
    List<TaskEntity> readAll(Integer limit, Integer offset);
    
    void update(TaskEntity task);
    
    void delete(Integer id);
}
