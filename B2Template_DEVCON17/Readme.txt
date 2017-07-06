** Updated for Q2 2016 **
This B2 template is based on the Spring MVC (4.3.2), and includes a number of customized classes to help accomplish routine tasks.

To use this B2, make a copy of the project in the Spring Tool Suite, and be sure to edit the following files:
-src/main/resources/bb-manifest.xml
--Do not modify any of the tokens (${value}), as they will be populated based on data from pom.xml
--Remove or update any necessary sections, ie additional modules, links, event handlers, etc

-pom.xml
--This file includes all of the property data used to populate the fields in bb-manifest.xml and logback.xml.  Update the b2 properties fields in pom.xml, and use the tokens as needed elsewhere in your project.

The template includes 3 controllers - LinkController, ModuleController, and SettingsController. 

This template also includes Lombok, to assist with rapid development of pojos through annotatations (https://projectlombok.org/)