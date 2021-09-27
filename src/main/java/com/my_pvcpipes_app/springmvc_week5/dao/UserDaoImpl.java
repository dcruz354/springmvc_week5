/**
 * 
 */
package com.my_pvcpipes_app.springmvc_week5.dao;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.my_pvcpipes_app.springmvc_week5.model.Login;
import com.my_pvcpipes_app.springmvc_week5.model.User;

/**
 * @author Dcruz
 *
 */
public class UserDaoImpl implements IUserDao {

	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public void register(User user) {
		    String sql = "insert into users values(?,?,?,?,?)";
		    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
		    user.getLastname(), user.getEmail()});
		    }
	  
		    public User validateUser(Login login) {
		    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
		    + "'";
		    List<User> users = jdbcTemplate.query(sql, new UserMapper());
		    return users.size() > 0 ? users.get(0) : null;
		    }
}

class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    return user;
	  }
	}
