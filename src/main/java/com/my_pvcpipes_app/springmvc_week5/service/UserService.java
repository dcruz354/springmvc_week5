/**
 * 
 */
package com.my_pvcpipes_app.springmvc_week5.service;

import org.springframework.transaction.annotation.Transactional;

import com.my_pvcpipes_app.springmvc_week5.dao.IUserDao;

/**
 * @author Dcruz
 *
 */
@Transactional 
public class UserService {

	private IUserDao userDao;
	
	
}
