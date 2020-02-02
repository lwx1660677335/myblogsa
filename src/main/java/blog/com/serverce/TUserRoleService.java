package blog.com.serverce;

import blog.com.entity.TUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserRoleService {
    public List<String> findRoleIDByUserId(String userId) throws Exception;

    int addTUserRole(TUserRole tUserRole);

    int deleteTUserRole(List<String> userid);
}
