package com.komamitsu.addressbook.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProject {
  private Project project;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    project = new Project();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testAccessorOfName() {
    project.setName("FooBar");
    assertEquals("FooBar", project.getName());
  }
}
