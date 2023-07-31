package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
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

        $("#uploadPicture").setValue("");
        $("#uploadPicture").uploadFromClasspath("01.jpg");
        $("#currentAddress").setValue("Rio 1135");

        $("#state").setValue("Rajasthan");
        $("#city").setValue("Jaipur");

        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#react-select-3-option-2").click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        //$("[class=modal-dialog]").$("[class=table-striped]");
        //$("#output #email").shouldHave(text(""));
        //$("#output #currentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #permanentAddress").shouldHave(text(""));
        //$("#output #stateCity-wrapper").shouldHave(text(""));

    }
}
