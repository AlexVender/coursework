package coursework.dao.interfaces;

import coursework.entities.ProjectEntity;


public interface ProjectsDAO {
    Integer create(ProjectEntity project);
    
    ProjectEntity read(Integer id);
    
    ProjectEntity readAll(Integer limit, Integer offset);
    
    void update(ProjectEntity peoject);
    
    void delete(Integer id);
}
