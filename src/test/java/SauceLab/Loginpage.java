package SauceLab;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.util;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Loginpage {
   public static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String str= driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
        String[] arr = str.split("\n");
        System.out.println(arr.length);
        System.out.println(arr[1]);
        for(int i=1;i< arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        testcase1(arr[1]);
        testcase2(arr[2]);
        testcase3(arr[3]);
        testcase4(arr[4]);
    }

    public static void testcase1(String username) throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys(username);
        String Pass=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String[] arr= Pass.split("\n");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Select Filter = new Select((driver.findElement(By.xpath ("//select[@class='product_sort_container']"))));
        Filter.selectByVisibleText("Name (A to Z)");
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        String[] ar=new String[list.size()];
        int i=0;
        for(WebElement k:list )
        {
          ar[i]=  k.getText();
          i++;
        }

        System.out.println("Is AtoZ filter working: "+util.AscAlphabettically(ar));

        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Select Filter1= new Select((driver.findElement(By.xpath ("//select[@class='product_sort_container']"))));
        Filter1.selectByVisibleText("Name (Z to A)");
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        String[] ar1=new String[list1.size()];
        int j=0;
        for(WebElement p:list1 )
        {
            ar1[j]=  p.getText();
            j++;
        }

        System.out.println("Is ZtoA filter working: "+util.DescAlphabettically(ar1));


        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Select Filter2 = new Select((driver.findElement(By.xpath ("//select[@class='product_sort_container']"))));
        Filter2.selectByVisibleText("Price (low to high)");
        List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double[] ar2=new double[list2.size()];

        int l=0;
        for(WebElement q:list2 )
        {
            String s=  q.getText().substring(1);
            ar2[l]= Double.parseDouble(s);
            l++;
        }

        System.out.println("Is low to high filter working: "+util.Ascno(ar2));


        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Select Filter3 = new Select((driver.findElement(By.xpath ("//select[@class='product_sort_container']"))));
        Filter3.selectByVisibleText("Price (high to low)");
        List<WebElement> list3 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Thread.sleep(5000);
        double[] ar3=new double[list3.size()];

        int m=0;
        for(WebElement d:list3 )
        {
            String s=  d.getText().substring(1);
            ar3[m]= Double.parseDouble(s);
            m++;
        }
        System.out.println("Is high to low filter working: "+util.descno(ar3));

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("snehal");
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("pimpal");
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("440001");
        driver.findElement(By.xpath("//input[@name='continue']")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebElement sc = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        System.out.println(sc.getText());
        Thread.sleep(5000);

//        BaseClass obj = new BaseClass();
//        obj.takeScreenshot(driver,"user1");
        BaseClass.takeScreenshot(driver,"user1");

        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

    }
    public static void testcase2(String username) throws IOException {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        String Pass=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String[] arr= Pass.split("\n");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        WebElement ab = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
        System.out.println(ab.getText());
//        BaseClass obj = new BaseClass();
//        obj.takeScreenshot(driver,"user2");
        BaseClass.takeScreenshot(driver,"user2");
        driver.findElement(By.xpath("//button[@class='error-button']")).click();


    }

    public static void testcase3(String username) throws IOException, InterruptedException {
        driver.findElement(By.xpath("//input[@id='user-name']")).clear();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        String Pass=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String[] arr= Pass.split("\n");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

//        BaseClass obj = new BaseClass();
//        obj.takeScreenshot(driver,"user3");
        BaseClass.takeScreenshot(driver,"user3");

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("xyze");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("uuuu");


        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("400000");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
//        BaseClass obj3 = new BaseClass();
//        obj3.takeScreenshot(driver,"user5");
        BaseClass.takeScreenshot(driver,"user5");

        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

    }
    public static void testcase4(String username) throws InterruptedException, IOException {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        String Pass=driver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String[] arr= Pass.split("\n");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(arr[1]);
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-onesie']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("aaaaa");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("bbbb");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("440044");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebElement sc = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        System.out.println(sc.getText());
        Thread.sleep(10000);

//        BaseClass obj4 = new BaseClass();
//        obj4.takeScreenshot(driver,"user6");
        BaseClass.takeScreenshot(driver,"user6");


    }





}
