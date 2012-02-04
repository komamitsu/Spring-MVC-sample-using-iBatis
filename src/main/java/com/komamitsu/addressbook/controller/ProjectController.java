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

import com.komamitsu.addressbook.domain.Project;
import com.komamitsu.addressbook.repository.ProjectDao;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {
  private Logger logger = LoggerFactory.getLogger(ProjectController.class);

  @Autowired
  private ProjectDao projectDao;

  @RequestMapping(value = "list", method = RequestMethod.GET)
  public String getAddressList(Model model) {
    model.addAttribute("projects", projectDao.selectAll());
    return "project/list";
  }

  @RequestMapping(value = "new", method = RequestMethod.GET)
  public String createForm(Model model) {
    model.addAttribute("project", new Project());
    return "project/form";
  }

  @RequestMapping(value = "create", method = RequestMethod.POST)
  public String create(@Valid Project project, BindingResult result) {
    if (result.hasErrors()) {
      logger.warn(result.getFieldErrors().toString());
      return "project/form";
    }
    this.projectDao.insert(project);
    return "redirect:/project/list";
  }
}
