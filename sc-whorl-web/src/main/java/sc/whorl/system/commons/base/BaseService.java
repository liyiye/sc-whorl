package sc.whorl.system.commons.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import sc.whorl.system.commons.MyMapper;
import sc.whorl.web.vo.system.UpMenuRequest;


public abstract class BaseService<M extends MyMapper<T>, T> {
    @Autowired
    protected M mapper;
    public void setMapper(M mapper) {
        this.mapper = mapper;
    }


    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }


    public T selectByPrimaryKey(Object id) {
        return mapper.selectByPrimaryKey(id);
    }


    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }


    public List<T> selectListAll() {
        return mapper.selectAll();
    }


    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }


    public void insert(T entity) {
        mapper.insert(entity);
    }


    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }


    public void delete(T entity) {
        mapper.delete(entity);
    }


    public void deleteByPrimaryKey(Object id) {
        mapper.deleteByPrimaryKey(id);
    }


    public void updateByPrimaryKey(T entity) {
        mapper.updateByPrimaryKey(entity);
    }


    public void updateByPrimaryKeySelective(T entity) {
        mapper.updateByPrimaryKeySelective(entity);

    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    public int updateByExampleSelective(T entity, Object example) {
        return mapper.updateByExampleSelective(entity, example);
    }

    public boolean existsWithPrimaryKey(Object primaryKey) {
        return mapper.existsWithPrimaryKey(primaryKey);
    }

    public T selectOneByExample(Object example) {
        return mapper.selectOneByExample(example);
    }

    public int insertList(List<T> recordList) {
        return mapper.insertList(recordList);
    }


}
