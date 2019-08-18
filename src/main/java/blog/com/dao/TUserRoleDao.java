package blog.com.dao;

import blog.com.entity.TUserRole;

import java.util.List;

public interface TUserRoleDao {
    public List<TUserRole> findRoleIDByUserId(String userId) throws Exception;
}
