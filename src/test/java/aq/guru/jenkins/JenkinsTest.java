package aq.guru.jenkins;

import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class JenkinsTest extends TestBase{

    @Test
    void successfulTest() {

        step("Открытие формы регистрации", () -> {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        });

        step("Ввод имени", () -> {
        $("#firstName").setValue("Mihail");
        });

        step("Ввод фамилии", () -> {
        $("#lastName").setValue("Lubeznow");
        });

        step("Ввод e-mail", () -> {
        $("#userEmail").setValue("mihail@mail.ru");
        });

        step("Ввод телефона", () -> {
        $("#userNumber").setValue("1234567890");
        });

        step("Ввод адреса", () -> {
        $("#currentAddress").setValue("Miami");
        });

        step("Выбор пола", () -> {
        $(byText("Male")).click();
        });

        step("Выбор хобби", () -> {
        $(byText("Music")).click();
        });

        step("Выбор даты рождения", () -> {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2020")).click();
        $(byText("10")).click();
        });

        step("Загрузка файла", () -> {
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg"));
        });

        step("Ввод предмета", () -> {
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        });

        step("Выбор региона", () -> {
        $("#react-select-3-input").val("NCR").pressEnter();
        });

        step("Выбор города", () -> {
        $("#react-select-4-input").val("Noida").pressEnter();
        });

        step("Подтверждение данных", () -> {
        $("#submit").click();
        });

        step("Проверки", () -> {
        $(".modal-content").shouldHave(text("Mihail Lubeznow"),
                text("mihail@mail.ru"),
                text("Male"),
                text("1234567890"),
                text("10 April,2020"),
                text("Maths"),
                text("Music"),
                text("1.jpg"),
                text("Miami"),
                text("NCR Noida"));
        });
    }
}
