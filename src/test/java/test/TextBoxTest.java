package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open ("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Pugachev");
        $("#userEmail").setValue("andrey_zamer@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1993");
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("P");
        $(byText("Physics")).click();
        $(byText("Reading")).click();
        File home = new File("src/test/resources/home.jpg");
        $("#uploadPicture").scrollTo().uploadFile(home);
        $("#currentAddress").setValue("Ufa");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Andrey Pugachev"),
                text("andrey_zamer@mail.ru"),
                text("Male"),
                text("1234567890"),
                text("17 September,1993"),
                text("Physics"),
                text("Reading"),
                text("home.jpg"),
                text("Ufa"),
                text("Haryana Karnal"));

    }
}
