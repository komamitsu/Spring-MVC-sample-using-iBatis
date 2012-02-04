package com.komamitsu.addressbook.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.komamitsu.addressbook.domain.Person;
import com.komamitsu.addressbook.repository.PersonDao;

@Controller
@RequestMapping(value = "/person")
public class PersonListController {
  private Logger logger = LoggerFactory.getLogger(PersonListController.class);

  @Autowired
  private PersonDao personDao;

  @RequestMapping(value = "list", method = RequestMethod.GET)
  public String getAddressList(Model model) {
    model.addAttribute("people", personDao.selectAll());
    return "person/list";
  }

  @RequestMapping(value = "new", method = RequestMethod.GET)
  public String createForm(Model model) {
    model.addAttribute("person", new Person());
    return "person/form";
  }

  @RequestMapping(value = "create", method = RequestMethod.POST)
  public String create(@Valid Person person, BindingResult result) {
    if (result.hasErrors()) {
      logger.warn(result.getFieldErrors().toString());
      return "person/form";
    }
    this.personDao.insert(person);
    return "redirect:/person/list";
  }
}
