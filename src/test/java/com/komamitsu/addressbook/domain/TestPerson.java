package com.komamitsu.addressbook.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPerson {
  private Person person;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    person = new Person();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testAccessorOfName() {
    person.setName("FooBar");
    assertEquals("FooBar", person.getName());
  }

  @Test
  public void testAccessorOfAddress() {
    person.setAddress("東京都大田区ほげほげ1-1-1");
    assertEquals("東京都大田区ほげほげ1-1-1", person.getAddress());
  }

  @Test
  public void testAccessorOfPostCode() {
    person.setPostcode("123-0012");
    assertEquals("123-0012", person.getPostcode());
  }

}
