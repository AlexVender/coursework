package coursework.dao;

import coursework.dao.interfaces.ProjectsDAO;
import coursework.entities.ProjectEntity;

/**
 * Created by chanta on 08.03.17.
 */
public class ProjectsDAOImpl extends AbstractDAO implements ProjectsDAO {

    @Override
    public Integer create(ProjectEntity project) {
        return super.create(project);
    }

    @Override
    public ProjectEntity read(Integer id) {
        return (ProjectEntity)super.read(id, ProjectEntity.class);
    }

    @Override
    public ProjectEntity readAll(Integer limit, Integer offset) {
        return (ProjectEntity)super.readAll(limit,offset, ProjectEntity.class);
    }

    @Override
    public void update(ProjectEntity user) {
        super.update(user);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
