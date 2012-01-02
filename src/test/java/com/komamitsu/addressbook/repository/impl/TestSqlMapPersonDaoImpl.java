package com.komamitsu.addressbook.repository.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.komamitsu.addressbook.repository.PersonDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class TestSqlMapPersonDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
  @Autowired
  private PersonDao personDao;

  @Test
  public void testGetPeople() {
    assertEquals(null, personDao.getPeople());
  }
}
