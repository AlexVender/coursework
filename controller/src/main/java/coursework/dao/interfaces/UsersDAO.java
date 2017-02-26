package coursework.dao.interfaces;

import coursework.entities.UserEntity;


public interface UsersDAO {
    Integer create(UserEntity user);
    
    UserEntity read(Integer id);
    
    UserEntity readAll(Integer limit, Integer offset);
    
    void update(UserEntity user);
    
    void delete(Integer id);
}
