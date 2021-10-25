//package com.revature.project.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import com.revature.project.model.User;
//
//import dev.edwin.entities.Employee;
//import dev.edwin.utils.ConnectionUtil;
//
//import com.revature.project.dao.UserDAO;
//
//import io.javalin.http.Handler;
//
//public class UserDAOImp implements UserDAO{
//

//	private static List<User> users = new ArrayList<User>(Arrays.asList(new User(0, "SteveRogers", "steve@gmail.com", null, 25, "steve"),
//			new User(1, "TonyStark", "tony@iron.com", null, 56, "tony"), new User(2, "CarolDanvers", "carol@xmas.com", null, 35, "carol")));
//
//	
	

	//-----------------------------------------------------------------
	
//	private static UserDAO uDao;
//
//	private UserDAOImp() {
//		super();
//	}
//
//	public static UserDAO getuDao() {
//
//		if (uDao == null)
//			uDao = new UserDAOImp();
//
//		return uDao;
//	}

	
	//-----------------------------------------------------------------------
	
	//work on it later
//	@Override
//	public User getUserByIdFromEmail(String email) {
//		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();
//		Session session = factory.openSession();
//		
//		
//		
//			Employee employee = new Employee();
//			employee.setEmail(rs.getString("email"));
//			employee.setPassword(rs.getString("password"));
//			employee.setName(rs.getString("name"));
//			employee.setImage_url(rs.getString("image_url"));
//			employee.setMgid(rs.getInt("mgid"));
//			employee.setEid(rs.getInt("eid"));
//
//			return employee;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	
//	public Optional<User> getUserById(int id) {
//		return users.stream().filter(u -> u.getId() == id).findAny();
//	}
//
	
	
	//--------------------------------------------------------------------------------------
	
//	public Optional<User> getUserById(int id) {
//		return users.stream().filter(u -> u.getId() == id).findAny();
//	}
//
//	
//	
//	public static Iterable<String> getAllUsernames() {
//		return users.stream().map(user -> user.getUsername()).collect(Collectors.toList());
//	}
////
//	public User addUser(User user) {
//		users.add(user);
//		return user;
//	}
	
	
//}
