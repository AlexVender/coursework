package coursework.dao.interfaces;

import coursework.entities.ProjectEntity;


public interface ProjectsDAO {
    Integer create(ProjectEntity user);
    
    ProjectEntity read(Integer id);
    
    ProjectEntity readAll(Integer limit, Integer offset);
    
    void update(ProjectEntity user);
    
    void delete(Integer id);
}
