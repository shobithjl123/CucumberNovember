package TestNGDemos.Demo3;

import org.testng.annotations.Test;

public class ClassThree {

    @Test
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
    }

    @Test
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Test(groups = "email")
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }

}
