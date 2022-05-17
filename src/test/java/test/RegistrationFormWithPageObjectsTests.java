package test;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static test.TestData.*;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    public void successFillTest() {
        Allure.parameter("Регион", "Республика Башкортостан");
        Allure.parameter("Город", "Уфа");

        //Ввод данных

        registrationPage
                .OpenPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(userNumber)
                .setEmail(email)
                .setGender(gender)
                .setBirthDate("17", "September", "1993")
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadFile(file)
                .setcurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .checkResoults();


        step ("Check Results", () -> registrationPage
                    // Проверка формы
                    .modalHeader()
                    .checkForm(firstName + " " + lastName)
                    .checkForm(email)
                    .checkForm(gender)
                    .checkForm(userNumber)
                    .checkForm(birthDate)
                    .checkForm(subject)
                    .checkForm(hobby)
                    .checkForm(file)
                    .checkForm(currentAddress)
                    .checkForm(state + " " + city));


        }
    }