/**
 * 
 */
package com.my_pvcpipes_app.springmvc_week5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my_pvcpipes_app.springmvc_week5.dao.UserDaoImpl;
import com.my_pvcpipes_app.springmvc_week5.model.User;

/**
 * @author Dcruz
 *
 */
@Controller
public class RegistrationController {
  @Autowired
  UserDaoImpl userDao;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {
	  userDao.register(user);
  return new ModelAndView("welcome", "firstname", user.getFirstname());
  }
}
