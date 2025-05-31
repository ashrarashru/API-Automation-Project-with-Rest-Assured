package TestRunner;

import Classes.UserController;
import Classes.UserModel;
import Utils.Utils;
import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

public class UserRegistrationTestRunner {

    @Test(description = "User Registration")
    public void userRegistration() throws ConfigurationException {
        UserController userController = new UserController();
        UserModel userModel = new UserModel();

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + faker.number().digits(5) + "@gmail.com";
        String password = "1234";
        String phoneNumber = "016" + faker.number().digits(8);
        String address = faker.address().fullAddress();
        String gender = "Male";

        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhoneNumber(phoneNumber);
        userModel.setAddress(address);
        userModel.setGender(gender);
        userModel.setTermsAccepted(true);

        Response response = userController.userRegistration(userModel);
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        String userEmail = jsonPath.get("email");
        String userId = jsonPath.getString("_id");

        Utils.setEnvVar("userEmail",userEmail);
        Utils.setEnvVar("userId",userId);

    }
}
