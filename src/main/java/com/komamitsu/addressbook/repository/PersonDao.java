package com.komamitsu.addressbook.repository;

import java.util.List;

import com.komamitsu.addressbook.domain.Person;

public interface PersonDao {
  Person selectPersonById(long id);

  List<Person> selectAllPeople();

  void insertPerson(Person person);

  void updatePerson(Person person);

  void deletePerson(Person person);
}
