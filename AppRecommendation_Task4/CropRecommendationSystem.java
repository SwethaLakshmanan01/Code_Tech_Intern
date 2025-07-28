import java.util.*;

public class CropRecommendationSystem {

    static String[] crops = {
        "Rice", "Wheat", "Maize", "Sugarcane", "Cotton",
        "Groundnut", "Barley", "Millet", "Soybean", "Paddy",
        "Tea", "Coffee", "Jowar", "Bajra", "Mustard"
    };

    static String[][] cropKeywords = {
        {"clay", "wet", "kharif", "eastern", "humid"},
        {"loamy", "rabi", "dry", "north", "cold"},
        {"loamy", "kharif", "moderate", "central", "warm"},
        {"clay", "humid", "tropical", "kharif", "south"},
        {"black", "dry", "summer", "hot", "western"},
        {"sandy", "kharif", "hot", "tropical", "south"},
        {"loamy", "rabi", "cool", "north"},
        {"sandy", "dry", "summer", "western", "semi-arid"},
        {"black", "warm", "kharif", "central", "monsoon"},
        {"clay", "humid", "kharif", "eastern", "rainy"},
        {"acidic", "cool", "hilly", "northeast"},
        {"acidic", "warm", "hilly", "southwest"},
        {"sandy", "dry", "rabi", "semi-arid", "central"},
        {"sandy", "semi-arid", "summer", "northwest"},
        {"loamy", "cold", "rabi", "north", "dry"}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("           Crop Recommendation System           ");
        System.out.println("===============================================");

        System.out.print("Enter your conditions (soil, season, region, climate): ");
        String input = sc.nextLine().toLowerCase();
        String[] userKeywords = input.split("\\s*,\\s*|\\s+");

        int[] matchCounts = new int[crops.length];
        double[] successRates = new double[crops.length];

        for (int i = 0; i < crops.length; i++) {
            int match = 0;
            for (String userKey : userKeywords) {
                for (String cropKey : cropKeywords[i]) {
                    if (userKey.equals(cropKey)) {
                        match++;
                    }
                }
            }
            matchCounts[i] = match;
            successRates[i] = (cropKeywords[i].length > 0) ? (match * 100.0) / cropKeywords[i].length : 0;
        }

        // Display recommendations with success rates and status
        System.out.println("\nTop Crop Recommendations:");
        boolean found = false;
        for (int i = 0; i < 5; i++) {
            int index = getTopIndex(matchCounts);
            if (index == -1 || matchCounts[index] == 0) break;

            String crop = crops[index];
            double success = successRates[index];
            String status = (success >= 50.0) ? "RECOMMENDED" : "NOT RECOMMENDED";

            System.out.printf("- Crop: %-10s | Success Chance: %5.2f%% | Status: %s%n", crop, success, status);
            matchCounts[index] = -1;
            found = true;
        }

        if (!found) {
            System.out.println("No suitable crop recommendations found. Try different conditions.");
        }

        System.out.println("\nThank you for using the Crop Recommendation System.");
        sc.close();
    }

    private static int getTopIndex(int[] arr) {
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
