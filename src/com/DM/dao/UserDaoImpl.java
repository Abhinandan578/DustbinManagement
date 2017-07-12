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
		public boolean isValidUser(int id, String password) throws SQLException {
		
				 //get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// Query
				Query<Users> theQuery = currentSession.createQuery("From Users u where u.id=:userid and u.passwordUser=:passwd ",Users.class);
				theQuery.setParameter("userid", id);
				theQuery.setParameter("passwd", password);
				List<Users> results=theQuery.getResultList();
				
				//Users user = (Users)results.get(0);
				if(results.size()!=1)
					return false;
				else
					return true;
	}

	@Override
	public List<Users> getCollectors() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Users> theQuery = currentSession.createQuery("From Users u where u.typeOfUser = 2",Users.class);
		
		List<Users> users = (List<Users>)theQuery.getResultList();
		
		return users;
		
	}

	@Override
	public List<Users> getCaretakers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Users> theQuery = currentSession.createQuery("From Users u where u.typeOfUser = 3",Users.class);
		
		List<Users> users = (List<Users>)theQuery.getResultList();
		
		
		return users;
	}

	@Override
	public void saveUser(Users theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theUser);
		
	}

	
	@Override
	public Users getUser(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now read from database using the primary key
		Users theUser = currentSession.get(Users.class, theId);

		return theUser;
	}


	@Override
	public void deleteUser(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Users where id=:userId");
		theQuery.setParameter("userId",theId );
		
		theQuery.executeUpdate();
	}

}
