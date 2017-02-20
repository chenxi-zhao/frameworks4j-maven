package com.chenxi.spring4hibernate.dao.impl;

import com.chenxi.spring4hibernate.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhaochx1 on 2016/11/30.
 *
 * @author zhaochx1
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    private SessionFactory sessionFactory;

    private Class<T> persistantClass;

    /**
     * 获得当前事务的session
     *
     * @return org.hibernate.Session
     */
    protected Session getCurrentSession() {
        // return sessionFactory.getCurrentSession(); // hibernate 3.x版本后摒弃该方法
        //从会话工厂获取一个session
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    public BaseDaoImpl(){
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        this.persistantClass = (Class<T>) params[0];
    }

    @Override
    public Serializable save(T o) {
        if (o != null) {
            return this.getCurrentSession().save(o);
        }
        return null;
    }

    @Override
    public void delete(T o) {
        if (o != null) {
            this.getCurrentSession().delete(o);
        }
    }

    @Override
    public void update(T o) {
        if (o != null) {
            this.getCurrentSession().update(o);
        }
    }

    @Override
    public void saveOrUpdate(T o) {
        if (o != null) {
            this.getCurrentSession().saveOrUpdate(o);
        }
    }

    @Override
    public T get(Serializable id) {
        return this.getCurrentSession().get(persistantClass, id);
    }

    @Override
    public T get(String hql) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public T get(String hql, Map<String, Object> params) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        if (params != null && !params.isEmpty()) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                query.setParameter(key, params.get(key));
            }
        }
        List<T> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<T> find(String hql) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        return query.list();
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.list();
    }

    @Override
    public List<T> find(String hql, int page, int rows) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query<T> query = this.getCurrentSession().createQuery(hql, persistantClass);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public Long count(String hql) {
        Query query = this.getCurrentSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return (Long) query.uniqueResult();
    }

    @Override
    public int executeHql(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.executeUpdate();
    }

    @Override
    public int executeHql(String hql, Map<String, Object> params) {
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }
        }
        return query.executeUpdate();
    }

    @Override
    public List<T> findBySql(String sql) {
        NativeQuery<T> nativeQuery = this.getCurrentSession().createNativeQuery(sql, persistantClass);
        return nativeQuery.list();
    }

    @Override
    public List<T> findBySql(String sql, int page, int rows) {
        NativeQuery<T> nativeQuery = this.getCurrentSession().createNativeQuery(sql, persistantClass);
        return nativeQuery.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public List<T> findBySql(String sql, Map<String, Object> params) {
        NativeQuery<T> nativeQuery = this.getCurrentSession().createNativeQuery(sql, persistantClass);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                nativeQuery.setParameter(key, params.get(key));
            }
        }
        return nativeQuery.list();
    }

    @Override
    public List<T> findBySql(String sql, Map<String, Object> params, int page, int rows) {
        NativeQuery<T> nativeQuery = this.getCurrentSession().createNativeQuery(sql, persistantClass);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                nativeQuery.setParameter(key, params.get(key));
            }
        }
        return nativeQuery.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    @Override
    public int executeSql(String sql) {
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        return nativeQuery.executeUpdate();
    }

    @Override
    public int executeSql(String sql, Map<String, Object> params) {
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                nativeQuery.setParameter(key, params.get(key));
            }
        }
        return nativeQuery.executeUpdate();
    }

    @Override
    public BigInteger countBySql(String sql) {
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        return (BigInteger) nativeQuery.uniqueResult();
    }

    @Override
    public BigInteger countBySql(String sql, Map<String, Object> params) {
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                nativeQuery.setParameter(key, params.get(key));
            }
        }
        return (BigInteger) nativeQuery.uniqueResult();
    }

    @Override
    public void batchSave(List<T> entitys) throws SQLException {
        for (int i = 0; i < entitys.size(); i++) {
            this.getCurrentSession().save(entitys.get(i));
            if (i % 20 == 0) {
                // 20个对象后才清理缓存，写入数据库
                getCurrentSession().flush();
                getCurrentSession().clear();
            }
        }
        // 最后清理一下----防止大于20小于40的不保存
        getCurrentSession().flush();
        getCurrentSession().clear();
    }
}
