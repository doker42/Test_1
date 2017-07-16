package project.automation.chapter_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.automation.chapter_1.utils.logging.CustomReporter;

import java.util.List;
import java.util.Random;

public class GenActions {
    private WebDriver driver;
    private WebDriverWait wait;

    public void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public GenActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void openSite(){
        CustomReporter.log("Loging *** ");
        driver.navigate().to("https://www.lenovo.com/ua/ua/");
        sleep();
        WebElement buttonProduct = driver.findElement(By.xpath("(//li[1]/a/span)[1]"));
        buttonProduct.click();
        sleep();
        WebElement buttonNouts = driver.findElement(By.xpath("(//li[@class=\"product_menu opened\"]/div/ul[@class=' menu_2']/li)[1]"));
       buttonNouts.click();
       sleep();

       List<WebElement> blocks1 = driver.findElements(By.className("seriesPreview"));
        Random random = new Random(); //определяем номер случайного товара
        int productNumber = random.nextInt(blocks1.size());
        String [] nameProducts = new String[blocks1.size()]; //создание массива названий товаров
        int i = 0;
        for(WebElement name1: blocks1) {
            nameProducts[i] = name1.getText();
            i++;
        }
        String customProduct = nameProducts[productNumber]; //название случайно отобранного товара
        System.out.println("***************");
        System.out.println(customProduct);
        System.out.println("***************");

        WebElement buyProduct = driver.findElement(By.linkText(customProduct));
        buyProduct.click(); //кликаем купить товар

        sleep();

        List<WebElement> block2 = driver.findElements(By.xpath("//li[@class='seriesListings-itemContainer']"));
        Random random2 = new Random(); //определяем номер случайного товара
        int productNumber2 = random.nextInt(block2.size());
        String [] nameProducts2 = new String[block2.size()]; //создание массива названий товаров
        int j = 0;
        for(WebElement name2: block2) {
            nameProducts2[i] = name2.getText();
            j++;
        }
        String customProduct2 = nameProducts2[productNumber2]; //название случайно отобранного товара
        System.out.println("***************");
        System.out.println(customProduct2);
        System.out.println("***************");

        WebElement buyProduct2 = driver.findElement(By.linkText(customProduct2));
        buyProduct.click(); //кликаем купить товар

    }
}
