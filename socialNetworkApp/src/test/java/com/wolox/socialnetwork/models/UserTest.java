package com.wolox.socialnetwork.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	
	private static final long ID = 1;
	private static final String NAME = "Matias";
	private static final String USERNAME = "torsello";
	private static final String EMAIL = "matiastorsello@gmail.com";
	private Address address = new Address();
	private static final String PHONE = "1121841312";
	private static final String WEBSITE = "www.matiastorsello.com";
	private Company company = new Company();
    private User user;
    
    @Before
    public void setUp() throws Exception {
    	user = new User(ID, NAME, USERNAME, EMAIL, address, PHONE, WEBSITE, company);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void testGetUsersDetails() throws Exception {
        Assert.assertEquals(ID, user.getId());
        Assert.assertEquals(NAME, user.getName());
        Assert.assertEquals(USERNAME, user.getUsername());
        Assert.assertEquals(EMAIL, user.getEmail());
        Assert.assertEquals(WEBSITE, user.getWebsite());
        Assert.assertEquals(address, user.getAddress());
        Assert.assertEquals(company, user.getCompany());
        Assert.assertEquals(PHONE, user.getPhone());
    }
    
    @Test
    public void testSetUsersDetails() throws Exception {
        user.setId(ID);
        user.setAddress(address);
        user.setName(NAME);
        user.setEmail(EMAIL);
        user.setCompany(company);
        user.setPhone(PHONE);
        user.setUsername(USERNAME);
        user.setWebsite(WEBSITE);
    }
}
