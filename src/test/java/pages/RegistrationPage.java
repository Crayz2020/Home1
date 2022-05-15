package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.Components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.TestData.*;

public class RegistrationPage {

    //Components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    SelenideElement headerTitle = $(".main-header"),
                    firstnameInput = $("#firstName"),
                    lastnameInput = $("#lastName"),
                    emailInput = $("#userEmail"),
                    usernumberInput = $("#userNumber"),
                    currentAddressInput = $("#currentAddress"),
                    resultsTable = $(".table-responsive");


    // actions
    @Step ("Open Page")
    public RegistrationPage OpenPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }

    @Step ("Set Firstname")
    public RegistrationPage setFirstName(String firstName) {
        firstnameInput.setValue(firstName);

        return this;

    }

    @Step ("Set Lastname")
    public RegistrationPage setLastName(String lastName) {
        lastnameInput.setValue(lastName);

        return this;

    }

    @Step ("Set Email")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;


    }

    @Step ("Set User Number")
    public RegistrationPage setUserNumber(String usernumber) {
        usernumberInput.setValue(usernumber);

        return this;

    }

    @Step ("Set Address")
    public RegistrationPage setcurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;


    }

    public RegistrationPage checkForm(String value) {
        resultsTable.shouldHave(text(value));

        return this;

    }

    @Step ("Set Birthday")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    @Step ("Set Gender")
    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();

        return this;

    }

    @Step ("Set Subjects")
    public RegistrationPage setSubjects(String subject) {
        $("#subjectsInput").setValue(subjectInput);
        $(byText(subject)).click();

        return this;

    }

    @Step ("Set Hobbies")
    public RegistrationPage setHobbies(String hobby) {
        $(byText(hobby)).click();

        return this;

    }

    @Step ("Set Upload File")
    public RegistrationPage uploadFile(String file) {
        File home = new File("src/test/resources/home.jpg");
        $("#uploadPicture").scrollTo().uploadFile(home);

        return this;

    }

    @Step ("Select State")
    public RegistrationPage selectState(String state) {
        $("#state").click();
        $(byText(state)).click();

        return this;

    }

    @Step ("Select City")
    public RegistrationPage selectCity(String city) {
        $("#city").click();
        $(byText(city)).click();

        return this;

    }

    @Step ("Submit")
    public RegistrationPage checkResoults() {
        $("#submit").scrollTo().pressEnter();

        return this;

    }

    public RegistrationPage modalHeader() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        return this;
    }
}
