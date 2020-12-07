import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Homework {
    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @Test
    public void createTest() {
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = "https://moodpanda.com/";
        Configuration.browser = "chrome";

        open("/");

        $(By.xpath("//a[@href='/Login/']")).shouldHave(text("Login")).click();
        $(By.id("ContentPlaceHolderContent_HyperLinkRegister")).click();
        $(By.id("ContentPlaceHolderContent_TextBoxFirstName")).setValue("Olka");
        $(By.id("ContentPlaceHolderContent_TextBoxSurname")).setValue("Y");
        $(By.id("ContentPlaceHolderContent_DropDownListYearOfBirth")).click();
        $(By.xpath("//*[@value='2000']")).click();
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxEmail']")).setValue("yuks10@gmail.com");
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxPassword']")).setValue("123123");
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxPasswordConfirm']")).setValue("123123");
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$ButtonLogin']")).click();
    }

    @Test
    public void loginTest(){
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = "https://moodpanda.com/";
        Configuration.browser = "chrome";

        open("/");

        $(By.xpath("//a[@href='/Login/']")).shouldHave(text("Login")).click();
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxEmail']")).setValue("yuks10@gmail.com");
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$TextBoxPassword']")).setValue("123123");
        $(By.xpath("//*[@name='ctl00$ContentPlaceHolderContent$ButtonLogin']")).click();


    }
    @Test
    public void updateMood(){
        org.apache.log4j.BasicConfigurator.configure();
        Configuration.baseUrl = "https://moodpanda.com/Feed/";
        Configuration.browser = "chrome";

        open("/");

        $(By.className("navbar-hidesmalla")).click();
        $(By.id("TextBoxUpdateMoodTag")).setValue("No reason given");
        $(By.xpath("//*[@class='btn btn-sm btn-primary ButtonUpdate']")).click();
    }
}
