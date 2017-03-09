package coursework.dao.interfaces;

import coursework.entities.TaskEntity;


public interface TasksDAO {
    Integer create(TaskEntity task);
    
    TaskEntity read(Integer id);
    
    TaskEntity readAll(Integer limit, Integer offset);
    
    void update(TaskEntity task);
    
    void delete(Integer id);
}
