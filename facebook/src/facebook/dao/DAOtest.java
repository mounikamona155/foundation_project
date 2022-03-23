package facebook.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public class DAOtest {
	FacebookDAOInterface fd=null;

	@Before
	public void setUp() throws Exception {
		fd=new FacebookDAO();
	}

	@After
	public void tearDown() throws Exception {
		fd=null;
	}

	@Test
	public void testSignUpDAO() {
		System.out.println("SIGN-UP DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		FacebookUser fu=new FacebookUser();
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter your dateOfBirth");
		String dateOfBirth=sc.next();
		System.out.println("enter your gender :");
		String gender=sc.next();
		System.out.println();
		
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setDateOfBirth(dateOfBirth);
		fu.setGender(gender);
		int i=fd.signUpDAO(fu);
		assert(i>0) :"Test failed to sign-up";
	}

	@Test
	public void testSignInDAO() {
		System.out.println("SIGN-IN DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
	
		
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		fu.setPassword(password);
		
		FacebookUser user =fd.signInDAO(fu);
		assert user !=null :"Test failed to sign-in";
	}

	@Test
	public void testViewProfileDAO() {
		System.out.println("VIEWING PROFILE DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to view : ");
		String email=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		
		FacebookUser user =fd.viewProfileDAO(fu);
		assert user !=null :"Test failed to view profile";
	}

	@Test
	public void testDeleteProfileDAO() {
		System.out.println("DELETING PROFILE DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to delete : ");
		String email=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		
		int i =fd.deleteProfileDAO(fu);
		assert (i>0) :"Test failed to delete profile";
	}

	@Test
	public void testEditProfileDAO() {
		System.out.println("EDITING PROFILE DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to edit : ");
		String email=sc.next();
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		System.out.println("Edit name: ");
		String name=sc.next();
		
		System.out.println("Edit password: ");
		String password=sc.next();
		
		System.out.println("Enter date Of Birth: ");
		String dateOfBirth=sc.next();
		
		System.out.println("Enter gender : ");
		String gender=sc.next();
		
		
		FacebookUser fu1=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setDateOfBirth(dateOfBirth);
		fu.setGender(gender);
		int i=fd.editProfileDAO(fu,fu1);
		assert(i>0) :"Test failed to Edit Profile";
	}

	@Test
	public void testSearchProfileDAO() {
		System.out.println("SEARCH PROFILE DAO TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name whose profile you wish to search : ");
		String name=sc.next();
		System.out.println();
		
		FacebookUser fu=new FacebookUser();
		
		fu.setName(name);
		
		ArrayList<FacebookUser>lis =fd.searchProfileDAO(fu);
		assert lis!=null :"Test failed to search profile";
	}

	
}
