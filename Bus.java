package Bus_res;

public class Bus {
	//date should be in private, hence outside of the class, the data 's are not accessible
    private String passengerName;
    private String driverName;
    private String departureCity;
    private String arrivalCity;
	private int busNo;
    private boolean ac;
    private String duration;
    private String startTime;
    private int capacity;
    private double busFare;// getter and setter for accessing private data's
    
    //constructor for the bus class
     Bus(int no, boolean ac, int cap,String driverName, String departureCity, String arrivalCity,String duration, String startTime,double busFare){
    	 this.busNo = no;
    	 this.ac = ac;
    	 this.capacity = cap;
    	 this.driverName = driverName;
    	 this.departureCity = departureCity;
    	 this.arrivalCity = arrivalCity;
    	 this.duration = duration;
    	 this.startTime = startTime;
    	 this.busFare = busFare;
     }
     
     public int getBusNo(){   //for bus
    	 return busNo;
     }
     
     public boolean isAc() {  // for Ac
    	 return ac;
     }
     public void setAc(boolean Ac) {
    	 ac = Ac;
     }
     
    public int getCapacity() {   // to Get capacity value
    	return capacity;
    }
    public void setCapacity(int cap) {  //to change OR set  capacity value
    	capacity = cap;
    }
    
    public String getDriverName() {
    	return driverName;
    }
    
    public String getArrivalCity() {
    	return arrivalCity;
    }
    
    public String getDepartureCity() {
    	return departureCity;
    }
    
    public String getDuration() {
    	return duration;
    }
   

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public double getBusFare() {
		return busFare;
	}
	public void setBusFare(double BusFare){
		this.busFare = BusFare;
	}
	
	 // to display bus information in the output screen
    public void displayBusInfo(){
    	System.out.println("\n🚍 Bus No: " + busNo);
        System.out.println("🔹 AC: " + (ac ? "Yes" : "No"));
        System.out.println("👤 Driver: " + driverName);
        System.out.println("📍 Route: " + departureCity + " ➡ " + arrivalCity);
        System.out.println("⏳ Duration: " + duration);
        System.out.println("🕘 Start Time: " + startTime); // ✅ Display start time
        System.out.println("💺 Capacity: " + capacity);
        System.out.println("💰 Fare: ₹" + busFare) ;
    }
    
    
    
}
