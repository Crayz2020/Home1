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
    RegistrationPage registrationPage = new RegistrationPage();
    String FirstName = "Andrey";
    String LastName = "Pugachev";
    String Email = "Andrey_zamer@mail.ru";
    String UserNumber = "1234567890";
    String currentAddress = "Ufa";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.OpenPage()
                        .setFirstName(FirstName)
                        .setLastName(LastName)
                        .setEmail(Email)
                        .setUserNumber(UserNumber);
        $(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("P");
        $(byText("Physics")).click();
        $(byText("Reading")).click();
        File home = new File("src/test/resources/home.jpg");
        $("#uploadPicture").scrollTo().uploadFile(home);
        registrationPage.setcurrentAddress(currentAddress);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkForm(FirstName + " " + LastName)
                .checkForm(Email)
                .checkForm("Male")
                .checkForm(UserNumber)
                .checkForm("17 September,1993")
                .checkForm("Physics")
                .checkForm("Reading")
                .checkForm("home.jpg")
                .checkForm(currentAddress)
                .checkForm("Haryana Karnal");

    }
}
