package com.komamitsu.addressbook.repository;

import java.util.List;

import com.komamitsu.addressbook.domain.Person;

public interface PersonDao {
  Person selectById(long id);

  List<Person> selectAll();

  Long insert(Person person);

  void update(Person person);

  void delete(Person person);
}
