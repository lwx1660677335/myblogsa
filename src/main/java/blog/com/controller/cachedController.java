package blog.com.controller;

import blog.com.blogUtils.revertMessage;
import blog.com.realm.CustomRealm;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cachedController {
    @Autowired
    private CustomRealm customRealm;

    /**清空缓存
     * @see 2019/9/16
     * @since 默默
     * @return  返回信息
     */
    @RequestMapping(value = "/cachedClear",method = RequestMethod.GET)
    public String cachedClear(){
        revertMessage revertMessage=new revertMessage(true);
        customRealm.clearCached();
        return JSON.toJSONString(revertMessage);
    }

}
