package com.komamitsu.addressbook.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.komamitsu.addressbook.domain.Person;
import com.komamitsu.addressbook.repository.PersonDao;

@Repository
public class SqlMapPersonDaoImpl extends SqlMapClientDaoSupport implements PersonDao {
  private static final String NAMESPACE = "person.";

  @Autowired
  @Qualifier("sqlMapClient1")
  public void injectSqlMapClient(SqlMapClient sqlMapClient) {
    setSqlMapClient(sqlMapClient);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Person> selectAll() {
    return getSqlMapClientTemplate().queryForList(NAMESPACE + "selectAll");
  }

  @Override
  public Long insert(Person person) {
    return (Long) getSqlMapClientTemplate().insert(NAMESPACE + "insert", person);
  }

  @Override
  public void update(Person person) {
    getSqlMapClientTemplate().update(NAMESPACE + "update", person);
  }

  @Override
  public void delete(Person person) {
    getSqlMapClientTemplate().delete(NAMESPACE + "delete", person);
  }

  @Override
  public Person selectById(long id) {
    return (Person) getSqlMapClientTemplate().queryForObject(NAMESPACE + "selectById", id);
  }
}
