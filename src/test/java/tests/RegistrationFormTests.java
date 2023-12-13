package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@DisplayName("Тесты на заполнение DemoQA Registration Form")
@Tag("all-tests")
public class RegistrationFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @DisplayName("Проверка заполнения всех полей формы")
    @Tag("positive-tests")
    @Test
    void fullDataTypingInToFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.email)
                .makeGenderChoice(testData.gender)
                .typePhone(testData.phoneNumber)
                .typeDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .typeSubject(testData.subject)
                .typeHobby(testData.hobbies)
                .uploadImage(testData.image)
                .typeAddress(testData.address)
                .typeStateAndCity(testData.state, testData.city)
                .submitRegistration()
                .checkModalTitle(testData.modalTitle)
                .checkRegistrationResults(testData.labelStudentName, testData.firstName + " " + testData.lastName)
                .checkRegistrationResults(testData.labelStudentEmail, testData.email)
                .checkRegistrationResults(testData.labelGender, testData.gender)
                .checkRegistrationResults(testData.labelMobile, testData.phoneNumber)
                .checkRegistrationResults(testData.labelDateOfBirth, testData.dayOfBirth
                        + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkRegistrationResults(testData.labelSubjects, testData.subject)
                .checkRegistrationResults(testData.labelHobbies, testData.hobbies)
                .checkRegistrationResults(testData.labelPicture, testData.image)
                .checkRegistrationResults(testData.labelAddress, testData.address)
                .checkRegistrationResults(testData.labelStateAndCity, testData.state + " " + testData.city)
                .closeModalWidow();
    }

    @DisplayName("Проверка заполнения только обязательных полей формы")
    @Tag("positive-tests")
    @Test
    void minimumDataTypingInToFormTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .makeGenderChoice(testData.gender)
                .typePhone(testData.phoneNumber)
                .submitRegistration()
                .checkModalTitle(testData.modalTitle)
                .checkRegistrationResults(testData.labelStudentName, testData.firstName + " " + testData.lastName)
                .checkRegistrationResults(testData.labelGender, testData.gender)
                .checkRegistrationResults(testData.labelMobile, testData.phoneNumber)
                .closeModalWidow();
    }

    @DisplayName("Проверка заполнения поля Электронный адрес невалидными данными")
    @Tag("negative-tests")
    @Test
    void invalidEmailFieldTypingTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.invalidEmail)
                .makeGenderChoice(testData.gender)
                .typePhone(testData.phoneNumber)
                .submitRegistration()
                .checkEmailTyping(testData.borderColor, testData.rgb);
    }

    @DisplayName("Проверка заполнения поля Телефон невалидными данными")
    @Tag("negative-tests")
    @Test
    void invalidPhoneFieldTypingTest() {
        registrationPage.openPage()
                .typeFirstName(testData.firstName)
                .typeLastName(testData.lastName)
                .typeEmail(testData.email)
                .makeGenderChoice(testData.gender)
                .typePhone(testData.invalidPhoneNumber)
                .submitRegistration()
                .checkPhoneTyping(testData.borderColor, testData.rgb);
    }
}
