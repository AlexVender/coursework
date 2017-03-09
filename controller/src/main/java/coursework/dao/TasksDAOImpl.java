package coursework.dao;

import coursework.dao.interfaces.TasksDAO;
import coursework.entities.TaskEntity;

/**
 * Created by chanta on 08.03.17.
 */
public class TasksDAOImpl  extends AbstractDAO implements TasksDAO {
    @Override
    public Integer create(TaskEntity task) {
        return super.create(task);
    }

    @Override
    public TaskEntity read(Integer id) {
        return (TaskEntity)super.read(id,TaskEntity.class);
    }

    @Override
    public TaskEntity readAll(Integer limit, Integer offset) {
        return (TaskEntity)super.readAll(limit,offset,TaskEntity.class);
    }

    @Override
    public void update(TaskEntity task) {
        super.update(task);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
