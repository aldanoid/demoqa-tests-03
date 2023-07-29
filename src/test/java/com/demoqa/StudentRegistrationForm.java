package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Drago");
        $("#userEmail").setValue("ivan@drago.com");
        $("#genterWrapper").setValue("#gender-radio-1");
        $("#userNumber").setValue("1113212155");
        $("#dateOfBirthInput").setValue("01 Jan 2000");
        $("#subjectsContainer").setValue("");
        $("#hobbiesWrapper").setValue("#hobbies-checkbox-3");
        $("#uploadPicture").setValue("");
        $("#currentAddress").setValue("Rio 1135");
        $("#state").setValue("Rajasthan");
        $("#city").setValue("Jaipur");
        $("#submit").click();

        $("[class=modal-dialog]").$( cssSelector:()).shouldHave(text("Ivan Drago"));
        $("#output #email").shouldHave(text(""));
        $("#output #currentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #stateCity-wrapper").shouldHave(text(""));

    }
}
