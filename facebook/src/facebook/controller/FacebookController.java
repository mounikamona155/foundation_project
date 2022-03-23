
package facebook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;
import facebook.service.FacebookServiceInterface;
import facebook.service.ServiceFactory;
import facebook.utility.SortByName;


public  class FacebookController implements FacebookControllerInterface {
	
	FacebookServiceInterface fs=null;
	Scanner sc=null;
	Logger log =Logger.getLogger("FacebookController");
	
	
	public FacebookController() {
		sc=new Scanner(System.in);
		fs= ServiceFactory.createObject();
	}
	
	@Override
	public int signUp() {
		System.out.println("profile is signing-up: ");
		
		
		
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter dateOfBirth");
		String dateOfBirth = sc.next();
		System.out.println("Enter gender");
		String gender = sc.next();
		System.out.println("Enter address");
		String address = sc.next();
		System.out.println();
		
		
		
		
		FacebookUser fu =new FacebookUser();
		
		
	    fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setDateOfBirth(dateOfBirth);
		fu.setGender(gender);
		
		
		int i = fs.signUpService(fu);
		
		if(i>0) {
			System.out.println("Profile Created");
			System.out.println();
		}
		else {
			System.out.println("could not create profile");
		}
		return i;
		
		
	}
	
	
	
	@Override
	public FacebookUser signIn() {
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String password= sc.next();
		
		FacebookUser fu = new FacebookUser();
		
		fu.setEmail(email);
		fu.setPassword(password);
		
		
		FacebookUser user=fs.signInService(fu);
		
		return user;
		
		

	}

	
	

	
	/*public int createProfileController() {
		
	/*	
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter name");
			String name=sc.next();
			
			System.out.println("enter password");
			String password=sc.next();
			
			System.out.println("enter email");
			String email=sc.next();
			
			System.out.println("enter address");
			String address=sc.next();
			
			FacebookUser fu=new FacebookUser();
			
			fu.setName(name);
			fu.setPassword(password);
			fu.setEmail(email);
			fu.setAddress(address);
			
			FacebookServiceInterface fs=new FacebookService();
			
			int i=fs.createProfileService(fu);
			if (i>0) {
				System.out.println("your profile is created mr/mr's" +name);
			}
			else {
				System.out.println("could not create your profile");
			}
			return i;
			
			 

		}
		*/
	
	

	@Override
	public FacebookUser viewProfileController() {
		
		
		
		System.out.println(" profile is viewing: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email whose profile you wish to view: ");
		String email=sc.next();
		
		
		FacebookUser fu=new FacebookUser();
		
	    fu.setEmail(email);
		
	    FacebookUser user=fs.viewProfileService(fu);
		if (user!=null) {
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("Date of birth is "+user.getDateOfBirth());
			System.out.println("Gender is "+user.getGender());
			
		}
		else {
			System.out.println("profile not found");
			System.out.println();
		}
		return user;
		
		
		
	}
	
			

	@Override
	public int deleteProfileController() {
		
		System.out.println(" profile is deleting: ");
		
		
		
		System.out.println("Enter Email whose profile you wish to delete: ");
		String email=sc.next();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		
		 int i=fs.deleteProfileService(fu);
		 
		 if(i>0) {
				
				System.out.println("profile is deleted ");
				System.out.println();
			}
			else {
				
				System.out.println("could not delete profile");
				System.out.println();
			}
		return i;

	}

	@Override
	public ArrayList<FacebookUser> viewAllProfileController() {
		System.out.println("viewAll Profiles: " + "\n");
		
		ArrayList<FacebookUser>lis=new ArrayList<FacebookUser>();
		
		FacebookUser fu=new FacebookUser();
		lis=fs.viewAllProfileService(fu);
		
		
		
	
		if(lis!=null) {
			System.out.println("Profiles in Sorted Order");
			for(FacebookUser user:lis) {
			System.out.println("*******************");
			System.out.println("Name is "+ user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("DateOfBirth is "+user.getDateOfBirth());
			System.out.println("Gender is "+user.getGender());
			
		}
		
			
		
		}
		  System.out.println();
		return lis;
	

	}


	@Override
	public int editProfileController() {
		
		System.out.println("editing the profile: ");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Email whose profile you wish to edit:");
		String email=sc.next();
		
		System.out.println("Edit name:");
		String name=sc.next();
		
		System.out.println("Edit password:");
		String password=sc.next();
	
		
		System.out.println("Edit  dateOfBirth");
		String dateOfBirth=sc.next();
		
        FacebookUser fu=new FacebookUser();
			fu.setEmail(email);
		
		FacebookUser fu1=new FacebookUser();
		fu1.setName(name);
		fu1.setPassword(password);
		fu1.setDateOfBirth(dateOfBirth);
		
		
		int i=fs.editProfileService(fu,fu1);
		
		if (i>0) {
			
			   System.out.println("profile  edited ");
			   System.out.println();
		         }
		
		else {
			
			  System.out.println("could not edit profile");
		      }
		return i;
	}
	


	@Override
	public ArrayList<FacebookUser> searchProfileController() {

		System.out.println("searching the profile:");
				Scanner sc=new Scanner(System.in);
				
				System.out.println("Enter a name  whose profile you wish to search:");
				String name=sc.next();
				
	            FacebookUser fu=new FacebookUser();
				
				 fu.setName(name);
					
				ArrayList<FacebookUser> lis=fs.searchProfileService(fu);
					
				
					if(lis!=null) {
						for(FacebookUser user:lis) {
							System.out.println("Name is"+user.getName());
							System.out.println("Password is"+user.getPassword());
							System.out.println("Email is"+user.getEmail());
							System.out.println("DateOfBirth is"+user.getDateOfBirth());
							System.out.println("Gender is"+user.getGender());
							
						}				
					}
					else {
						
						System.out.println("No profiles found with the given name");
						System.out.println();
					}
					return lis;
	}
					



	@Override
	public ArrayList<FacebookUser> sortProfileController() {
	
		System.out.println("sorting the profile: ");
		ArrayList<FacebookUser>lis=new ArrayList<FacebookUser>();
		
		
		
		lis=fs.sortProfileService();
		if(lis.size()>0) {
		Collections.sort(lis, new SortByName());
		
		
		for(FacebookUser user: lis) {
			System.out.println("......................");
			System.out.println("Name is "+user.getName());
			System.out.println("Password is "+user.getPassword());
			System.out.println("Email is "+user.getEmail());
			System.out.println("DateOfBirth is "+user.getDateOfBirth());
			System.out.println();
				
		}
		}
		else {
			System.out.println("no record found");
		}
		return lis;
	}

	

		
		
		
		
	}

	

	
	
	


	
