package com.DM.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DM.entity.Users;

@Repository
public class UserDaoImpl implements UserDao {
	
		@Autowired
		private SessionFactory sessionFactory;

	@Override
		public boolean isValidUser(String id, String password) throws SQLException {
		
				 //get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// Query
				Query<Users> theQuery = currentSession.createQuery("From users u where u.id=:userid and u.passwordUser=:passwd ",Users.class);
				theQuery.setParameter("userid", id);
				theQuery.setParameter("passwd", password);
				List results=theQuery.getResultList();
				Users user = (Users)results.get(0);
				return false;
				//errors in this file
	}

	@Override
	public List<Users> getCollectors() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Users> theQuery = currentSession.createQuery("from Users ",Users.class);
		
		List<Users> users = (List<Users>)theQuery.getResultList();
		return users;
		
	}

	@Override
	public List<Users> getCaretakers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(Users theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(theUser);
		
	}

	@Override
	public Users getUser(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int theId) {
		// TODO Auto-generated method stub
		
	}

}
