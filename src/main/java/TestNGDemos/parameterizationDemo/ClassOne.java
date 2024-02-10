package TestNGDemos.parameterizationDemo;

import org.testng.annotations.*;

public class ClassOne {

    @Parameters({"myUrl","username","password"})

    /*@BeforeSuite

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
    }*/

    @BeforeClass
    public void beforeMyClass(String url,String username,String password)
    {
        System.out.println("URL=" +url);
        System.out.println("userName=" +username);
        System.out.println("Password=" +password);

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
