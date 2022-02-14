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
    String  FirstName = "Andrey",
            LastName = "Pugachev",
            Email = "Andrey_zamer@mail.ru",
            UserNumber = "1234567890",
            currentAddress = "Ufa",
            Gender = "Male",
            Subject = "Physics",
            Hobby = "Reading",
            State = "Haryana",
            City = "Karnal";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        //Ввод данных
        registrationPage
                        .OpenPage()
                        .setFirstName(FirstName)
                        .setLastName(LastName)
                        .setEmail(Email)
                        .setUserNumber(UserNumber)
                        .setGender()
                        .setBirthDate("17" ,"September" ,"1993")
                        .setSubjects(Subject)
                        .setHobbies()
                        .uploadFile()
                        .setcurrentAddress(currentAddress)
                        .selectState(State)
                        .selectCity(City)
                        .checkResoults()




                // Проверка формы
                .modalHeader()
                .checkForm(FirstName + " " + LastName)
                .checkForm(Email)
                .checkForm(Gender)
                .checkForm(UserNumber)
                .checkForm("17 September,1993")
                .checkForm(Subject)
                .checkForm(Hobby)
                .checkForm("home.jpg")
                .checkForm(currentAddress)
                .checkForm(State + " " + City);

    }
}
