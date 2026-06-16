package Plane;

public class CalculateCost {
    private String from;
    private String to;
    private String travelClass;

    public CalculateCost(String from, String to, String travelClass) {
        this.from = from;
        this.to = to;
        this.travelClass = travelClass;
    }

    // Inside the CalculateCost class

    public double calculateCost() {
        double baseCost = calculateClassCost(travelClass);  // Base cost for the journey
        double distanceMultiplier = 0.1;  // Cost increases by 10% for each unit of distance
        // Business class costs 50% more, First Class costs 100% more

        // Calculate the distance between the 'from' and 'to' locations
        double distance = calculateDistance(from, to);

        // Calculate cost based on distance and class
        double cost = baseCost + (distance * distanceMultiplier) ;

        return cost;
    }

    private int calculateDistance(String from, String to) {

        if (from.equals("Dhaka") && to.equals("Nepal")) {
            return 661;
        } else if (from.equals("Dhaka") && to.equals("Thailand")) {
            return 1435;
        } else if (from.equals("Dhaka") && to.equals("Japan")) {
            return 4897;
        } else if (from.equals("Dhaka") && to.equals("Bhutan")) {
            return 410;
        } else if (from.equals("Dhaka") && to.equals("China")) {
            return 1894;
        } else if (from.equals("Dhaka") && to.equals("India")) {
            return 1448;
        } else {
            return 0; // Return 0 if the combination is not found
        }
    }

        private int calculateClassCost(String travelClass) {

            if(travelClass.equals("Economy")){
                return 100;
            }
            else if(travelClass.equals("Business")){
                return 160;
            }
            else {
                return 220;
            }
        }
}
