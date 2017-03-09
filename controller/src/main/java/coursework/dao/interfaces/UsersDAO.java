package coursework.dao.interfaces;

import coursework.entities.UserEntity;

import java.util.List;


public interface UsersDAO {
    Integer create(UserEntity user);
    
    UserEntity read(Integer id);
    
    List<UserEntity> readAll(Integer limit, Integer offset);
    
    void update(UserEntity user);
    
    void delete(Integer id);
}
