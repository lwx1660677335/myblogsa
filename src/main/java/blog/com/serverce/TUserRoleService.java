package blog.com.serverce;

import blog.com.entity.TUserRole;

import java.util.List;

public interface TUserRoleService {
    public List<String> findRoleIDByUserId(String userId) throws Exception;
}
