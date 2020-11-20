package boom;
import java.io.*; 
import java.lang.*;
import java.util.*;

public class Hebra extends Thread {
	String line;
	public Queue<String> postFix;
	public String funcion;
	public String listo;
	public HashMap<String, Integer> precedencia;
	Stack<String> operadores;
	
	public Hebra(String line,String funcion,Queue<String> pos){
		this.line = line;
		operadores = new Stack<String>();
		precedencia= new HashMap<String,Integer>();
		precedencia.put("*", 3);
		precedencia.put("/", 3);
		precedencia.put("+", 2);
		precedencia.put("-", 2);
		this.postFix=pos;
		this.funcion = funcion;
		this.listo = "";
	}
	public String getFuncion(){
		return this.funcion;
	}
	public Queue<String> getpostFix(){
		return this.postFix;
	}

	@Override
	public void run(){
		int i;
		String elemento="";
        String[] spliteo = new String[2];
		spliteo = line.split("=");
		funcion = spliteo[0];
        String operacion = spliteo[1];
		for(i=0; i < operacion.length();i++){
			elemento = String.valueOf(operacion.charAt(i));
			if(elemento.equals("0") ||elemento.equals("1") ||elemento.equals("2") ||elemento.equals("3") ||elemento.equals("4") ||elemento.equals("5") ||elemento.equals("6") ||elemento.equals("7") ||elemento.equals("8") ||elemento.equals("9")||elemento.equals("x")){
				String aux="";
				aux = aux + elemento;
				if(i+1!=operacion.length()){
					elemento = String.valueOf(operacion.charAt(i+1));
					i++;
					while((elemento.equals("0") ||elemento.equals("1") ||elemento.equals("2") ||elemento.equals("3") ||elemento.equals("4") ||elemento.equals("5") ||elemento.equals("6") ||elemento.equals("7") ||elemento.equals("8") ||elemento.equals("9")||elemento.equals("x"))&&i+1!=operacion.length()){
						aux = aux + elemento;
						i++;
						elemento = String.valueOf(operacion.charAt(i));
					}
					i--;
				}
				postFix.add(aux);
				
			}
			else if(elemento.equals("a")||elemento.equals("b")||elemento.equals("c")||elemento.equals("d")||elemento.equals("e")||elemento.equals("f")||elemento.equals("g")||elemento.equals("h")||elemento.equals("i")||elemento.equals("j")||elemento.equals("k")||elemento.equals("l")||elemento.equals("m")||elemento.equals("n")||elemento.equals("o")||elemento.equals("p")||elemento.equals("q")||elemento.equals("r")||elemento.equals("s")||elemento.equals("t")||elemento.equals("u")||elemento.equals("v")||elemento.equals("x")||elemento.equals("y")||elemento.equals("z")){
				String aux="";
				aux = aux + elemento;
				i++;
				elemento = String.valueOf(operacion.charAt(i));
				aux = aux + elemento;
				i++;
				elemento =String.valueOf( operacion.charAt(i));
				aux = aux + elemento;
				i++;
				elemento =String.valueOf( operacion.charAt(i));
				aux = aux + elemento;
				postFix.add(aux);
			}
			else if((elemento.equals("+")|| elemento.equals("-") || elemento.equals("*")|| elemento.equals("/"))){
				
				while( !(operadores.empty()) &&!(operadores.peek().equals("(")) && precedencia.get(operadores.peek())>=precedencia.get(elemento)){
					postFix.add(operadores.pop());
					
				}
				operadores.push(elemento);
			}
			else if(elemento.equals("(")){
				operadores.push(elemento);
			}
			else if(elemento.equals(")")){
				while(!operadores.empty() && !operadores.peek().equals("(") ){
					postFix.add(operadores.pop());
				}
				if(!operadores.empty() && operadores.peek().equals("(")){
					operadores.pop();
				}
			}
			
		}
		
		while(!operadores.empty()){
			postFix.add(operadores.pop());
		}
		this.funcion = spliteo[0];
		while(!postFix.isEmpty()){
			
			if(!(postFix.peek().equals("x"))&&!(postFix.peek().equals("+")) && !(postFix.peek().equals("-")) && !(postFix.peek().equals("*")) && !(postFix.peek().equals("/")) && !(postFix.peek().length()>2 && postFix.peek().charAt(1)=='(')){
				this.listo= this.listo+postFix.poll()+"#";
			}
			else{
				this.listo= this.listo+postFix.poll();
			}
		}
	}
}


