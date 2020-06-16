import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static utiles.Driver.*;

public class TestCase1 {
    public static WebDriver driver;


    @BeforeMethod
    public void setUp()
    {
        driver=getDriver("chrome");

    }




    @Test
    public void selectWeekDays() throws InterruptedException {
        Random n= new Random();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(2000);
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        Thread.sleep(1000);
        List<WebElement> labels = driver.findElements(By.xpath("//label"));
        Thread.sleep(1000);
        //System.out.println("Size of the list "+checkBoxes.size());



        Thread.sleep(1000);
        checkBoxes.get(1).click();
        Thread.sleep(1000);
       int count=0;
       while(count<=3)
        {
            int l=n.nextInt();

            if(labels.get(l).getText()=="Friday")
            {
                count++;
            }
            Thread.sleep(500);
            checkBoxes.get(l).click();
            Thread.sleep(500);
            System.out.println(labels.get(l).getText());
            Thread.sleep(500);
            checkBoxes.get(l).click();
            Thread.sleep(500);


        }
    }

    @AfterMethod
    public void terarDown()
    {
        closeDriver();
    }

}
