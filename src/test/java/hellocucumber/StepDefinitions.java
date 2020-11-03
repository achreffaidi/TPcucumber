package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

class Item {
    static String isRefundable(String source,String status,String refundable,String underWarranty) {
        if(source.equals("another")) return "not today";
        if(status.equals("broken")) return "not today";
        if(refundable.equals("is not")) return "not today";
        if(underWarranty.equals("is not")) return "not today";
        return "here you are";
    }
}

public class StepDefinitions {
    private String source;
    private String status;
    private String refundable;
    private String underWarranty;
    private String actualAnswer;



    @Given("the user bring at item that he brought from {string} store")
    public void itemFrom(String source) {
        this.source = source;
    }

    @Given("the item is {string}")
    public void itemStatus(String status) {
        this.status = status;
    }
    @Given("the item {string} refundable")
    public void isRefundable(String refundable) {
        this.refundable = refundable;
    }
    @Given("the item {string} under warranty")
    public void setUnderWarranty(String underWarranty) {
        this.underWarranty = underWarranty;
    }

    @When("The client ask for refund")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = Item.isRefundable(source,status,refundable,underWarranty);
    }

    @Then("I should tell the client : {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
