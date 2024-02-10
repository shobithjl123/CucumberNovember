package TestNGDemos.parameterizationDemo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {

    @Parameters({"myUrl","username","password"})

    @BeforeClass
    public void beforeMyClass(String url,String username,String password)
    {
        System.out.println("URL=" +url);
        System.out.println("Username=" +username);
        System.out.println("Password=" +password);

    }


    @Test
    public void classTwoTest1()
    {
        System.out.println("classTwoTest1");
    }

    @Test
    public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }

    @Test
    public void classTwoTest3()
    {
        System.out.println("classTwoTest3");
    }
}
