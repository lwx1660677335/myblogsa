package blog.com.serverce;

import blog.com.entity.TUserRole;

import java.util.List;

public interface TUserRoleService {
    public List<TUserRole> findRoleIDByUserId(String userId) throws Exception;
}
