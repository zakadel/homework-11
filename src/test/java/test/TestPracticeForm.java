package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.RegistrationForm;

import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm extends BaseTest {

    final String firstName = "Adel";
    final String lastName = "Zakiev";
    final String email = "zakievadel1994@yandex.ru";
    final String gender = "Male";
    final String mobile = "9082787177";
    final String birthDateDay = "18";
    final String birthDateMouth = "March";
    final String birthDateYear = "1994";
    final String birthDate = this.birthDateDay + " " + this.birthDateMouth + "," + this.birthDateYear;
    final String subjects = "Computer Science";
    final String[] hobbies = {"Sports", "Reading"};
    final String address = "Kazan";
    final String state = "NCR";
    final String city = "Delhi";
    final RegistrationForm registrationForm = new RegistrationForm();

    @Feature("Проверка DemoQa")
    @Story("Проверка заполнения /automation-practice-form")
    @DisplayName("Automation-practice-form")
    @Owner("Zakiev A.R.")
    @Test
    void testForm() {
        Step1OpenUrl();
        Step2FillFormRegistrations();
        Step3DataCheck();
    }

    @Step("Открыть страницу")
    void Step1OpenUrl() {
        open("/automation-practice-form");
    }

    @Step("Заполнение формы регистрации")
    void Step2FillFormRegistrations() {
        registrationForm
                .firstNameInput(firstName)
                .lastName(lastName)
                .userEmail(email)
                .gender(gender)
                .mobile(mobile)
                .birthDate(birthDateYear, birthDateMouth, birthDateDay)
                .subjects(subjects)
                .hobbies(hobbies)
                .address(address)
                .state(state)
                .city(city)
                .submitForm();
    }

    @Step("Проверка данных")
    void Step3DataCheck() {
        registrationForm
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", email)
                .checkResultInModal("Gender", gender)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Date of Birth", birthDate)
                .checkResultInModal("Mobile", mobile)
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", String.join(", ", hobbies))
                .checkResultInModal("Address", address)
                .checkResultInModal("State and City", state + " " + city);
    }
}
