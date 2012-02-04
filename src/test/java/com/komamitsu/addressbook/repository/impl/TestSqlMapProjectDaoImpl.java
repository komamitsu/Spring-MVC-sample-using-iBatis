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

import com.komamitsu.addressbook.domain.Project;
import com.komamitsu.addressbook.repository.ProjectDao;

@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "transactionManager2")
public class TestSqlMapProjectDaoImpl extends AbstractTransactionalJUnit4SpringContextTests {
  private static final String NAME_OF_PROJECT_A = "Foo Bar";

  private static final String NAME_OF_PROJECT_B = "Hello World";

  @Autowired
  private ProjectDao projectDao;

  @Autowired
  @Qualifier("dataSource2")
  @Override
  public void setDataSource(DataSource dataSource) {
    super.setDataSource(dataSource);
  }

  @Before
  public void setup() {
    deleteFromTables("project");

    Project project = null;

    project = new Project();
    project.setName(NAME_OF_PROJECT_A);
    assertNotNull(projectDao.insert(project));

    project = new Project();
    project.setName(NAME_OF_PROJECT_B);
    assertNotNull(projectDao.insert(project));
  }

  @Test
  public void testSelectAllPeople() {
    List<Project> projects = projectDao.selectAll();
    assertEquals(2, projects.size());
    Project project = null;

    project = projects.get(0);
    assertEquals(NAME_OF_PROJECT_A, project.getName());

    project = projects.get(1);
    assertEquals(NAME_OF_PROJECT_B, project.getName());
  }

  @Test
  public void testSelectProjectById() {
    List<Project> projects = projectDao.selectAll();

    Project project = projectDao.selectById(projects.get(0).getId());
    assertEquals(NAME_OF_PROJECT_A, project.getName());
  }

  @Test
  public void testUpdateProject() {
    List<Project> projects = projectDao.selectAll();

    Project project = projects.get(0);
    final String name = "Zzzzz Zzzzz";
    project.setName(name);
    projectDao.update(project);
    project = projectDao.selectById(project.getId());
    assertEquals(name, project.getName());
  }

  @Test
  public void testDeleteProject() {
    List<Project> projects = projectDao.selectAll();
    projectDao.delete(projects.get(0));

    projects = projectDao.selectAll();
    assertEquals(1, projects.size());

    Project project = projects.get(0);
    assertEquals(NAME_OF_PROJECT_B, project.getName());
  }
}
