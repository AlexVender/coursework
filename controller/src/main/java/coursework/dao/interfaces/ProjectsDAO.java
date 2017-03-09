package coursework.dao.interfaces;

import coursework.entities.ProjectEntity;

import java.util.List;


public interface ProjectsDAO {
    Integer create(ProjectEntity project);
    
    ProjectEntity read(Integer id);
    
    List<ProjectEntity> readAll(Integer limit, Integer offset);
    
    void update(ProjectEntity peoject);
    
    void delete(Integer id);
}
