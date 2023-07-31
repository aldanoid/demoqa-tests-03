package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        //Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Drago");
        $("#userEmail").setValue("ivan@drago.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1113212155");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day.react-datepicker__day--001").click();

        $("#subjectsInput").setValue("Test").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/01.jpg"));
        $("#currentAddress").setValue("Rio 1135");

        $("#state").setValue("Rajasthan");
        $("#city").setValue("Jaipur");

        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#react-select-3-option-2").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Ivan Drago"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("ivan@drago.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("1113212155"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("01 April,1985"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Test"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("01.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Rio 1135"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Rajasthan Jaipur"));

    }
}
