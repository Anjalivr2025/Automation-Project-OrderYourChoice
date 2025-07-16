# 🛍️ Automation Testing Project – OrderYourChoice.com (E-commerce Platform)
## 📌 Project Overview
This project demonstrates **end-to-end automation testing** of the e-commerce website [OrderYourChoice.com](https://www.orderyourchoice.com) using Selenium WebDriver with Java. The testing framework is built using the **Page Object Model (POM)** with **Page Factory**, and incorporates **data-driven testing** for login using Excel via Apache POI.
## 🧰 Tech Stack
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Apache POI (Excel)**
- **Page Factory (POM Design Pattern)**
## 🏗️ Framework Features
- Page Object Model (POM) with Page Factory for better structure
- Data-driven testing with Excel (Apache POI)
- Reusable utility methods for common tasks
- Explicit waits and exception handling for stability
- Screenshots for key pages and UI validations
## ✅ Automated Test Scenarios
- **Login Validation** using multiple credentials from Excel
- **UI Checks:**
  - Page title verification
  - Logo visibility
  - Menu interaction
  - Screenshot capture (Home/Menu)
- **Functional Tests:**
  - Product search and link extraction
  - Add-to-cart functionality
  - Checkout process
  - Delivery date and time selection
  - Payment method selection
  - Order confirmation validation
  - Sign-out functionality
## 📂 Project Structure
OrderYourChoice-Automation/
├── src/
│ └── test/
│ ├── java/
│ │ ├── pages/
│ │ ├── tests/
│ │ └── utils/
│ └── ExcelDataReader.java
├── testdata/
│ └── login_credentials.xlsx
├── Screenshots/
│ ├── homepage.png
│ └── order_confirmation.png
├── testng.xml
├── pom.xml
└── README.md
🧪 Highlights
Robust automation of a full shopping journey
Data-driven login tests with scalable credential input
UI, functional, and behavioral validations
Exception handling and reusable methods for optimized stability

👤 Author
Anjali V.R

QA Automation Engineer
