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
import com.my_pvcpipes_app.springmvc_week5.model.Login;
import com.my_pvcpipes_app.springmvc_week5.model.User;

/**
 * @author Dcruz
 *
 */
@Controller
public class LoginController {
  @Autowired
  UserDaoImpl userDao;
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userDao.validateUser(login);
    if (null != user) {
    mav = new ModelAndView("welcome");
    mav.addObject("firstname", user.getFirstname());
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
}
