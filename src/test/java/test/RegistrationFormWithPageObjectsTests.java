package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open ("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        new RegistrationPage().setFirstName("Andrey");
        new RegistrationPage().setLastName("Pugachev");
        new RegistrationPage().setEmail("andrey_zamer@mail.ru");
        $(byText("Male")).click();
        new RegistrationPage().setUserNumber("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("P");
        $(byText("Physics")).click();
        $(byText("Reading")).click();
        File home = new File("src/test/resources/home.jpg");
        $("#uploadPicture").scrollTo().uploadFile(home);
        new RegistrationPage().setcurrentAddress("Ufa");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        new RegistrationPage().checkForm("Andrey Pugachev");
        new RegistrationPage().checkForm("andrey_zamer@mail.ru");
        new RegistrationPage().checkForm("Male");
        new RegistrationPage().checkForm("1234567890");
        new RegistrationPage().checkForm("17 September,1993");
        new RegistrationPage().checkForm("Physics");
        new RegistrationPage().checkForm("Reading");
        new RegistrationPage().checkForm("home.jpg");
        new RegistrationPage().checkForm("Ufa");
        new RegistrationPage().checkForm("Haryana Karnal");

    }
}
