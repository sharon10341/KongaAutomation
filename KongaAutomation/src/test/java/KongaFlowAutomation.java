import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaFlowAutomation {

    //import the selenium webdriver
    private WebDriver driver;


    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate the chromeDriver
        System.setProperty("WebDriver.chrome.driver", "resources/chromedriver.exe");

        //open my Chrome browser
        driver = new ChromeDriver();

        //Visit the Konga URL
        driver.get("https://www.konga.com/");
        //Test 1 Verify the user inputs the right url and it's on the right webpage
        if(driver.getCurrentUrl().contains("https://www.konga.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("Wrong webpage");

        //wait globally for the page to fully load
        Thread.sleep(5000);

        //maximize the browser
        driver.manage().window().maximize();
    }
        @Test(priority = 0)
         public void positivesignup() throws InterruptedException {
            //Verify that when user clicks on the login page, the user is directed to the login page

            //Click on Login button
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

            //wait a bit
            Thread.sleep(5000);

            //Locate the Email button and Enter Email address
            driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("mercyshan@exelica.com");

            //Locate the password button and Enter Password
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Sharon10341_");
            Thread.sleep(5000);

            //Click on sign in
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(10000);
    }
    @Test(priority = 1)
     public void clickcategorypage() throws InterruptedException {
        //Locate the category page and click on computer and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        //test if the categories url is correct
        String expectedpageurl = "https://www.konga.com/category/accessories-computing-5227";
        String actualpageurl = driver.getCurrentUrl();
        if(actualpageurl.contains(expectedpageurl));
            //pass
        else
            System.out.println("wrong categories page");

        Thread.sleep(5000);

        //Locate the Laptop subcategory and click on it
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);

        //Locate the Applemacbook and click on it
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        Thread.sleep(5000);

        //Add the Macbook you want to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[3]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void Gotocart() throws InterruptedException {
        //Go to my Cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 3)
    public void checkoutandpayment() throws InterruptedException {
        //Locate Checkout and click on it
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

        //Select How to getdelivery
        //driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[1]")).click();
        //Thread.sleep(5000);

        ////Select my already existing address
        //driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();

        //click on address
        //driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();

        //click on use this address
        //driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();

        //Click on Pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();

        //Locate and click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);

        //locate and choose card payment
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div/span[1]")).click();
        Thread.sleep(5000);

        //input invalid card details
        driver.findElement(By.xpath("//*[@id=\"card-number\"]")).sendKeys("123456789034");
        System.out.println("Invalid card details");
        Thread.sleep(5000);

        //Close the Card modal
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void CloseBrowser() {
            //Quit the Browser
            driver.quit();
        }















    }

