package blog.com.serverce.Impl;

import blog.com.dao.PageparametersDao;
import blog.com.entity.Pageparameters;
import blog.com.serverce.PageparametersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageparametersServiceImpl implements PageparametersService {
    @Autowired
    private PageparametersDao pageparametersdao;

    @Override
    public Pageparameters getPageparmeter(String projectName) {
        if (StringUtils.isNotBlank(projectName)){
            Pageparameters pageparameters=pageparametersdao.getPageparmeter(projectName);
            return pageparameters==null?null:pageparameters;
        }
        return null;
    }
}
