import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest {
  Bus bus;
  Passenger passenger;

  @Before
  public void before() {
    bus = new Bus("X25");
    passenger = new Passenger();
  }

  @Test
  public void hasServiceNumber() {
    assertEquals( "X25", bus.getBusService() );
  }

  @Test
  public void busStartsEmpty() {
    assertEquals( 0, bus.passengerCount() );
  }

  @Test
  public void canBoardPassengers() {
    this.bus.board(this.passenger);
    assertEquals( 1, this.bus.passengerCount() );
  }

  @Test
  public void busIsFull() {
    for(int i = 0; i < 40; i++) {
      this.bus.board(this.passenger);
    }
    assertEquals( true, this.bus.isBusFull() );
  }

  @Test
  public void cannotBoardPassengersWhenBusFull() {
    for(int i = 0; i < 40; i++) {
      this.bus.board(passenger);
    }
    assertEquals( 40, this.bus.passengerCount() );
  }

  @Test
  public void shouldEmptyBusAfterLastStop() {
    this.bus.board(this.passenger);
    this.bus.lastStop();
    assertEquals( 0, this.bus.passengerCount() );
  }

}