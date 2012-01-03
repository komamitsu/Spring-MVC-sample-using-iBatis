package com.komamitsu.addressbook.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.komamitsu.addressbook.domain.Person;
import com.komamitsu.addressbook.repository.PersonDao;

@Repository
public class SqlMapPersonDaoImpl extends SqlMapClientDaoSupport implements PersonDao {
  @Autowired
  public void injectSqlMapClient(SqlMapClient sqlMapClient) {
    setSqlMapClient(sqlMapClient);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Person> selectAllPeople() {
    return getSqlMapClientTemplate().queryForList("selectAllPeople");
  }

  @Override
  public void insertPerson(Person person) {
    getSqlMapClientTemplate().insert("insertPerson", person);
  }

  @Override
  public void updatePerson(Person person) {
    getSqlMapClientTemplate().update("updatePerson", person);
  }

  @Override
  public void deletePerson(Person person) {
    getSqlMapClientTemplate().delete("deletePerson", person);
  }

  @Override
  public Person selectPersonById(long id) {
    return (Person) getSqlMapClientTemplate().queryForObject("selectPersonById", id);
  }
}
