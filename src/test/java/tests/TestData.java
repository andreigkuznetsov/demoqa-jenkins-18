package tests;

import com.github.javafaker.Faker;

import java.util.Objects;

public class TestData {
    private final Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            invalidEmail = faker.internet().domainWord() + "@rt.t",
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            invalidPhoneNumber = faker.phoneNumber().subscriberNumber(9),
            gender = faker.options().option("Male", "Female", "Other"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2008)),
            monthOfBirth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            subject = faker.options().option("Commerce", "Economics", "History"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            image = faker.options().option("pic1.jpg","pic2.jpg","pic3.jpg"),
            address = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setCity(state),
            borderColor = "border-color",
            rgb = "rgb(220, 53, 69)",
            modalTitle = "Thanks for submitting the form",
            labelStudentName = "Student Name",
            labelStudentEmail = "Student Email",
            labelGender = "Gender",
            labelMobile = "Mobile",
            labelDateOfBirth = "Date of Birth",
            labelSubjects = "Subjects",
            labelHobbies = "Hobbies",
            labelPicture = "Picture",
            labelAddress = "Address",
            labelStateAndCity = "State and City";

    public static String setCity(String state) {
        Faker faker = new Faker();

        if (Objects.equals(state, "NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (Objects.equals(state, "Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else if (Objects.equals(state, "Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        } else
            return state;
    }
}
