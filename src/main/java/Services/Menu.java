
package Services;

import java.util.Scanner;

public class Menu {
    public void menu1(){ 
        UserService service = new UserService();
        Scanner read = new Scanner(System.in);
        boolean onoff = true;
        int menuChoice,token;
        
        System.out.println("Bienvenido");
        while (onoff){
            try{
                System.out.println("Seleccion:");
                System.out.println("1_Ingresar");
                System.out.println("2_Crear Nuevo Usuario");
                System.out.println("3_Salir");
                menuChoice = read.nextInt();
                
                switch(menuChoice){
                    case 1:
                        token = service.userIn();
                        if(token != 0){
                            service.seeInfo(token);
                        }break;
                    case 2:
                        service.userNew();
                        break;
                    case 3:
                        System.out.println("Hasta luego.");
                        onoff = false;
                        break;
                    case 10:
                        token = service.userIn();
                        service.seeInfo(token);
                        break;
                    default:
                        System.out.println("Por favor, ingrese su seleccion nuevamente:");
                }
            }catch(NumberFormatException e ){
                System.out.println("Por favor, ingrese su seleccion nuevamente:");
            }    
        } 
    }       
}
