import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void Mansion(){
        System.out.printf("""
                          |       `'::::.%40s
                          |         ____||_\t\tWELCOME TO%13s
                          |        /      /\\%37s
                          |     __/__/\\__/  \\___\t\tMYSTERY MANSION%8s
                          | ---/__|" '' "| /___/\\----%28s
                          |    |''|"'||'"| |' '||\t\tADVENTURE%14s
                          |    `""`""))""`"`\"\"""`%32s
                          """ 
        , "|","|","|","|","|","|","|");
    }

    public static void Mainmenu(){
        System.out.println("=======================================================");
        Mansion();
        System.out.println("=======================================================");
        String[] list = {"PLAY (P)", "LOAD (L)", "EXIT (E)"};
        for(int i = 0;i < 7;i++){
            for(int j = 0; j < 55; j++){
                if(j == 0 || j == 54){
                    System.out.print("|");
                } 
                if(j == 10 && i % 2 == 1){
                    System.out.printf("-----======= %s ========-----",list[i/2]);
                }
                if(j > 0 && j != 54){
                    if(i%2 == 1 && j < 52 && j >= 17){
                        System.out.print("");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("=======================================================");
    }

    public static void main(String[] args) throws Exception { 
        Mainmenu();
        String choice = "";
        boolean valid = true;
        do { 
            System.out.printf("Enter your choice: ");
            try {
                valid = true;
                choice = sc.nextLine();
                if(choice.length() != 1){
                    System.out.println("Invalid input");
                } else if(!choice.equalsIgnoreCase("p")&&!choice.equalsIgnoreCase("l")&&!choice.equalsIgnoreCase("e")){
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }

            choice = choice.toLowerCase();

            switch(choice){
                case "p" -> System.out.println("you want to play letsplay");
                case "l" -> System.out.println("Loading...");
                case "e" -> System.out.println("Thank you for playing. Exiting...");
                default -> System.out.println("Invalid input");
            }
        } while (choice.equalsIgnoreCase("e"));
    }


}
