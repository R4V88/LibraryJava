package r4v88.dao;

import r4v88.model.entity.UserRole;

import java.util.List;

public interface UserRoleDao {

    List<UserRole> getAllUsers();

    UserRole getRoleByID(int id);

    int getRoleIdByName(String roleName);
}
