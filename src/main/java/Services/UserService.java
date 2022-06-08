
package Services;

import Entities.User;
import java.util.HashMap;
import java.util.Scanner;

public class UserService {
    Scanner read = new Scanner(System.in);
    HashMap<Integer,User> userDatabase = new HashMap<>();
//NEW USER CREATION
    public void userNew(){
        User newUser = new User();
        int databaseToken = (userDatabase.size()+1);
        
        userDatabase.put(databaseToken, newUser);
        setNewName(databaseToken);
        setNewPassword(databaseToken);
        setNewPublicName(databaseToken);
        setNewBirthDate(databaseToken);
        setNewMail(databaseToken);
        setNewSecret(databaseToken);
        
    } 
    

    //USERNAME
    public void setNewName(int databaseToken){
        String aux;
        do {    
            System.out.print("Ingrese un nombre de usuario:");
            aux = read.nextLine();
            if (nameAvailable(aux)){
                userDatabase.get(databaseToken).setUserName(aux);
                break;
            }else{
                System.out.println("Nombre en uso.");
            }
        } while (!nameAvailable(aux));
    }
        
    //PASSWORD
    public void setNewPassword(int databaseToken){
        String aux;
        System.out.print("Ingrese una contrasena:");
        
        do {            
            aux = read.nextLine();
            if (aux.length()>8){
                System.out.print("Ingrese su contrasena de nuevo:");
                String aux2 = read.nextLine();
                if (aux.equals(aux2)){
                    userDatabase.get(databaseToken).setPass(aux);
                }else{
                    System.out.println("Las contrasenas no coinciden.");
                }
                
            }else{
                System.out.println("Su contrasena debe contener al menos 8 caracteres.");
            }
        } while (aux.length()<8);
    }
    //PUBLIC NAME/ALIAS
    public void setNewPublicName(int databaseToken){
        String aux;
        System.out.print("Ingrese un apodo: ");
        aux = read.nextLine();
        userDatabase.get(databaseToken).setUserPublicName(aux);
    }
    //BIRTH DATE
    public void setNewBirthDate(int databaseToken){
        int auxnum,auxnum2,auxnum3;
        char aux = 'S';
        
        do {            
            try{
                System.out.println("Ingrese su fecha de nacimiento:");
                System.out.print("Anio: ");
                auxnum = read.nextByte();
                System.out.print("Mes: ");
                auxnum2 = read.nextByte();
                System.out.print("Dia: ");
                auxnum3 = read.nextByte();
                System.out.println("La fecha ingresada es " + auxnum + "/" + auxnum2 + "/" + auxnum3 + ".");
                System.out.print("Es correcta? (S/N):");
                aux = read.next().toUpperCase().charAt(0);
                if (aux=='S'){
                   userDatabase.get(databaseToken).setUserBirth(Integer.toString(auxnum) + '/' + auxnum2 + '/' + auxnum3);
                   break;
                }
                
            }catch(Exception e){
                System.out.println("Por favor, ingrese una fecha adecuada.");
                
            }
        } while (aux=='S');
        
        
    }
    //MAIL
    public void setNewMail(int token){
        String aux;
        boolean aux2 = true;
        
        System.out.print("Ingrese su email: ");
        aux = read.nextLine();
        while (aux2){
            if (!mailAvailable(aux)){
                System.out.println("El email ingresado ya se encuentra en uso.");
            }else{
                userDatabase.get(token).setUserMail(aux);
                break;
            }
        }
        
        
    }
    // SECRET WORD
    public void setNewSecret(int token){
        String secret;
        
        System.out.println("Por su seguridad, ingrese una palabra o frase secreta: ");
        secret = read.nextLine();
        userDatabase.get(token).setUserSecret(secret);
        System.out.println("Su palabra o frase secreta es: " + userDatabase.get(token).getUserSecret());
    }
            
//SIGN IN    
    public int userIn(){
        String username;
        boolean goback = true;
        
        while (goback){
            System.out.print("Ingrese su nombre de usuario, o presione ENTER para salir: ");
            username = read.nextLine();
            
            
                if ((!username.equals("")) && (nameAvailable(username)) && ((passInput(userToken(username))))){
                        System.out.println("Bienvenido.");
                        return userToken(username);
                }else if (username.equals("")){
                    break;
                }else{
                    System.out.println("El usuario no existe. Intente de nuevo.");
                }
        }return 0;      
    }
    
// SEE ALL DATA
public void seeInfo(int token){
    System.out.println(userDatabase.get(token).getUserName());
    System.out.println(userDatabase.get(token).getUserPublicName());
    System.out.println(userDatabase.get(token).getPass());
    System.out.println(userDatabase.get(token).getUserBirth());
    System.out.println(userDatabase.get(token).getUserMail());
    System.out.println(userDatabase.get(token).getUserSecret());
}    
    
    
    
    
    
// ALL SERVICES  
    int userToken(String username){
        int aux = 0;
        for (User i : userDatabase.values()){
            if (i.getUserName().equals(username)){
                aux = aux+1;
                break;
            }
            aux = aux+1;
        }
        return aux;
    }
    boolean passInput(int token){
        String password;
        
        System.out.print("Ingrese su contrasenia: ");
        password = read.nextLine();
        for (int i = 0; i < 3; i++) {
            if (!userDatabase.get(token).getPass().equals(password)){
                System.out.print("Contrasenia no coincide. Intente de nuevo: ");
                password = read.nextLine();
            }else{break;}
        }
        if (!userDatabase.get(token).getPass().equals(password)){
            System.out.println("Ha realizado demasiados intentos.");
            System.out.println("Se ha enviado un email a " + userDatabase.get(token).getUserMail() + " para restablecer su contrasenia.");
            return false;
        }else{return true;}
    }
    
    boolean nameAvailable(String username){
        boolean isAvailable = true;
        for (User i : userDatabase.values()){
            if (username.equals(i.getUserName())){
                isAvailable = false;
                break;
            }
        }
        
        return isAvailable;
    }
    boolean mailAvailable(String mail){
        boolean isAvailable = true;
        for (User i : userDatabase.values()){
            if (mail.equals(i.getUserMail())){
                isAvailable = false;
                break;
            }
        }
        
        return isAvailable;
    }
    
}
