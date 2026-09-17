package dataelement;

import keyworddrivers.SauceDemoExecutor;

public class SauceDemoScript {

    public static void main(String[] args) throws InterruptedException {

        SauceDemoExecutor e1 = new SauceDemoExecutor();

        e1.executor("LAUNCH_BROWSER");
        e1.executor("OPEN_URL");
        e1.executor("USER_TF");
        e1.executor("PASS_TF");

        Thread.sleep(2000);

        e1.executor("LOGIN_BUTTON");

        Thread.sleep(2000);

        e1.executor("CLOSE_BROWSER");
    }
}