import java.util.*;
public class  BookTicket {
    public static void book(Flight currentFlight,int tickets,int passengerId){
        String passengerDetail ="";
        passengerDetail = "Passenger ID "+passengerId+" -- "+" Number of Tickets Booked"+tickets+" -- "+"Total cost "+ currentFlight.price*tickets;
        currentFlight.addPassengerDetails(passengerDetail,tickets,passengerId);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void cancel(Flight currentFlight,int passengerID){
        currentFlight.cancelTicket(passengerID);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void print(Flight f){
        f.printDetails();
    }

    public static void main(String[] args) {
        ArrayList<Flight> flights=new ArrayList<>();
        for(int i=0;i<2;i++){
            flights.add(new Flight());
        }
        int passengerID=1;
        while(true){
            System.out.println("1. Book 2. Cancel 3. Print");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("Enter Flight ID");
                    int fid = sc.nextInt();
                    if(fid > flights.size()){
                        System.out.println("Invalid flight ID");
                        break;
                    }
                    Flight currentFlight = null;
                    for(Flight f:flights){
                        if(f.flightID==fid){
                            currentFlight=f;
                            f.flightSummary();
                            break;
                        }
                    }
                    System.out.println("Enter number of tickets");
                    int t = sc.nextInt();
                    if(t > currentFlight.tickets){
                        System.out.println("Not Enough Tckets");
                        break;
                    }
                    book(currentFlight, t, passengerID);
                    passengerID+=1;
                    break;
                }
                case 2:{
                    System.out.println("Enter flight ID and passenger ID to cancel booking");
                    int fid = sc.nextInt();
                    if(fid > flights.size()){
                        System.out.println("Invalid flight ID");
                        break;
                    }
                    Flight currentFlight = null;
                    for(Flight f:flights){
                        if(f.flightID==fid){
                            currentFlight=f;
                            break;
                        }
                    }
                    int id=sc.nextInt();
                    cancel(currentFlight, id);
                    break;
                }
                case 3:{
                    for(Flight f: flights){
                        if(f.passengerDetails.size()==0){
                            System.out.println("No passenger Details for  - Flight " + f.flightID);
                         
                        }
                        else{
                            print(f);
                        }
                    }
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }
}
