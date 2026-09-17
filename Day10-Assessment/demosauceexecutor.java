package keyworddrivers;

public class demosauceexecutor {

    demosauceimplementation implementation;

    public demosauceexecutor() {
        implementation = new demosauceimplementation();
    }

    // 2 second delay
    private void waitForAction() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void executor(String keyword) {

        switch (keyword) {

        case "LAUNCH_BROWSER":
            implementation.launchBrowser();
            waitForAction();
            System.out.println("Browser launched successfully.");
            break;


        case "LOGIN":
            implementation.clickLogin();
            waitForAction();
            System.out.println("Login using a valid username and password.");
            break;


        case "VERIFY_PRODUCTS":
            if (!implementation.verifyProductsPage()) {
                throw new AssertionError("Products page is not displayed.");
            }

            waitForAction();
            System.out.println("The Products page is displayed.");
            break;


        case "ADD_BACKPACK":
            implementation.addBackpack();
            waitForAction();
            System.out.println("Sauce Labs Backpack added to the cart.");
            break;


        case "VERIFY_CART_COUNT":

            String count = implementation.getCartCount();

            if (!count.equals("1")) {
                throw new AssertionError(
                        "Cart should contain 1 item. Actual count: " + count);
            }

            waitForAction();
            System.out.println("The cart contains 1 item.");
            break;


        case "OPEN_CART":
            implementation.clickCart();
            waitForAction();
            System.out.println("Cart opened.");
            break;


        case "VERIFY_BACKPACK":

            if (!implementation.verifyBackpack()) {
                throw new AssertionError(
                        "Sauce Labs Backpack is not displayed.");
            }

            waitForAction();
            System.out.println("Sauce Labs Backpack is displayed in the cart.");
            break;


        case "CHECKOUT":
            implementation.clickCheckout();
            waitForAction();
            System.out.println("Checkout button clicked.");
            break;


        case "CONTINUE":
            implementation.clickContinue();
            waitForAction();
            System.out.println(
                    "First Name, Last Name and Postal Code entered and Continue clicked.");
            break;


        case "VERIFY_OVERVIEW":

            if (!implementation.verifyOverviewPage()) {
                throw new AssertionError(
                        "Checkout: Overview page is not displayed.");
            }

            waitForAction();
            System.out.println("The Checkout: Overview page is displayed.");
            break;


        case "FINISH":
            implementation.clickFinish();
            waitForAction();
            System.out.println("Finish button clicked.");
            break;


        case "VERIFY_THANKYOU":

            if (!implementation.verifyThankYouMessage()) {
                throw new AssertionError(
                        "Thank you for your order! message is not displayed.");
            }

            waitForAction();
            System.out.println("Thank you for your order!");
            break;


        case "CLOSE_BROWSER":
        	waitForAction();
            implementation.closeBrowser();
            System.out.println("Browser closed.");
            break;


        default:
            throw new IllegalArgumentException(
                    "Invalid keyword: " + keyword);
        }
    }


    public void enterUsername(String username) {
        implementation.enterUsername(username);
        waitForAction();
        System.out.println("Username entered.");
    }


    public void enterPassword(String password) {
        implementation.enterPassword(password);
        waitForAction();
        System.out.println("Password entered.");
    }


    public void enterFirstName(String firstname) {
        implementation.enterFirstName(firstname);
        waitForAction();
        System.out.println("First Name entered.");
    }


    public void enterLastName(String lastname) {
        implementation.enterLastName(lastname);
        waitForAction();
        System.out.println("Last Name entered.");
    }


    public void enterPostalCode(String postalcode) {
        implementation.enterPostalCode(postalcode);
        waitForAction();
        System.out.println("Postal Code entered.");
    }


    public void openURL(String url) {
        implementation.openURL(url);
        waitForAction();
        System.out.println("Navigated to SauceDemo Application.");
    }
}