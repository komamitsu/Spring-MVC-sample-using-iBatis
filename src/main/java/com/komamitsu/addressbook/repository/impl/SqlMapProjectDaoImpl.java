package com.komamitsu.addressbook.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.komamitsu.addressbook.domain.Project;
import com.komamitsu.addressbook.repository.ProjectDao;

@Repository
public class SqlMapProjectDaoImpl extends SqlMapClientDaoSupport implements ProjectDao {
  private static final String NAMESPACE = "project.";

  @Autowired
  @Qualifier("sqlMapClient2")
  public void injectSqlMapClient(SqlMapClient sqlMapClient) {
    setSqlMapClient(sqlMapClient);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Project> selectAll() {
    return getSqlMapClientTemplate().queryForList(NAMESPACE + "selectAll");
  }

  @Override
  public Long insert(Project project) {
    return (Long) getSqlMapClientTemplate().insert(NAMESPACE + "insert", project);
  }

  @Override
  public void update(Project project) {
    getSqlMapClientTemplate().update(NAMESPACE + "update", project);
  }

  @Override
  public void delete(Project project) {
    getSqlMapClientTemplate().delete(NAMESPACE + "delete", project);
  }

  @Override
  public Project selectById(long id) {
    return (Project) getSqlMapClientTemplate().queryForObject(NAMESPACE + "selectById", id);
  }
}
