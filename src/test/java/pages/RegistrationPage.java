package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.FormResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            photoUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitForm = $("#submit"),
            closeModal = $("#closeLargeModal"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            stateInput = $("#state"),
            cityInput = $("#city");

    public CalendarComponent calendar = new CalendarComponent();
    public FormResultComponent formResult = new FormResultComponent();

    @Step("Открываем страницу с веб-формой")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        String FORM_TITLE = "Student Registration Form";
        formTitle.shouldHave(text(FORM_TITLE));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Заполняем поле Имя")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем поле Фамилия")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем поле Электронный адрес")
    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage makeGenderChoice(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    @Step("Заполняем поле Телефон")
    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    @Step("Заполняем поле Дата рождения")
    public RegistrationPage typeDateOfBirth(String day, String mouth, String year){
        dateOfBirthInput.click();
        calendar.setDate(day, mouth, year);

        return this;
    }

    @Step("Выбираем учебный предмет")
    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем хобби")
    public RegistrationPage typeHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем картинку")
    public RegistrationPage uploadImage(String value) {
        photoUpload.uploadFromClasspath(value);

        return this;
    }

    @Step("Заполняем поле Адрес")
    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    @Step("Выбираем Штат и Город")
    public RegistrationPage typeStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    @Step("Отправляем заполненную форму")
    public RegistrationPage submitRegistration() {
        submitForm.click();

        return this;
    }

    @Step("Проверяем заголовок нв окне проверки введенных данных")
    public RegistrationPage checkModalTitle(String value) {
        modalTitle.shouldHave(text(value));

        return this;
    }

    @Step("Проверяем правильность введенных в форму данных")
    public RegistrationPage checkRegistrationResults(String label, String value) {
        formResult.checkRegistrationResults(label, value);

        return this;
    }

    @Step("Закрываем окно проверки введенных данных")
    public RegistrationPage closeModalWidow() {
        closeModal.click();

        return this;
    }

    @Step("Проверяем, что рамка поля Электронный адрес окрасилась в красный цвет")
    public RegistrationPage checkEmailTyping(String key, String value) {
        emailInput.shouldHave(cssValue(key, value));

        return this;
    }

    @Step("Проверяем, что рамка поля Телефон окрасилась в красный цвет")
    public RegistrationPage checkPhoneTyping(String key, String value) {
        phoneInput.shouldHave(cssValue(key, value));

        return this;
    }
}
