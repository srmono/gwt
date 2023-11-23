# SmartGWT Configuration in Spring Tool Suite (STS)

This guide provides step-by-step instructions for configuring SmartGWT in a Java project using the Spring Tool Suite (STS).

## 1. Download SmartGWT:

1. Download SmartGWT from [SmartGWT website](http://www.smartclient.com/smartgwt).
2. Extract the SmartGWT ZIP file to a location on your computer.

## 2. Create or Open a Java Project in STS:

1. Open Spring Tool Suite (STS).
2. Create a new Java project or open an existing one.

## 3. Add SmartGWT Library:

1. Right-click on your project in the Project Explorer.
2. Select `Properties` -> `Java Build Path`.
3. In the `Libraries` tab, click `Add External JARs...`.
4. Navigate to the SmartGWT/lib folder and add the necessary JAR files (e.g., `smartgwt.jar`, `smartgwt-skins.jar`).

## 4. Configure GWT in Your Project:

1. If you haven't configured GWT in your project:
   - Right-click on your project.
   - Go to `Properties` -> `Google` -> `Web Toolkit`.
   - Check the box for "Use Google Web Toolkit."
   - Set the GWT SDK to the path where you have GWT installed.

## 5. Set Up GWT Compile Options:

1. In the same GWT properties window:
   - Under `GWT Compile`, enter your module name (e.g., `com.example.YourGwtModule`).
   - Set additional compile options if needed.

## 6. Configure SmartGWT Module:

1. In your GWT module XML file (e.g., `YourGwtModule.gwt.xml`), include the SmartGWT module:
   ```xml
   <inherits name="com.smartgwt.SmartGwt"/>

## 7. Run or Debug GWT Application:
Right-click on your project.
Choose Run As -> Web Application or Debug As -> Web Application.

## 8. Verify SmartGWT Components:
Create a sample SmartGWT component in your application to verify that the library is working correctly.

---

* Note:
Ensure that your SmartGWT version matches the version compatible with your GWT version.
SmartGWT often requires additional dependencies. Make sure to include any necessary third-party libraries.