import java.util.Scanner;

public class CurrencyConverterSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Display currency options
        System.out.println("Available currencies:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. INR (Indian Rupee)");

        // Step 2: Choose base currency
        System.out.print("Choose base currency (1-3): ");
        int baseChoice = scanner.nextInt();

        // Step 3: Choose target currency
        System.out.print("Choose target currency (1-3): ");
        int targetChoice = scanner.nextInt();

        // Step 4: Enter amount
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Step 5: Define exchange rates (relative to USD)
        double usdToEur = 0.92;
        double usdToInr = 83.0;

        // Convert base currency to USD first
        double amountInUsd = 0.0;
        switch (baseChoice) {
            case 1: amountInUsd = amount; break;              // USD
            case 2: amountInUsd = amount / usdToEur; break;    // EUR to USD
            case 3: amountInUsd = amount / usdToInr; break;    // INR to USD
            default: System.out.println("Invalid base currency."); return;
        }

        // Convert USD to target currency
        double convertedAmount = 0.0;
        switch (targetChoice) {
            case 1: convertedAmount = amountInUsd; break;           // USD
            case 2: convertedAmount = amountInUsd * usdToEur; break; // USD to EUR
            case 3: convertedAmount = amountInUsd * usdToInr; break; // USD to INR
            default: System.out.println("Invalid target currency."); return;
        }

        // Step 6: Display result
        String[] currencyCodes = {"USD", "EUR", "INR"};
        System.out.printf("✅ %.2f %s = %.2f %s%n",
                          amount,
                          currencyCodes[baseChoice - 1],
                          convertedAmount,
                          currencyCodes[targetChoice - 1]);

        scanner.close();
    }
}
