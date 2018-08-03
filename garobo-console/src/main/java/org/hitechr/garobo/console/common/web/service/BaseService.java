package org.hitechr.garobo.console.common.web.service;



import org.hitechr.garobo.console.common.utils.ReflectUtils;
import org.hitechr.garobo.console.common.web.dao.BaseMapper;
import org.hitechr.garobo.console.common.web.model.BaseModel;
import org.hitechr.garobo.console.common.web.page.PageList;
import org.hitechr.garobo.console.common.web.page.PaginatedList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/4/21.
 */

public class BaseService<T extends Serializable, E extends BaseModel> implements ApplicationContextAware, InitializingBean {
    protected final Log log = LogFactory.getLog(this.getClass());
    private ApplicationContext applicationContext;
    protected BaseMapper<T, E> mapper;
    private String MAPPERSUFFIX="Mapper";


    public int countByExample(E E) {
        return mapper.countByExample(E);
    }


    public int deleteByExample(E E) {
        return mapper.deleteByExample(E);
    }


    public int deleteByPrimaryKey(Object id) {
        return mapper.deleteByPrimaryKey(id);
    }

    
    public int insert(T record) {
        return mapper.insert(record);
    }

    
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    
    public List<T> selectByExample(E E) {
        return mapper.selectByExample(E);
    }

    
    public T selectByPrimaryKey(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    
    public int updateByExampleSelective(T record,E E) {
        return mapper.updateByExampleSelective(record, E);
    }


    public int updateByExample(T record,E E) {
        return mapper.updateByExample(record, E);
    }


    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }



    public PageList<T> getPageList(E example) {
        PageList<T> list = new PaginatedList(example.getPageIndex(), example.getPageSize());
        list.setTotalItem(countByExample(example));
        list.addAll(mapper.getPageList(example));
        return list;
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void afterPropertiesSet() throws Exception {
        String className = ReflectUtils.getSuperClassGenricType(this.getClass()).getSimpleName();
        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        if (applicationContext.containsBean(className + MAPPERSUFFIX)) {
            mapper = (BaseMapper) applicationContext.getBean(className + MAPPERSUFFIX);
        } else {
            log.error("no bean " + className + ",notice: saf client not need it.");
        }
    }

    public BaseMapper<T, E> getMapper() {
        return mapper;
    }

    public void setMapper(BaseMapper<T, E> mapper) {
        this.mapper = mapper;
    }
}
