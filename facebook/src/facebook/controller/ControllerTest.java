package facebook.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import facebook.entity.FacebookUser;



public class ControllerTest {
	FacebookControllerInterface fc=null;
	@Before
	public void setUp() throws Exception {
		fc=new FacebookController();
	}

	@After
	public void tearDown() throws Exception {
		fc=null;
	}

	@Test
	public void testSignUp() {
		int i=fc.signUp();
		assert i>0: "Test failed to create profile";
	}

	
	@Test
	public void testViewProfileController() {
		FacebookUser user=fc.viewProfileController();
		assert user!=null: "Test failed to view profile";
	}

	@Test
	public void testDeleteProfileController() {
		int i=fc.deleteProfileController();
		assert i>0: "Test failed to delete profile";
	}

	

	@Test
	public void testEditProfileController() {
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to edit : ");
		String email=s.next();
		int i=fc.editProfileController();
		assert i>0: "Test failed to edit profile";
		
	}

	@Test
	public void testSearchProfileController() {
		ArrayList<FacebookUser>lis=fc.searchProfileController();
		assert lis!=null: "Test failed to search profiles:";
		
	}

	@Test
	public void testSortProfileController() {
		ArrayList<FacebookUser>lis=fc.sortProfileController();
		assert lis!=null: "Test failed to search profiles:";
	}

	
}
