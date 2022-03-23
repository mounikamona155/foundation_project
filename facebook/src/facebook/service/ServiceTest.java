package facebook.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;
import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public class ServiceTest {

	FacebookServiceInterface fs=null;
	@Before
	public void setUp() throws Exception {
		fs=new FacebookService();
	}

	@After
	public void tearDown() throws Exception {
		fs=null;
	}

	@Test
	public void testSignUpService() {
		System.out.println("SIGN-UP SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter dateOfBirth");
		String dateOfBirth=sc.next();
		
		FacebookUser fu=new FacebookUser();
		
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setDateOfBirth(dateOfBirth);
		int i=fs.signUpService(fu);
		assert(i>0) :"Test failed to sign-up";
	}

	@Test
	public void testSignInService() {
		System.out.println("SIGN-IN SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter name");
		String name=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter dateOfBirth");
		String dateOfBirth=sc.next();
		
		FacebookUser fu=new FacebookUser();
		
		fu.setName(name);
		fu.setPassword(password);
		
		FacebookUser user =fs.signInService(fu);
		assert user !=null :"Test failed to sign-in";
	}

	@Test
	public void testViewProfileService() {
		System.out.println("VIEWING PROFILE SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to view : ");
		String email=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		
		FacebookUser user =fs.viewProfileService(fu);
		assert user !=null :"Test failed to view profile";
	}

	@Test
	public void testDeleteProfileService() {
		System.out.println("DELETING PROFILE SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to delete : ");
		String email=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
		fu.setEmail(email);
		
		int i =fs.deleteProfileService(fu);
		assert (i>0) :"Test failed to delete profile";
	}

	

	@Test
	public void testEditProfileService() {
		System.out.println("EDITING PROFILE SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter email whose profile you wish to edit : ");
		String email=sc.next();
		
		System.out.println("Edit name: ");
		String name=sc.next();
		
		System.out.println("Edit password: ");
		String password=sc.next();
		
		System.out.println("Enter date Of Birth: ");
		String dateOfBirth=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookUser fu1=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setDateOfBirth(dateOfBirth);
		int i=fs.editProfileService(fu,fu1);
		assert(i>0) :"Test failed to Edit Profile";
	}

	@Test
	public void testSearchProfileService() {
		System.out.println("SEARCH PROFILE SERVICE TEST");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name whose profile you wish to search : ");
		String name=sc.next();
		System.out.println();
		
		FacebookUser fu=new FacebookUser();
		
		fu.setName(name);
		
		ArrayList<FacebookUser>lis =fs.searchProfileService(fu);
		assert lis!=null :"Test failed to search profile";
	}

	



}
