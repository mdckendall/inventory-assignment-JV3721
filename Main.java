import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Inventory{
  private String Name = "";
  private String Num = "";
  private int Val;

  //Allows the values to be used outside of this class
  public String getName(){
    return this.Name;
  }
  public String getNum(){
    return this.Num;
  }
  public Integer getVal(){
    return this.Val;
  }

  //Constructor for populating class with values
  public Inventory(String inName, String inNum, int inVal){
    this.Name = inName;
    this.Num = inNum;
    this.Val = inVal;
  }
}

class Main {

  
  
  public static void main(String[] args) {

    int Opt = 0;
    Scanner in = new Scanner(System.in);

    String ItmName, ItmNum, Temp;
    int ItmVal;

    ArrayList<Inventory> List = new ArrayList<Inventory>();  //Creates array list of Inventory classes
    
    while(Opt!=5){

      //Console Prompt
      if(Opt==0){
        System.out.println("Press 1 to add an item.");
        System.out.println("Press 2 to delete an item.");
        System.out.println("Press 3 to update an item.");
        System.out.println("Press 4 to show all the items.");
        System.out.println("Press 5 to quit program.");
        Opt = in.nextInt();
        in.nextLine(); //This and other "in.nextline();"s are used to fix error mentioned in instructions
      }

      //Press 1 Event add item
      if(Opt==1){
        System.out.println("Enter the name:");
        ItmName = in.nextLine();
        System.out.println("Enter the serial number:");
        ItmNum = in.nextLine();
        System.out.println("Enter the value in dollars (whole number):");
        ItmVal = in.nextInt();
        in.nextLine();

        //Creates a new Inventory object using input values and adds it to the array list
        List.add(new Inventory(ItmName, ItmNum, ItmVal));
        
        Opt = 0; //Resets the value of opt to continue loop
      }

      //Press 2 Event delete item
      if(Opt==2){
        System.out.println("Enter the serial number of the item to delete:");
        ItmNum = in.nextLine();

        //Uses for loop and if statement to compare values and remove correct item
        for(int j=0; j<List.size(); j++){
          Temp = List.get(j).getNum();
          if(Temp.equals(ItmNum)){
            List.remove(j);
          }
        }
        
        Opt = 0;
      }

      //Press 3 Event change item
      if(Opt==3){
        System.out.println("Enter the serial number of the item to change:");
        ItmNum = in.nextLine();
        System.out.println("Enter the new Name:");
        ItmName = in.nextLine();
        System.out.println("Enter the new value in dollars (whole number):");
        ItmVal = in.nextInt();
        in.nextLine();

        //Uses for loop and if statement to compare serial number values and change values
        for(int k=0; k<List.size(); k++){
          Temp = List.get(k).getNum();
          if(Temp.equals(ItmNum)){
            List.set(k, new Inventory(ItmName,ItmNum,ItmVal));
          }
        }
        
        Opt = 0;
      }

      //Press 4 Event list inventory
      if(Opt==4){
        //Uses for loop to print out items in array list
        for(int i=0; i<List.size(); i++){
          System.out.println(List.get(i).getName() + "," + List.get(i).getNum() + "," + List.get(i).getVal());
        }
        
        Opt = 0;
      }

      //If five is not pressed program reaches end here and restarts
    }
  }
}
