/**
 * 
 */
package com.my_pvcpipes_app.springmvc_week5.dao;

import com.my_pvcpipes_app.springmvc_week5.model.Login;
import com.my_pvcpipes_app.springmvc_week5.model.User;

/**
 * @author Dcruz
 *
 */
public interface IUserDao {
	  void register(User user);
	  User validateUser(Login login);
	  public User findUserByUsername(String username);
	  public void updateUser(User user);
	}
