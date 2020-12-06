import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FirstTest {

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @Test
    public void userCanLogin() {
        // настройка log4j
        org.apache.log4j.BasicConfigurator.configure();
        //настроить Selenide
        Configuration.baseUrl = "https://aqa0703.testrail.io/";
        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
//        Configuration.fastSetValue = true;
//        Configuration.headless = true;
        //написать тест

        open("/");
        // Find element
        $(By.id("name")).setValue("atrostyanko+072@gmail.com");
        $(By.id("password")).setValue("w3n1bU7F4rxOfnfvrBJL");
        $(By.id("button_primary")).submit();

        $(".page_title").shouldBe(visible);
        $(".page_title").shouldHave(text("All Projects"));
        open("/index.php?/admin/projects/overview");

        // Find elements
        $$(By.className("hoverSensitive")).shouldHaveSize(71).find(text("WP_001")).find(By.tagName("a")).click();
        $("#announcement")
                .should(exist).shouldBe(visible).shouldHave(exactText("This is the description for the project"));


    }
}
