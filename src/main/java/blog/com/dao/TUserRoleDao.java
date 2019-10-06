package blog.com.dao;

import blog.com.entity.TUserRole;

import java.util.List;

public interface TUserRoleDao {
    public List<String> findRoleIDByUserId(String userId) throws Exception;
}
