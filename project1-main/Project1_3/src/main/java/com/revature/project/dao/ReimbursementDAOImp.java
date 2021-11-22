package com.revature.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.revature.project.model.User;
import com.revature.project.model.Reimbursement;


public class ReimbursementDAOImp implements ReimbursementDAO{

	private static ReimbursementDAO rdao = null;

	private ReimbursementDAOImp() {
		super();
	}

	public static ReimbursementDAO getRdao() {
		if (rdao == null)
			rdao = new ReimbursementDAOImp();

		return rdao;
	}

	// for returning a list of products and this needs to be moved to the product
	// DAO

//	public List<Product> getAllProducts () {
//            
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();
//		Session session = factory.openSession();
//        
//		Query products = session.createNativeQuery("SELECT * FROM product ORDER BY product_name;");
//		
//		List<Product> products = new ArrayList<Product>();
//		Product product;
//		for (Object[]) row : rows {
//            product  = new Product();    
//			product.setProductId((int) row[0]);
//			product.setProductName(row[1].toString());
//            product.setUnitPrice((double)row[2]);    
//                
//                     
//              products.add(product);
//            }            
//        return products;
//    }

	@Override
	public List<User> getAllUsers () {
  
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	
	Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
	
	SessionFactory factory = meta.getSessionFactoryBuilder().build();
	Session session = factory.openSession();
	
	Query allUsers = session.createNativeQuery("SELECT * FROM tbl_user;");
	List<Object[]> rows = allUsers.getResultList();
	List<User> users = new ArrayList<User>();
	User user;
	for (Object[] row : rows) {
		user  = new User();    
		user.setId((int) row[0]);
		user.setUsername(row[1].toString());
		user.setEmail(row[2].toString());
		user.setEmail(row[3].toString());
		user.setEthnicity(row[4].toString());
		user.setAge((int)row[5]);
		user.setPassword(row[6].toString());
	                 
	    users.add(user);
	  }    
	session.getTransaction().commit();
	session.close();

	return users;

}
	
	
	//Change to createUser ---------------------------------------------------------------------------------------
	
//	public static List<User> getAllUsers() {
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();
//		Session session = factory.openSession();
//		Query createReimbrsement = session.createQuery("INSERT INTO reimbursement VALUES (?,?,?,?,?,?,?,?,?"))
//
//		Query<Object[]> query = session.createNativeQuery("INSERT INTO reimbursement VALUES (?,?,?,?,?,?,?,?,?");
//		
//		List<Object[]> rows = query.getResultList();
//		
//		for(Object[] row : rows){
//		
//			System.out.println(user);
//		}

//		#complete with this example: 
//		Query query = session.createQuery("UPDATE Student SET name = :stud_name WHERE id = :stud_id");
//		query.setParameter("stud_name", "John");
//		query.setParameter("stud_id", "105");
//		int result = query.executeUpdate();

	
//	-------------------------------------------------------------------------------------------------------------
	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		try {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			reimbursement = new Reimbursement();
			reimbursement.setUserId(reimbursement.getUserId());
			reimbursement.setEmployeeComments(reimbursement.getEmployeeComments());
			reimbursement.setAmountRequested(reimbursement.getAmountRequested());
			reimbursement.setAmountApproved(reimbursement.getAmountApproved());
			transaction.commit();
			System.out.println("\n\n Reimburesment Added \n");
			session.close();
			return reimbursement;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		
		return null;
	}

	@Override
	public Reimbursement getReimbursementById(int rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}


//	@Override
//	public Reimbursement createReimbursement(Reimbursement reimbursement) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "INSERT INTO project1_db.REIMBURSEMENT VALUES (?,?,?,?,?,?,?,?,?)";
//			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setInt(1, 0);
//			ps.setDouble(2, reimbursement.getAmount());
//			ps.setString(3, reimbursement.getSubmit_date().toString());
//			ps.setInt(4, reimbursement.getStatus());
//			ps.setString(5, reimbursement.getStatus_date().toString());
//			ps.setString(6, reimbursement.getEmployee_note());
//			ps.setString(7, reimbursement.getManager_note());
//			ps.setInt(8, reimbursement.getCid());
//			ps.setInt(9, reimbursement.getEid());
//			ps.execute();
//
//			ResultSet rs = ps.getGeneratedKeys();
//			rs.next();
//			int key = rs.getInt("rid");
//			reimbursement.setRid(key);
//
//			return reimbursement;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@Override
//	public Reimbursement getReimbursementById(int rid) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM project1_db.REIMBURSEMENT WHERE rid = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, rid);
//
//			ResultSet rs = ps.executeQuery();
//			rs.next();
//
//			Reimbursement reimbursement = new Reimbursement();
//			reimbursement.setAmount(rs.getFloat("amount"));
//			reimbursement.setSubmit_date(rs.getString("submit_date"));
//			reimbursement.setStatus(rs.getInt("status"));
//			reimbursement.setStatus_date(rs.getString("status_date"));
//			reimbursement.setEmployee_note(rs.getString("employee_note"));
//			reimbursement.setManager_note(rs.getString("manager_note"));
//			reimbursement.setCid(rs.getInt("cid"));
//			reimbursement.setEid(rs.getInt("eid"));
//			reimbursement.setRid(rs.getInt("rid"));
//
//			return reimbursement;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@Override
//	public List<Reimbursement> getAllReimbursement() {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM project1_db.REIMBURSEMENT";
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ResultSet rs = ps.executeQuery();
//			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
//			Reimbursement reimbursement;
//			while (rs.next()) {
//				reimbursement = new Reimbursement();
//				reimbursement.setAmount(rs.getFloat("amount"));
//				reimbursement.setSubmit_date(rs.getString("submit_date"));
//				reimbursement.setStatus(rs.getInt("status"));
//				reimbursement.setStatus_date(rs.getString("status_date"));
//				reimbursement.setEmployee_note(rs.getString("employee_note"));
//				reimbursement.setManager_note(rs.getString("manager_note"));
//				reimbursement.setCid(rs.getInt("cid"));
//				reimbursement.setEid(rs.getInt("eid"));
//				reimbursement.setRid(rs.getInt("rid"));
//
//				reimbursements.add(reimbursement);
//			}
//
//			return reimbursements;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	@Override
//	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "UPDATE REIMBURSEMENT SET amount=?,status=?,status_date=?,employee_note=?,manager_note=?,cid=?,eid=? WHERE rid = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//
//			ps.setDouble(1, reimbursement.getAmount());
////            ps.setString(2, reimbursement.getSubmit_date().toString());
//			ps.setInt(2, reimbursement.getStatus());
//			ps.setString(3, reimbursement.getStatus_date().toString());
//			ps.setString(4, reimbursement.getEmployee_note());
//			ps.setString(5, reimbursement.getManager_note());
//			ps.setInt(6, reimbursement.getCid());
//			ps.setInt(7, reimbursement.getEid());
//			ps.setInt(8, reimbursement.getRid());
//
//			if (ps.executeUpdate() > 0) {
//				return reimbursement;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public boolean deleteReimbursement(Reimbursement reimbursement) {
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "DELETE FROM project1_db.REIMBURSEMENT WHERE rid = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, reimbursement.getRid());
//
//			if (ps.executeUpdate() > 0) {
//				return true;
//			}
//
//			return false;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
	//}

}
