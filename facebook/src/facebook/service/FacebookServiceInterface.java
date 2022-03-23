package facebook.service;

import java.util.ArrayList;

import facebook.entity.FacebookTimeline;
import facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int signUpService(FacebookUser fu);

	FacebookUser signInService(FacebookUser fu);

	FacebookUser viewProfileService(FacebookUser fu);

	int deleteProfileService(FacebookUser su);

	ArrayList<FacebookUser> viewAllProfileService(FacebookUser fu);

	int editProfileService(FacebookUser fu, FacebookUser fu1);

	ArrayList<FacebookUser> searchProfileService(FacebookUser fu);

	ArrayList<FacebookUser> sortProfileService();

	


	

	

	

	

	

	

	

	

	

	

	



	

	

	



}
