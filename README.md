
#SALES FORCE UI TEST PROJECT

WHAT IS IT?

Sales Force UI Test project has as main objective to automate acceptance test for Sales force
web application and its main characteristics by using Selenium and TestNG.

FEATURES TESTED

The main test that are implemented in this framework are.

*Account
*Campaign
*Cases
*Chatter
*Contact
*Contract
*Lead
*Opportunity
*Product

REQUIREMENTS AND SET CONFIGURATIONS

To set the configuration of this framework is required the following:

IntelliJ idea IDE.

Download Gradle 3.0 or superior: https://gradle.org/gradle-download/
Clone/download the project from GitHub repository: https://github.com/AT-01/sfdc-ui-test.git

Once those requirements are done, follow these steps:

Open the project downloaded with the IntelliJ IDE.
Open the Gradle properties file e.g. gradle.properties file
Set the required parameters:

*timeout=Limit of response timeout.
*authentication.baseURL=Is the url of application(https://login.salesforce.com)
*suites=Is the tests that will be executed (src/test/sources/TestNGSuite.xml)
*primaryUserName=Is the username to login to Sales force.
*primaryUserPassword=Is the password to login to Sales force.
*remoteUserName=Is the username of saucelabs or browserstack.
*remoteKey=Is the key provided by your account on saucelabs or browserstack.
*remoteBrowser=Is the browser that you want to execute your test remotely. (e.g. Chrome)
*remoteBrowserVersion=Is the version of the browser wrote before ^. (e.g. 54.0)
*remotePlatform=Is the OS where you want to execute your test. (e.g. Windows)
*remotePlatformVersion=Is the OS version. (e.g. 8.1)
*remoteResolution=Is the resolution of the screen. (e.g. 1920x1080)
*proxy=Is the proxy configuration .(Set only if proxy is required)
*port=Is the proxy port configuration (Set only if proxy is required)
*browser=Is the browser where the test are goin to be executed, it could have 3 values: Chrome, browserstack or saucelabs.
After executing those steps the frame should be executed (In progress).
To execute by command line you can use the following: use proxy param if it is necessary and remote variables too.

gradle clean check runTestNGTestCases -Psuites=TestNgSuite.xml -PprimaryUserName=SALES FORCE USER NAME
 -PprimaryUserPassword=SALES FORCE USER PASSWORD
 -PremoteUserName=SAUCELAB USERNAME  -PremoteKey=SAUCELAB KEY


CONTACTS

If you want to be informed about new code releases, bug fixes, security fixes, general news and information about the Mach2 UI project check to the GitHub repository https://github.com/AT-01/mach2-ui-test.git
CONTRIBUTORS

Current contributors:

*Lourdes Villca (lourdesVillca) - https://github.com/lourdesVillca
*Ericka Viraca (ErickaViraca) - https://github.com/ErickaViraca
*Angela Valdez (angy113) - https://github.com/angy113
*Juana Rodriguez (JuanaRodriguez) - https://github.com/JuanaRodriguez
*Aldo Balderrama (mabalderramav) - https://github.com/mabalderramav
*Bruno Vasquez (brunovasquez) - https://github.com/brunovasquez
*Jimmy Romero S. (JimmyRomero) - https://github.com/JimmyRomero
*Alvaro Daza (AlvaroDazaQuiroga) - https://github.com/AlvaroDazaQuiroga
*Carlos Gonzales (carledriss) - https://github.com/carledriss
