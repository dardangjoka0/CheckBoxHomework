import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static utiles.Driver.*;

public class TestCase1 {
    public static WebDriver driver;


    @BeforeMethod
    public void setUp()
    {

        driver=getDriver("chromeHeadless");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void selectWeekDays() throws InterruptedException {
        Random n= new Random();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::*"));

       int count=0,l=0;
       while(count<3)
        {
            l=n.nextInt(7);
           if(checkBoxes.get(l).isEnabled())
           {
             checkBoxes.get(l).click();
             System.out.println(labels.get(l).getText());
             checkBoxes.get(l).click();
             if(labels.get(l).getText().equals("Friday"))
                 count++;
          }

        }
    }

    @AfterMethod
    public void tareDown()
    {
        closeDriver();
    }

}
