package boom;
import java.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import javax.print.PrintException;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

public class Magia {
    
    public HashMap<String, Integer> precedencia;
    static public HashMap<String, String> funciones;
	Stack<String> operadores;
	String operacion;
    String aux;
    static int iteracion = 0;

   
    public Magia(String texto){
        precedencia = new HashMap<String, Integer>();
		precedencia.put("*", 3);
		precedencia.put("/", 3);
		precedencia.put("+", 2);
		precedencia.put("-", 2);
        funciones = new HashMap<String, String>();	
        operadores= new Stack<String>();
        
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./src/boom/funciones.txt");
        Scanner input = new Scanner(file);
        int cantidad = Character.getNumericValue(input.nextLine().charAt(0));
        Hebra hebras[] = new Hebra[cantidad];
        String[] funcionT = new String[cantidad];
        Queue<String>[] salidas= new LinkedList[cantidad];
        funciones = new HashMap<String, String>();	
        int i;
        for(i=0; i < cantidad ; i++){
            funcionT[i]= new String();
            funcionT[i]="";
            salidas[i]= new LinkedList<String>();
        }
        for(i = 0; i < cantidad ; i++){
            hebras[i] = new Hebra(input.nextLine(),funcionT[i],salidas[i]);
            hebras[i].start(); 
        }

        for(i = 0; i < cantidad ; i++){
            try{
                hebras[i].join();
                funciones.put(hebras[i].funcion,hebras[i].listo); 
                
            }
            
            catch(Exception e){
                System.out.println("TOMC?"+"XDDDDDDDDDD"+e);
            }
         
        }  
        float resultado;
        boolean flag = true;
        String inputt;
        float z;
        while(flag){
            System.out.println("Ingrese la funcion que quiere evaluar o ingrese un 0 si desea salir: ");
            Scanner in = new Scanner(System.in);
            inputt = in.next();
            if(inputt.charAt(0) == '0'){
                flag = false;
            }
            else{ 
                String[] aux= inputt.split("\\(");
                z = Float.parseFloat(aux[1].replace(")",""));
                String aux2 = aux[0];
                aux2 += "(x)";
                resultado = calculateFunct(funciones.get(aux2), z); 
                System.out.println("El resultado es "+resultado);
            }
        }
    }

/*

Funcion: calculateFunct

Parametros:

    String postFix: que es la funcion a calcular en formato postfijo
    float z: valor del parametro (x) que recibe la funcion a evaluar

Procedimiento: Se utiliza una pila para ir guardando los operandos en orden postfijo y al encontrar una operacion se sacan los ultimos 
dos elementos para realizar la operacion y guardar el resultado en la pila.

Retorno: float resultado de la evaluacion de la funcion

*/

    static float calculateFunct(String postFix, float z) {
		float x,y;
        float elem;
        iteracion++;
        int cont = iteracion;
        Stack<Float> calculating = new Stack<Float>();
        String elemento;
        int i;
        for(i = 0; i < postFix.length(); i++){
            if(postFix.charAt(i) == '+'){
                x = calculating.pop();
                y = calculating.pop();
                calculating.push(x+y);
            }
            else if(postFix.charAt(i) == '-'){
                x = calculating.pop();
                y = calculating.pop();
                calculating.push(y-x);
            }
            else if(postFix.charAt(i) == '*'){
                x = calculating.pop();
                y = calculating.pop();
                calculating.push(x*y);
            }
            else if(postFix.charAt(i) == '/'){
                x = calculating.pop();
                y = calculating.pop();
                calculating.push(y/x);
            }
            else if(postFix.charAt(i) == 'x'){
                calculating.push(z);
            }
			else if(postFix.charAt(i+1) == '('){
                elemento =""+postFix.charAt(i)+postFix.charAt(i+1)+postFix.charAt(i+2)+postFix.charAt(i+3); 
                String postFix2= funciones.get(elemento);
				calculating.push(calculateFunct(postFix2, z));
                i += 3;
			}
            else{
                elemento = ""+postFix.charAt(i++);
                while(postFix.charAt(i) != '#'){
                    elemento += postFix.charAt(i);
                    i++;
                }
                elem = Float.parseFloat(elemento);
                calculating.push(elem);
            }          
        }
        return calculating.pop();
		
	}
}
