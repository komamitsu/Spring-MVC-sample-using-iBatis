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

  public List<Person> getPeople() {
    return null;
  }

  public Person insertPerson(Person person) {
    return null;
  }

  public void updatePerson(Person person) {
  }

  public void deletePerson(Person person) {
  }
}
