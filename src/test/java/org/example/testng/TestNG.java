package org.example.testng;

import org.testng.annotations.*;

public class TestNG {
    @BeforeSuite
    public void beforesuite()
    {
        System.out.println("I am in beforesuite method");
    }
    @AfterSuite
    public void aftersuite()
    {
        System.out.println("I am in aftersuite  method");
    }
    @BeforeMethod
    public void beforemethod()
    {
        System.out.println("I am in beforemethod method");
    }
    @BeforeClass
    public void beforeclass()
    {
        System.out.println("I am in beforeclass method");
    }
    @AfterMethod
    public void aftermethod()
    {
        System.out.println("I am in aftermethod method");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("I am in afterclass method");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("I am in beforetest method");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("I am in aftertest method");
    }
    @Test
    public void dtest()
    {
        System.out.println("I am in d method");
    }
    @Test(priority = -1)
    public void cTest2()
    {
        System.out.println("I am in c method");
    }
    @Test(priority = 1)
    public void bTest2()
    {
        System.out.println("I am in b method");
    }
    @Test(priority = 2)
    public void aTest()
    {
        System.out.println("I am in a method");
    }


}
