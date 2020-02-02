package blog.com.dao;

import blog.com.entity.TUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserRoleDao {
    public List<String> findRoleIDByUserId(String userId) throws Exception;

    int addTUserRole(@Param("tUserRole") TUserRole tUserRole);

    int deleteTUserRole(@Param("item") List<String> item);
}
