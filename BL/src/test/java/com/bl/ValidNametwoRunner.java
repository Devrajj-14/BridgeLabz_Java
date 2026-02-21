package com.bl;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.util.Scanner;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.request;

public class ValidNametwoRunner {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first name: ");
            String userInput = sc.nextLine().trim();

            // pass input to tests
            System.setProperty("firstNameUnderTest", userInput);

            // run the real JUnit test class
            LauncherDiscoveryRequest req = request()
                    .selectors(selectClass(ValidNametwoTest.class))
                    .build();

            Launcher launcher = LauncherFactory.create();
            SummaryGeneratingListener listener = new SummaryGeneratingListener();

            launcher.registerTestExecutionListeners(listener);
            launcher.execute(req);

            var summary = listener.getSummary();

            System.out.println("\n===== TEST SUMMARY =====");
            System.out.println("Total  : " + summary.getTestsFoundCount());
            System.out.println("Passed : " + summary.getTestsSucceededCount());
            System.out.println("Failed : " + summary.getTestsFailedCount());

            if (summary.getTestsFailedCount() > 0) {
                System.out.println("\nFailed tests:");
                summary.getFailures().forEach(f ->
                        System.out.println("- " + f.getTestIdentifier().getDisplayName()
                                + " | " + f.getException().getMessage())
                );
            }
        }
    }
}