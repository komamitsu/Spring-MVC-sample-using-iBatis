package com.komamitsu.addressbook.repository.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.komamitsu.addressbook.domain.Person;
import com.komamitsu.addressbook.repository.PersonDao;

@ContextConfiguration("/applicationContext-test.xml")
public class TestSqlMapPersonDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
  private static final String NAME_OF_PERSON_A = "Foo Bar";
  private static final String ADDRESS_OF_PERSON_A = "Hogehoge 1-2-3, Ota-ku, Tokyo, Japan";
  private static final String POSTCODE_OF_PERSON_A = "123-0012";

  private static final String NAME_OF_PERSON_B = "Hello World";
  private static final String ADDRESS_OF_PERSON_B = "Zzzz 1-2-3, Shinagawa-ku, Tokyo, Japan";
  private static final String POSTCODE_OF_PERSON_B = "321-0032";

  @Autowired
  private PersonDao personDao;

  @Before
  public void setup() {
    deleteFromTables("person");

    Person person = null;

    person = new Person();
    person.setName(NAME_OF_PERSON_A);
    person.setAddress(ADDRESS_OF_PERSON_A);
    person.setPostcode(POSTCODE_OF_PERSON_A);
    personDao.insertPerson(person);

    person = new Person();
    person.setName(NAME_OF_PERSON_B);
    person.setAddress(ADDRESS_OF_PERSON_B);
    person.setPostcode(POSTCODE_OF_PERSON_B);
    personDao.insertPerson(person);
  }

  @Test
  public void testSelectAllPeople() {
    List<Person> people = personDao.selectAllPeople();
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
    List<Person> people = personDao.selectAllPeople();

    Person person = personDao.selectPersonById(people.get(0).getId());
    assertEquals(NAME_OF_PERSON_A, person.getName());
    assertEquals(ADDRESS_OF_PERSON_A, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_A, person.getPostcode());
  }

  @Test
  public void testUpdatePerson() {
    List<Person> people = personDao.selectAllPeople();

    Person person = people.get(0);
    final String name = "Zzzzz Zzzzz";
    final String address = "Megumegu 3-4-5, Meguro-ku, Tokyo, Japan";
    final String postcode = "654-0065";
    person.setName(name);
    person.setAddress(address);
    person.setPostcode(postcode);
    personDao.updatePerson(person);
    person = personDao.selectPersonById(person.getId());
    assertEquals(name, person.getName());
    assertEquals(address, person.getAddress());
    assertEquals(postcode, person.getPostcode());
  }

  @Test
  public void testDeletePerson() {
    List<Person> people = personDao.selectAllPeople();
    personDao.deletePerson(people.get(0));

    people = personDao.selectAllPeople();
    assertEquals(1, people.size());

    Person person = people.get(0);
    assertEquals(NAME_OF_PERSON_B, person.getName());
    assertEquals(ADDRESS_OF_PERSON_B, person.getAddress());
    assertEquals(POSTCODE_OF_PERSON_B, person.getPostcode());

  }
}
