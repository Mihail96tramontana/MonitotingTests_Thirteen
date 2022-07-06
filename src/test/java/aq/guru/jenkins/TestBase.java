package aq.guru.jenkins;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void testAllureScenariy() {

        Configuration.baseUrl = "https://demoqa.com"; //скрипты для разрешения окна браузер
        Configuration.browserSize = "1920x1080";

        SelenideLogger.addListener("allure", new AllureSelenide()); //скрипт для древовидной структуры шагов в Allure Report

        Configuration.remote = System.getProperty("url"); //скрипт для удалённого запуска на Selenoid
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //скрипт для удалённого запуска на Selenoid

        //скрипты для Selenoid с ключами
        DesiredCapabilities capabilities = new DesiredCapabilities(); //задали объект
        capabilities.setCapability("enableVNC", true); //свойство с ключом для передачи видео в формате VNC
        capabilities.setCapability("enableVideo", true); //свойство для записи видео
        Configuration.browserCapabilities = capabilities;
        }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}