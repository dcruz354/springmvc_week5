/**
 * 
 */
package com.my_pvcpipes_app.springmvc_week5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UserController {
	  @Autowired
	  UserDaoImpl userDao;
	  
	  @RequestMapping(value="/update", method=RequestMethod.GET)
	  public ModelAndView update(@PathVariable("username") String username){
	   ModelAndView model = new ModelAndView("user_form");
	   
	   User user = userDao.findUserByUsername(username);
	   model.addObject("userForm", user);
	   
	   return model;
	  }

}
