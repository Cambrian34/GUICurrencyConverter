# Currency Converter Application

A JavaFX-based desktop application that allows users to convert between currencies using live exchange rates fetched from an API.

## Features
- User-friendly graphical interface for seamless currency conversion.
- Supports four currencies: **USD**, **EUR**, **JPY**, and **JMD**.
- Live exchange rates obtained from a reliable API.
- Handles user input for amount and currency selection.

## Requirements
- **Java 11** or higher.
- **JavaFX SDK** installed and configured.
- Active internet connection for API calls.
- API Key for [Exchange Rate API](https://open.er-api.com/).

## Setup Instructions
1. Clone or download this repository.
2. Replace the placeholder API key in the code:
   ```java
   private static final String API_KEY = "YOUR_API_KEY_HERE";
# How to Use

- **Input the Amount**: Enter the amount you want to convert.
- **Select the Currencies**: Use the dropdown menus to choose the source and target currencies.
- **Convert**: Click the "Convert" button to see the converted value in the output field.
- **Pause and Retry**: The application handles invalid input by defaulting the exchange rate to 1:1 if the API fails.

# Code Highlights

### Core Functionalities:
- **API Integration**: Fetches live exchange rates.
- **Dynamic Currency Selection**: Allows users to select any two supported currencies.
- **Responsive Design**: The layout adjusts for optimal viewing.

### Key Methods:
- `getExchangeRate(String fromCurrency, String toCurrency)`: Fetches the exchange rate between the selected currencies using the API. Handles JSON responses using the `org.json` library.
- **Event Handling**: Listens for user interactions like button clicks and text input.

# Dependencies
- **JavaFX** for GUI development.
- **org.json** for JSON parsing.

# Screenshots
(Not included but describe how the layout looks: Top text for title, input field on the left, dropdowns in the center/right, and output with the "Convert" button at the bottom.)

# Known Issues
- Defaults to 1:1 exchange rate if the API call fails (e.g., due to connectivity issues).
- Limited to four currencies. Add more currencies by modifying the dropdown menus and API query.

# License
This project is released under the MIT License.

# Author
Alistair Chambers
