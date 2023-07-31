package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $("#genterWrapper").setValue("Male").pressEnter();
        $("#userNumber").setValue("1113212155");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day.react-datepicker__day--001").click();

        $("#subjectsContainer").setValue("Physics").pressEnter();

        $("#hobbiesWrapper#hobbies-checkbox-3").click();

        $("#uploadPicture").setValue("");
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpeg"));
        $("#currentAddress").setValue("Rio 1135");
        $("#state").setValue("Rajasthan");
        $("#city").setValue("Jaipur");
        $("#submit").click();

        $("[class=modal-dialog]").$("[class=table-striped]");
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
