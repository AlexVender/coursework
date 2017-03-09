package coursework.dao;

import coursework.dao.interfaces.UsersDAO;
import coursework.entities.UserEntity;

/**
 * Created by chanta on 08.03.17.
 */
public class UsersDAOImpl extends AbstractDAO implements UsersDAO {
    @Override
    public Integer create(UserEntity user) {
        return super.create(user);
    }

    @Override
    public UserEntity read(Integer id) {
        return (UserEntity) super.read(id,UserEntity.class);
    }

    @Override
    public UserEntity readAll(Integer limit, Integer offset) {
        return (UserEntity) super.readAll(limit, offset,UserEntity.class);
    }

    @Override
    public void update(UserEntity user) {
        super.update(user);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
