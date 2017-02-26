package coursework.dao.interfaces;

import coursework.entities.TaskEntity;


public interface TasksDAO {
    Integer create(TaskEntity user);
    
    TaskEntity read(Integer id);
    
    TaskEntity readAll(Integer limit, Integer offset);
    
    void update(TaskEntity user);
    
    void delete(Integer id);
}
