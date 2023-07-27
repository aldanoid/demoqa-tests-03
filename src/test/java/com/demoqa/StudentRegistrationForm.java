package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("/automation-practice-form");

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

        $("#output #name").shouldHave(text(""));
        $("#output #email").shouldHave(text(""));
        $("#output #currentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
        $("#output #permanentAddress").shouldHave(text(""));
    }
}
