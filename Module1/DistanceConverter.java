public class DistanceConverter {

    //method to convert feet to meters
    public static double footToMeter(double foot){
        return foot * 0.305;
    }
    //method to convert meters to feet
    public static double meterToFoot(double meter){
        return meter * 3.279;
    }

    public static void main(String[] args){
        //print header
        System.out.printf("%10s%15s%15s%10s\n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("--------------------------------------------------------");
        //starting values for table
        double feet = 1.0;
        double meters = 20.0;
        //loop to create table
        for (int i = 0; i < 10; i++) {
            double ftToM = footToMeter(feet);
            double mToFt = meterToFoot(meters);
            //print row with converted values   
            System.out.printf("%10.1f%15.3f%15.1f%10.3f\n", feet, ftToM, meters, mToFt);
            //increment each variable for next row
            feet += 1.0;
            meters += 5.0;
        
        }
    }
}