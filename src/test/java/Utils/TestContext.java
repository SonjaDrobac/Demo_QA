package Utils;

import Pages.PageManager;

public class TestContext {

    public PageManager pageManager;

    public BaseTest baseTest;

    public TestContext() {
        baseTest = new BaseTest();
        pageManager = new PageManager(baseTest.getDriver());
    }
}
