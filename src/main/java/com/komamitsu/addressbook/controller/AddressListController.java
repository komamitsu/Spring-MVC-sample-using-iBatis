package com.komamitsu.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.komamitsu.addressbook.repository.PersonDao;

@Controller
@RequestMapping(value = "/address")
public class AddressListController {
  @Autowired
  private PersonDao personDao;

  @RequestMapping(method = RequestMethod.GET)
  public String getAddressList(Model model) {
    model.addAttribute("people", personDao.selectAllPeople());
    return "addressList";
  }
}
