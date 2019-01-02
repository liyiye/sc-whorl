package sc.whorl.logic.domain.dao.auth;

import java.util.List;

import sc.whorl.logic.domain.model.auth.Role;
import sc.whorl.logic.domain.model.auth.User;
import sc.whorl.system.commons.MyMapper;

public interface UserMapper extends MyMapper<User> {
    List<Role> selectRolsByUserId(Long userId);
}