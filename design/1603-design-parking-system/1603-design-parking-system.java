class ParkingSystem {
    private int big = 0, medium = 0, small = 0;
    private int bigCarsCount = 0, mediumCarsCount = 0, smallCarsCount = 0;
    
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1) {
            bigCarsCount++;
            
            if(big == 0 || bigCarsCount > big)
                return false;
        }
        else if (carType == 2) {
            mediumCarsCount++;
                
            if(medium == 0 || mediumCarsCount > medium)
                return false;
        }
        else {
            smallCarsCount++;
            
            if(small == 0 || smallCarsCount > small)
                return false;
        }
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */