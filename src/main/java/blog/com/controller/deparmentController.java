package blog.com.controller;

import blog.com.blogUtils.revertMessage;
import blog.com.entity.SysDepartment;
import blog.com.serverce.SysDepartmentService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/Deparment")
public class deparmentController {
    private final static Logger LOGGER=Logger.getLogger(deparmentController.class);
    @Autowired
    private SysDepartmentService sysDepartmentService;

    @RequestMapping(value = "getAllDeparment",method = RequestMethod.GET)
    @ResponseBody
    public String getAllDeparment(HttpServletRequest request, HttpServletResponse response){
        List<SysDepartment> allDepartment =sysDepartmentService.getAllDepartment();
        revertMessage revertMessage=new revertMessage();
        if (allDepartment.size()!=0&&allDepartment!=null){
            revertMessage.setId(200);
            revertMessage.setStatus("200");
            revertMessage.setData(allDepartment);
            return JSON.toJSONString(revertMessage);
        }else {
            LOGGER.error("部门信息查询为空,请处理");
            return JSON.toJSONString(revertMessage);
        }
    }

}
