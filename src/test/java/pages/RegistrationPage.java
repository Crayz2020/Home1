package pages;

import com.codeborne.selenide.SelenideElement;
import pages.Components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //Components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    SelenideElement
            headerTitle = $(".main-header"),
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            usernumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage OpenPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstnameInput.setValue(firstName);

        return this;

    }

    public RegistrationPage setLastName(String lastName) {
        lastnameInput.setValue(lastName);

        return this;

    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;


    }

    public RegistrationPage setUserNumber(String usernumber) {
        usernumberInput.setValue(usernumber);

        return this;

    }

    public RegistrationPage setcurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;


    }

    public RegistrationPage checkForm(String value) {
        resultsTable.shouldHave(text(value));

        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPage setGender() {
        $(byText("Male")).click();

        return this;

    }

    public RegistrationPage setSubjects(String hobby) {
        $("#subjectsInput").setValue("P");
        $(byText("Physics")).click();

        return this;

    }

    public RegistrationPage setHobbies() {
        $(byText("Reading")).click();

        return this;

    }

    public RegistrationPage uploadFile() {
        File home = new File("src/test/resources/home.jpg");
        $("#uploadPicture").scrollTo().uploadFile(home);

        return this;

    }

    public RegistrationPage selectState(String State) {
        $("#state").click();
        $(byText("Haryana")).click();

        return this;

    }

    public RegistrationPage selectCity(String City) {
        $("#city").click();
        $(byText("Karnal")).click();

        return this;

    }

    public RegistrationPage checkResoults() {
        $("#submit").click();

        return this;

    }

    public RegistrationPage modalHeader() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        return this;
    }
}
