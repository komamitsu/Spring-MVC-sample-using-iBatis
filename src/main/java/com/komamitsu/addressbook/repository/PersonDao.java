package com.komamitsu.addressbook.repository;

import java.util.List;

import com.komamitsu.addressbook.domain.Person;

public interface PersonDao {
  List<Person> getPeople();

  Person insertPerson(Person person);

  void updatePerson(Person person);

  void deletePerson(Person person);
}
