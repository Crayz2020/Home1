package test;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {
        //Ввод данных
        registrationPage
                        .OpenPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setUserNumber(userNumber)
                        .setGender()
                        .setBirthDate("17" ,"September" ,"1993")
                        .setSubjects(subject)
                        .setHobbies()
                        .uploadFile()
                        .setcurrentAddress(currentAddress)
                        .selectState(state)
                        .selectCity(city)
                        .checkResoults()




                // Проверка формы
                .modalHeader()
                .checkForm(firstName + " " + lastName)
                .checkForm(email)
                .checkForm(gender)
                .checkForm(userNumber)
                .checkForm("17 September,1993")
                .checkForm(subject)
                .checkForm(hobby)
                .checkForm("home.jpg")
                .checkForm(currentAddress)
                .checkForm(state + " " + city);

    }
}
