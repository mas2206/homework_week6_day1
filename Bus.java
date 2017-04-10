  public class Bus {
    private String service;
    private Passenger[] capacity;

    public Bus(String service) {
      this.service = service;
      this.capacity = new Passenger[40];
    }

    public String getBusService() {
      return this.service;
    }

    public int passengerCount() {
      int count = 0;
      for(Passenger passenger : this.capacity) {
        if(passenger != null) {
          count++;
        }
      }
      return count;
    }

    public void board(Passenger passenger) {
      if( isBusFull() ) {
        return;
      }
      int passengerCount = passengerCount();
      this.capacity[passengerCount] = passenger;
    }

    public boolean isBusFull() {
      return passengerCount() == capacity.length;
    }

    public void lastStop() {
      for(int i = 0; i < capacity.length; i++) {
        this.capacity[i] = null;
      }
    }

  }