package info.vladyslav.EPAM_HW_11_0113;

import info.vladyslav.EPAM_HW_11_0113.view.DeveloperView;

import java.io.IOException;

/**
 * Console CRUD application that has next entities:
 * Developer, Skill, Account.
 * <p>
 * All starts from Developer view
 */

public class AppRunner {
    public static void main(String[] args) throws IOException {
        DeveloperView developerView = new DeveloperView();
        developerView.viewDeveloperMenu();
    }
}
