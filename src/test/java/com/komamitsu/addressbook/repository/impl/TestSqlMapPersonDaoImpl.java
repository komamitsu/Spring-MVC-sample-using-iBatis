package com.komamitsu.addressbook.repository.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.komamitsu.addressbook.repository.PersonDao;

@ContextConfiguration("/applicationContext-test.xml")
public class TestSqlMapPersonDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
  @Autowired
  private PersonDao personDao;

  @Test
  public void testGetPeople() {
    assertEquals(null, personDao.getPeople());
  }
}
