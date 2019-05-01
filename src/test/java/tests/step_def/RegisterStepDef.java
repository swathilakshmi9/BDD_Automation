package tests.step_def;


import cucumber.api.java.en.When;
import tests.page_object.HeaderPage;
import tests.page_object.LoginPage;

import java.util.List;
import java.util.Map;

public class RegisterStepDef {


    private HeaderPage headerPage=new HeaderPage();
    private LoginPage loginPage=new LoginPage();

    @When("^I navigate to register page$")
    public void i_navigate_to_register_page() {
        headerPage.goToLoginPage();
        loginPage.goToRegister();

    }

    @When("^I fill the user registeration for:$")
    public void i_fill_the_user_registeration_for(List<Map<String,String>> data) {
        loginPage.doRegister(data);
    }

}
