package pageObject;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.ResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm {

    final private CalendarComponent calendarComponent = new CalendarComponent();
    final private ResultModal resultModal = new ResultModal();

    final private SelenideElement firstNameInput = $("#firstName");
    final private SelenideElement lastNameInput = $("#lastName");
    final private SelenideElement emailInput = $("#userEmail");
    final private SelenideElement gender = $(".practice-form-wrapper #genterWrapper");
    final private SelenideElement mobileInput = $("#userNumber");
    final private SelenideElement birthDateInput = $("#dateOfBirthInput");
    final private SelenideElement subjectsInput = $("#subjectsInput");
    final private SelenideElement hobbiesInput = $(".practice-form-wrapper #hobbiesWrapper");
    final private SelenideElement addressInput = $("#currentAddress");
    final private SelenideElement stateInput = $("#state");
    final private SelenideElement cityInput = $("#city");
    final private SelenideElement submitButton = $("#submit");

    public RegistrationForm firstNameInput(String firstNameInput) {
        this
                .firstNameInput
                .setValue(firstNameInput);
        return this;
    }

    public RegistrationForm lastName(String lastName) {
        this
                .lastNameInput
                .setValue(lastName);
        return this;
    }

    public RegistrationForm userEmail(String email) {
        this
                .emailInput
                .setValue(email);
        return this;
    }

    public RegistrationForm gender(String gender) {
        this
                .gender
                .$(byText(gender))
                .click();
        return this;
    }

    public RegistrationForm mobile(String mobile) {
        this
                .mobileInput
                .setValue(mobile);
        return this;
    }

    public RegistrationForm birthDate(String year, String mouth, String day) {
        birthDateInput
                .click();
        calendarComponent
                .setDate(year, mouth, day);
        return this;
    }

    public RegistrationForm subjects(String subjects) {
        subjectsInput
                .setValue(subjects)
                .pressEnter();
        return this;
    }

    public RegistrationForm hobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            hobbiesInput
                    .$(byText(hobby))
                    .click();
        }
        return this;
    }

    public RegistrationForm address(String address) {
        addressInput
                .setValue(address);

        return this;
    }

    public RegistrationForm state(String state) {
        $(stateInput)
                .click();
        $(byText(state))
                .click();
        return this;
    }

    public RegistrationForm city(String city) {
        $(cityInput)
                .click();
        $(byText(city))
                .click();
        return this;
    }

    public RegistrationForm submitForm() {
        submitButton
                .click();
        return this;
    }

    public RegistrationForm checkResultInModal(String label, String value) {
        resultModal.checkTableRow(label, value);
        return this;
    }
}
