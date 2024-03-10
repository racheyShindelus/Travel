/*
Name: Rachel Shindelus
Due Date:10/09/2022
Program Description: This program allows for users to estimate details about their travels using either a gas car or an electric. 
   Using numerous prompts designated for the ser to input their knowledge of their cehicles and travel plans, they are able to 
   receive an estimate regarding the travel time and cost of travel for both vehicle types. 
Self Grade: I believe I should recieve 100% as I have fulfilled every requirement of this assignment. 
*/
import java.util.*;        // Allow for the scanner calss to be utilized
public class TravelAssignmentWeek6Shindelus
{
   public static void main(String[] args) // Don't make any changes to MAIN
   {
      Scanner kb = new Scanner(System.in);
      description();
      System.out.print("How many time do you want to use the app: ");
      int count = kb.nextInt();
      for(int j = 1; j <= count; j++)
      {   
         gasTravel(kb);
         for(int i = 1; i <= 30; i++)
            System.out.print("&");
         System.out.println();   
         electricTravel(kb);
         for(int i = 1; i <= 30; i++)
            System.out.print("&");
         System.out.println();
      } 
      System.out.println("GOOD BYE");   
   }
   
   /*This method calculates the total cost charging the battery, Stops represents the number of the charges*/
   public static double chargeCost(int stops, double pricePerCharge)
   {
      double chargingCost;
      chargingCost = stops * pricePerCharge;                 // Charging cost calculations
      return chargingCost;                                   // Return the cost of charging the vehicle
   }
   
   /* This method calculates the total money spent on the gas to travel. */
   public static double gasCost(double distance, double milesPerGallon, double costPerGallon)
   {
      double gasCost;
      gasCost = distance / milesPerGallon * costPerGallon;    // The cost of gas calculations
      return gasCost;                                         // Return the cost of gas
   }
   
   /*This method caluclates the number of the stops needed to charge the battery.
    milePerCharge represents the number of the miles  driven with a fully charged battery*/ 
   public static int stops(double distance, double milePerCharge)
   {
      double numOfStops;
      numOfStops = distance / milePerCharge;                 // Number of stops required calculations
      return (int)numOfStops;                                // Return the number of stops (now as an integer)
   }
   
   /*This method caluclate the hours of travel taking your gas car*/
   public static double travelHoursGasCar(double distance , double speed)
   {
      double hours;
      hours = distance / speed;                              // Hours of travel calculations
      return hours;                                          // Return the number of hours
   }
   
   /*This method calculates the hours traveling using your electric car stops represenst the number of the times the car needs to be charged hoursPerStop 
   represents the time it takes to fully charge your car distance represents the total distace traveled speed represents the speed of the car */
   public static double travelHoursWithElectricCar(int stops, double hoursPerStop, double distance, double speed)
   {
      double numOfHours;
      numOfHours = (stops * hoursPerStop) + (distance / speed);    // Hours of travel calculation
      return numOfHours;                                           // Return the number of hours
   }
   
   /* 
   ***********GAS CAR***************
   This method calculates the cost and the time to travel with a gas car. */
   public static void gasTravel(Scanner kb)
   {
      System.out.println("\nTraveling with a gas car: ");                             // State this is GAS CAR section
       
      System.out.print("Enter the total number of the miles you are traveling: ");      // Prompt the user to enter the number of the miles to travel
      double distance = kb.nextDouble();                                                // Declare a variable and read the user's input
      
      System.out.print("Enter the planned speed of the car (MPH): ");                   // Prompt user to enter speed of vehicle
      double speed = kb.nextDouble();                                                   // Declare a variable and read the user's input
      
      System.out.print("Enter the miles per gallon achieved by the vehicle: ");         // Prompt the user to enter the MPG of the vehicle
      double fuelRate = kb.nextDouble();                                                // Declare a variable and read the user's input
      
      System.out.print("Enter the cost per gallon of fuel: ");                          // Prompt the user to enter the cost per gallon
      double fuelCost = kb.nextDouble();                                                // Declare a variable and read the user's input
             
      double hours = travelHoursGasCar(distance, speed);                                // Call the method travelHoursGasCar and pass the proper parameters 
      double cost = gasCost(distance, fuelRate, fuelCost);                              // Call the method getCost and pass the proper parameters
      
      System.out.println("\nTraveling with your gas car: ");                            // Display that this is GAS CAR section
      System.out.println("Travel Time: " + hours + " Hours.");                          // Display the hours of travel
      System.out.println("Total cost of gas: $" + cost);                                // Display the cost of the travel 
   }
/* 
************ELECTRIC CAR****************
This method calculates the cost and the time to travel with an electric car. */   
   public static void electricTravel(Scanner kb)
   {
      System.out.println("\nTraveling with an electric car: ");                       // State this is ELECTRIC CAR section
      
      System.out.print("Enter the total number of the miles you are traveling: ");      // Prompt the user to enter the planned number of miles to be traveled
      double distance = kb.nextDouble();                                                // Declare a variable and read the user's input

      System.out.print("Enter the planned speed of the car (MPH): ");                   // Prompt user to enter speed of vehicle
      double speed = kb.nextDouble();                                                   // Declare a variable and read the user's input
     
      System.out.print("Enter the number of miles that can be driven with a fully charged battery: ");   // Prompt the user to enter the miles that can be driven with a fully charged battery
      double milesPerFullCharge = kb.nextDouble();                                      // Declare a variable and read the user's input

      System.out.print("Enter how long it takes to fully charge the car battery: ");    // Prompt the user to enter the number of the hours it takes to fully charge the car battery
      double fullChargeTime = kb.nextDouble();                                          // Declare a variable and read the user's input
      
      System.out.print("Enter the cost of each battery charge: ");                      // Prompt the user to enter the cost per battery charge
      double batteryChargeCost = kb.nextDouble();                                       // Declare a variable and read the user's input
      
      double numOfStops = stops(distance, milesPerFullCharge);                          // Call the method stops with the proper parameters
      double travelHours = travelHoursWithElectricCar((int)numOfStops, fullChargeTime, distance, speed);      // Call the method travelHourWithElectric with the proper parameters
      double costOfCharging = chargeCost((int)numOfStops, batteryChargeCost);           // Call the method  chargeCost with the proper parameters 
      
      System.out.println("\nTraveling with your electric car: ");                     // Display that this is ELECTRIC CAR section
      System.out.println("Number of stops to charge: " + numOfStops);                   // Display the number of stops required to charge the vehicle while traveling
      System.out.println("Travel Time: " + travelHours + " Hours.");                    // Display the hours of travel
      System.out.println("Cost of charging: $" + costOfCharging);                       // Display the cost to charge the vehicle during travel           
   }

/* Description of program (All printing)*/
   public static void description()
   {
      for(int i = 1; i <= 80; i++)
         System.out.print("&");
      System.out.println();
      System.out.println("\t\t\t This program calculates the cost and the time to travel to your");
      System.out.println(" destination given the needed information for both gas car and the electric car.");
      System.out.println("\t\t\t\t\t\t\t Just answer some simple questions:"); 
      for(int i = 1; i <= 80; i++)
         System.out.print("&");
      System.out.println(); 
   }  
}