package tests;

import model.Account;
import java.util.Date;

public class AccountTest {

	@SuppressWarnings("deprecation")
	public static void testConstructor() {
		String test_account_number = "5495-1234";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Standard";
		Date test_account_opening_date = new Date(2002, 04, 22);
		
		Account testAccount = new Account("5495-1234", "mike", "Standard", new Date(2002, 04, 22));
		
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		System.out.println("All Java assertations in the test suite for testConstructor pass (none failed).");
	}
	
	public static void testSetters() {
		Account testAccount = new Account("5495-1234", "mike", "Standard", new Date(2002, 04, 22));
		
		testAccount.setAccount_number("1234-5678");
		testAccount.setUsername_of_account_holder("joey");
		testAccount.setAccount_type("Savings");
		testAccount.setAccount_opening_date(new Date(1987, 11, 13));
		
		assert testAccount.getAccount_number() == "1234-5678";
		assert testAccount.getUsername_of_account_holder() == "joey";
		assert testAccount.getAccount_type() == "Savings";
		assert testAccount.getAccount_opening_date() == new Date(1987, 11, 13);
		
		System.out.println("All Java assertations in the test suite for testSetters pass (none failed).");
	}
	
	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}

}
