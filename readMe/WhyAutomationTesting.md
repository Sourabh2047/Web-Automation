# Why scripts fails ?

## Generally, Scripts fail in 2 situations.

* If script has some issue (some locator has been changed or application has some changes)- In this case, we need to
  maintain our Selenium script.
* Due to application issue - In this case, we need to inform to respective point of contact (Manual Tester or Developer)

## When is a good time to automate a test?

* A test is a good candidate for automation under the following conditions.
* The test is repeatable.
* The feature under the test doesn't change its behavior frequently.
* It’s time-consuming for a human tester.
* The test involves complicated calculations.
* The test ensures the previous functionality didn't break after a new change.

## When will you avoid automated testing?

Though automation has its advantages, it’s not a good idea to automate all of your testings. Here are some scenarios
when a human tester can do a much better job of testing the software than an automated test suite.

The software or the feature under the test changes frequently. It means you have to update your automated test often to
keep them up to date. Tests can quickly become obsolete and stop providing any value. Automated testing is also not
suitable for exploratory testing. A human tester can explore the software in a much better way than a computer. Unless
the automated test are programmed or configured to look for UI issues, they can’t find any problems with the UI.
It’s much efficient for a human tester to spot any UI inconsistencies or design issues.

## Advantages of using Selenium

Open Source: It’s developed in open and has excellent community support. The software is updated regularly, ensuring
significant problems and bugs are fixed, and new features are getting added constantly.
Cross-Browser: Selenium allows you to run and test your web application in multiple browsers, such as Chrome, Safari,
Firefox, etc.
Cross-platform: You can use Selenium on Windows, Mac OS, or Linus. This allows testing the platform compatibility of
your web application.
Language Agnostic: You can use Selenium in your favorite programming languages, such as Java, C#, Python, Ruby, and many
more.

### Disadvantages of Selenium

Learning Curve: One of the most common and recurring problems mentioned by new testers is that Selenium is complicated
and takes a long time to learn. It requires prior programming knowledge.
No support for desktop/mobile: Selenium only supports web applications. You cannot use it to test your desktop and
mobile applications.
No reliable tech support: As it’s open-source software, there’s no dedicated tech support that you can use in case you
run into problems.
Complicated debugging: It’s tougher to debug Selenium programs than the other tools and frameworks.

### When to Use Cucumber?

It focuses on behavior-driven development, where the human-readable description of the functionality is used as the
basis for testing.

* Cypress is a free and open-source testing tool. It’s written in JavaScript and has become very popular recently
  because of its simplicity and advanced features that allow you to perform browser testing.
  Cypress makes it easy to write and debug unit test_Doxzilla, end-to-end test_Doxzilla, integration test_Doxzilla. It
  also supports taking snapshots and recordings to help to reproduce the bugs.

### What is Robot Framework?

Robot Framework is a generic open-source automation framework. It can be used for test automation and robotic process
automation (RPA).

### What is Protractor?

Protractor is an open-source automated testing framework that allows you to perform end-to-end testing of your web
applications.
It’s built on top of WebDriverJS. Protractor is developed by Google and is especially used for testing Angular
applications Collapse
