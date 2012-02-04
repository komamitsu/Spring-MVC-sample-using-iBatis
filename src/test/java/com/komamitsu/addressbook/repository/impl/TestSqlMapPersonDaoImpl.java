package com.komamitsu.addressbook.repository.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.komamitsu.addressbook.domain.Person;
import com.komamitsu.addressbook.repository.PersonDao;

@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager1")
public class TestSqlMapPersonDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
  private static final String NAME_OF_PERSON_A = "Foo Bar";
  private static final String ADDRESS_OF_PERSON_A = "Hogehoge 1-2-3, Ota-ku, Tokyo, Japan";
  private static final String POSTCODE_OF_PERSON_A = "123-0012";

  private static final String NAME_OF_PERSON_B = "Hello World";
  private static final String ADDRESS_OF_PERSON_B = "Zzzz 1-2-3, Shinagawa-ku, Tokyo, Japan";
  private static final String POSTCODE_OF_PERSON_B = "321-0032";

  @Autowired
  private PersonDao personDao;

  @Autowired
  @Qualifier("dataSource1")
  @Override
  public void setDataSource(DataSource dataSource) {
    super.setDataSource(dataSource);
  }

  @Before
  public void setup() {
    deleteFromTables("person");

    Person person = null;

    person = new Person();
    person.setName(NAME_OF_PERSON_A);
    person.setAddress(ADDRESS_OF_PERSON_A);
    person.setPostcode(POSTCODE_OF_PERSON_A);
    assertNotNull(personDao.insert(person));

    person = new Person();
    person.setName(NAME_OF_PERSON_B);
    person.setAddress(ADDRESS_OF_PERSON_B);
    person.setPostcode(POSTCODE_OF_PERSON_B);
    assertNotNull(personDao.insert(person));
  }

  @Test
  public void testSelectAllPeople() {
    List<Person> people = personDao.selectAll();
    assertEquals(2, people.size());
    Person person = null;

    person = people.get(0);
    assertEquals(NAME_OF_PERSON_A, person.getName());
    assertEquals(ADDRESS_OF_PERSON_A, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_A, person.getPostcode());

    person = people.get(1);
    assertEquals(NAME_OF_PERSON_B, person.getName());
    assertEquals(ADDRESS_OF_PERSON_B, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_B, person.getPostcode());
  }

  @Test
  public void testSelectPersonById() {
    List<Person> people = personDao.selectAll();

    Person person = personDao.selectById(people.get(0).getId());
    assertEquals(NAME_OF_PERSON_A, person.getName());
    assertEquals(ADDRESS_OF_PERSON_A, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_A, person.getPostcode());
  }

  @Test
  public void testUpdatePerson() {
    List<Person> people = personDao.selectAll();

    Person person = people.get(0);
    final String name = "Zzzzz Zzzzz";
    final String address = "Megumegu 3-4-5, Meguro-ku, Tokyo, Japan";
    final String postcode = "654-0065";
    person.setName(name);
    person.setAddress(address);
    person.setPostcode(postcode);
    personDao.update(person);
    person = personDao.selectById(person.getId());
    assertEquals(name, person.getName());
    assertEquals(address, person.getAddress());
    assertEquals(postcode, person.getPostcode());
  }

  @Test
  public void testDeletePerson() {
    List<Person> people = personDao.selectAll();
    personDao.delete(people.get(0));

    people = personDao.selectAll();
    assertEquals(1, people.size());

    Person person = people.get(0);
    assertEquals(NAME_OF_PERSON_B, person.getName());
    assertEquals(ADDRESS_OF_PERSON_B, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_B, person.getPostcode());
  }
}
