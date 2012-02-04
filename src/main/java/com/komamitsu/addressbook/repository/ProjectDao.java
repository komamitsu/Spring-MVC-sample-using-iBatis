package com.komamitsu.addressbook.repository;

import java.util.List;

import com.komamitsu.addressbook.domain.Project;

public interface ProjectDao {
  Project selectById(long id);

  List<Project> selectAll();

  Long insert(Project project);

  void update(Project project);

  void delete(Project project);
}
