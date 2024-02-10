package TestNGDemos.Demo1;

import org.testng.annotations.*;

public class ClassOne {

    @BeforeSuite

    public void beforeMysuite()
    {
        System.out.println("Before My Suite");
    }

    @AfterSuite

    public void afterMySuite()
    {
        System.out.println("After My Suite");
    }

    @BeforeTest

    public void beforeMytest()
    {
        System.out.println("Before My test method");
    }

    @AfterTest

    public void afterMytest()
    {
        System.out.println("After My test method");
    }

    @Test
    public void classOneTest1()
    {
        System.out.println("classOneTest1");
    }

    @Test
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }

    @Test
    public void classOneTest3()
    {
        System.out.println("classOneTest3");
    }


}
