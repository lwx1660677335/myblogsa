package blog.com.serverce.Impl;

import blog.com.dao.PermissiongroupsDao;
import blog.com.entity.Permissiongroups;
import blog.com.entity.childMenu;
import blog.com.entity.parentMenu;
import blog.com.entity.voentity.treeMenuData;
import blog.com.serverce.PermissiongroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("permissiongroupsservice")
public class PermissiongroupsServiceImpl implements PermissiongroupsService {
    @Autowired
    private PermissiongroupsDao permissiongroupsDao;
    @Override
    public List<Permissiongroups> findPermissionNameByPermissionKey(List<String> list) throws Exception {
        List<Permissiongroups> permissiongroups=null;
        List<Permissiongroups> permissiongroupsList=permissiongroupsDao.findPermissionNameByPermissionKey(list);
        if (permissiongroupsList.size()>0){
            return permissiongroupsList;
        }else {
            return permissiongroups;
        }
    }

    @Override
    public List<Permissiongroups> getAllPermissiongroups() {
        List<Permissiongroups> permissiongroupsList=permissiongroupsDao.getAllPermissiongroups();
        return permissiongroupsList.size()!=0&&permissiongroupsList!=null?permissiongroupsList:null;
    }
    public List<treeMenuData> getTreeMenuData(){
        List<Permissiongroups> permissiongroups=this.getAllPermissiongroups();
        List<treeMenuData> parentMenus=new ArrayList<>();
        if (permissiongroups!=null&&permissiongroups.size()!=0){
            for (Permissiongroups permissiongroups1:permissiongroups
            ) {
                treeMenuData treeMenuData=new treeMenuData();


                if (permissiongroups1.getPermissionFaterNumber().equals("0")){
                    List<treeMenuData> childMenus=new ArrayList<>();
                    treeMenuData.setId(permissiongroups1.getPermissionKey());
                    treeMenuData.setTitle(permissiongroups1.getPermissionName());
                    treeMenuData.setHref(permissiongroups1.getPermissionUrl());

                    for (Permissiongroups permissiongroups2:permissiongroups
                    ) {
                        if (permissiongroups1.getPermissionKey().equals(permissiongroups2.getPermissionFaterNumber())){
                            treeMenuData treeMenuData1=new treeMenuData();
                            treeMenuData1.setId(permissiongroups2.getPermissionKey());
                            treeMenuData1.setTitle(permissiongroups2.getPermissionName());
                            treeMenuData1.setHref(permissiongroups2.getPermissionUrl());
                            childMenus.add(treeMenuData1);
                        }
                    }
                    treeMenuData.setChildren(childMenus);
                    parentMenus.add(treeMenuData);
                }
            }
        }
        return parentMenus!=null&&parentMenus.size()!=0?parentMenus:null;
    }
}
