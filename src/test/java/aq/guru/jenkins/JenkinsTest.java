package aq.guru.jenkins;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JenkinsTest extends TestBase{

    @Test
    void successfulTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //шаги
        $("#firstName").setValue("Mihail");
        $("#lastName").setValue("Lubeznow");
        $("#userEmail").setValue("mihail@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("Miami");
        $(byText("Male")).click(); // чекбокс
        $(byText("Music")).click(); // чекбокс
        //(календарь)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2020")).click();
        $(byText("10")).click();
        //(календарь)
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.jpg")); // загрузка файла
        $("#subjectsInput").setValue("Maths").pressEnter();
        //$(byText("Maths")).pressEnter();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#react-select-4-input").val("Noida").pressEnter();
        $("#submit").click();

        //проверки
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
    }
}
