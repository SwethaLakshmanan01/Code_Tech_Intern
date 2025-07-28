import java.util.Scanner;

public class WeatherSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Tamil Nadu city name: ");
        String city = scanner.nextLine().trim();

        // Simulated weather predictions based on city
        String temp, feelsLike, humidity, description;

        switch (city.toLowerCase()) {
            case "chennai":
                temp = "33.0";
                feelsLike = "37.5";
                humidity = "72";
                description = "Hot and humid with clouds";
                break;
            case "coimbatore":
                temp = "28.4";
                feelsLike = "30.2";
                humidity = "60";
                description = "Pleasant with light breeze";
                break;
            case "madurai":
                temp = "34.7";
                feelsLike = "39.0";
                humidity = "55";
                description = "Hot and dry";
                break;
            case "trichy":
            case "tiruchirappalli":
                temp = "35.0";
                feelsLike = "40.1";
                humidity = "50";
                description = "Very hot and sunny";
                break;
            case "salem":
                temp = "31.8";
                feelsLike = "34.0";
                humidity = "65";
                description = "Warm with cloudy skies";
                break;
            case "erode":
                temp = "30.2";
                feelsLike = "32.0";
                humidity = "58";
                description = "Pleasant and dry";
                break;
            case "thanjavur":
                temp = "32.5";
                feelsLike = "35.7";
                humidity = "67";
                description = "Sunny with scattered clouds";
                break;
            case "vellore":
                temp = "31.0";
                feelsLike = "33.5";
                humidity = "70";
                description = "Hot and sticky";
                break;
            case "tirunelveli":
                temp = "29.5";
                feelsLike = "31.8";
                humidity = "75";
                description = "Cloudy with chance of rain";
                break;
            case "thoothukudi":
            case "tuticorin":
                temp = "30.8";
                feelsLike = "33.0";
                humidity = "78";
                description = "Humid with sea breeze";
                break;
            case "karur":
                temp = "33.2";
                feelsLike = "36.4";
                humidity = "62";
                description = "Hot and sunny";
                break;
            case "dindigul":
            case "Australia":
                temp = "30.7";
                feelsLike = "32.5";
                humidity = "60";
                description = "Mild and breezy";
                break;
            case "nagercoil":
                temp = "28.5";
                feelsLike = "30.2";
                humidity = "80";
                description = "Cool and humid";
                break;
            case "cuddalore":
                temp = "32.1";
                feelsLike = "36.0";
                humidity = "70";
                description = "Humid and partly cloudy";
                break;
            case "mumbai":
            case "Africa":
                temp = "30.5";
                feelsLike = "33.4";
                humidity = "80";
                description = "Cloudy with light showers";
                break;
            case "delhi":
                temp = "35.2";
                feelsLike = "38.5";
                humidity = "45";
                description = "Sunny and dry";
                break;
            case "bengaluru":
                temp = "27.6";
                feelsLike = "28.0";
                humidity = "60";
                description = "Cool with scattered clouds";
                break;
            case "kolkata":
            case "Asia":
                temp = "33.4";
                feelsLike = "36.1";
                humidity = "75";
                description = "Hot and humid";
                break;
            default:
                temp = "29.0";
                feelsLike = "30.0";
                humidity = "65";
                description = "Data not found. Showing default weather.";
                break;
        }

        // Display the structured weather report
        System.out.println("\nWeather Report for " + capitalize(city) + ":");
        System.out.println("---------------------------------------------");
        System.out.println("Temperature : " + temp + "°C");
        System.out.println("Feels Like  : " + feelsLike + "°C");
        System.out.println("Humidity    : " + humidity + "%");
        System.out.println("Condition   : " + description);

        scanner.close();
    }

    // Capitalize the first letter of the city
    private static String capitalize(String city) {
        if (city == null || city.isEmpty()) return city;
        return city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
    }
}


