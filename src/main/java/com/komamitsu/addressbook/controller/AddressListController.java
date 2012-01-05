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
@RequestMapping(value = "/address")
public class AddressListController {
  private Logger logger = LoggerFactory.getLogger(AddressListController.class);

  @Autowired
  private PersonDao personDao;

  @RequestMapping(value = "list", method = RequestMethod.GET)
  public String getAddressList(Model model) {
    model.addAttribute("people", personDao.selectAllPeople());
    return "address/list";
  }

  @RequestMapping(value = "new", method = RequestMethod.GET)
  public String createForm(Model model) {
    model.addAttribute("person", new Person());
    return "address/form";
  }

  @RequestMapping(value = "person", method = RequestMethod.POST)
  public String create(@Valid Person person, BindingResult result) {
    if (result.hasErrors()) {
      logger.warn(result.getFieldErrors().toString());
      return "address/form";
    }
    this.personDao.insertPerson(person);
    return "redirect:/address/list";
  }
}
