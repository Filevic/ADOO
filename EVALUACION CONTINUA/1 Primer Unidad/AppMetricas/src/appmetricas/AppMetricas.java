
package appmetricas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class AppMetricas {
    ArrayList <Clase> clases=new ArrayList<Clase>();
ArrayList <String> TodoElCode=new ArrayList<String>();
String Todo="";
    /**
     * @param args the command line arguments
     */
    AppMetricas () throws IOException{
        FileReader fa=null;
        try {
            String cardena="";
            
            fa = new FileReader("prueba.java");
            BufferedReader ba = new BufferedReader(fa);//leer cada linea del archivo
            while((cardena = ba.readLine())!=null) {
                while (cardena.contains("  "))
                {   
                    cardena=cardena.replace("\t", "");
                    cardena=cardena.replace("\n", "");
                    cardena=cardena.replace("\f", "");
                    cardena=cardena.replace("\r", "");
                    cardena=cardena.replace("  ", " ");
                    cardena=cardena.replace(",", " , ");
                    cardena=cardena.replace("  ", " ");
                    cardena=cardena.replace("{", " {");
                    cardena=cardena.replace("}", "} ");
                    cardena=cardena.replace("(", " ");
                    cardena=cardena.replace(")", " ");
                    cardena=cardena.replace("  ", " ");
                }
                Todo=Todo+cardena+"\n";
                
                //System.out.println(""+cardena);
                TodoElCode.add(cardena);
                
//
            }
            //eliminar error comentarios
            //System.out.println(Todo);
            ba.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppMetricas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fa.close();
            } catch (IOException ex) {
                Logger.getLogger(AppMetricas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    void identificarWmc(){
        String [] palabrasres={"for","if","while"};
     int Wmc=0;
        for(int renglonx=0;renglonx<TodoElCode.size();renglonx++){ //para cada renglon
            String[]renglon=TodoElCode.get(renglonx).split(" ");//
            for(int j=0;j<renglon.length;j++){//para cada cadena del renglon
                boolean [] reservada= new boolean [renglon.length];
                reservada[j]=false;
                for(int k=0;k<palabrasres.length;k++){
                    if(palabrasres[k].equals(renglon[j])){  
                        Wmc++;
                        //System.out.println(palabrasres[k]);
                        //reservada[j]=true;
                    } else {
                        //System.out.println("NO hay palabras reservadas ");
                    }
                }
            }
        }
        System.out.println("el numero de estructuras: "+Wmc);
    }
    void identificarDit(){
        String [] palabrasres={"implements","extends"};
         
        int inicio=0;
        do{
            
        
        if(Todo.indexOf("class",inicio)!=-1){
            String nombreClase=SigPalabra("class",inicio);
            inicio=Todo.indexOf(nombreClase,inicio);
            String bueffer=nombreClase;
            ArrayList <String> implementa=new ArrayList<String>(); 
            ArrayList <String> extiende=new ArrayList<String>();
            //while (!SigPalabra(bueffer,inicio).equals("{"))
                if (SigPalabra(bueffer,inicio).equals("extends")){
                    bueffer="extends";
                    inicio=Todo.indexOf(bueffer,inicio);
                    bueffer=SigPalabra(bueffer,inicio);
                    //System.out.println(bueffer);
                    inicio=Todo.indexOf(bueffer,inicio);
                    extiende.add(bueffer);
                    
                    
                    while(SigPalabra(bueffer,inicio).equals(",")){
                        if(SigPalabra(bueffer,inicio).equals(",")){

                            bueffer=",";
                            bueffer=SigPalabra(bueffer,inicio);
                            inicio=Todo.indexOf(bueffer,inicio);
                            extiende.add(bueffer);
                            //System.out.println(implementa);
                        }
                    }
                }
            
                if (SigPalabra(bueffer,inicio).equals("implements")){
                    bueffer="implements";
                    inicio=Todo.indexOf(bueffer,inicio);
                    bueffer=SigPalabra(bueffer,inicio);
                    //System.out.println(bueffer);
                    inicio=Todo.indexOf(bueffer,inicio);
                    implementa.add(bueffer);
                    
                    
                    while(SigPalabra(bueffer,inicio).equals(",")){
                        if(SigPalabra(bueffer,inicio).equals(",")){

                            bueffer=",";
                            bueffer=SigPalabra(bueffer,inicio);
                            inicio=Todo.indexOf(bueffer,inicio);
                            implementa.add(bueffer);
                            //System.out.println(implementa);
                        }
                    }
                }
            
            
            clases.add(new Clase(nombreClase,implementa,extiende));
        }
        }while(Todo.indexOf("class",inicio)!=-1);
            for(int i=0;i<clases.size();i++)
            System.out.println("para clase "+clases.get(i).nombre+" Dits: "+clases.get(i).DitC());
        
        
    }
    public String SigPalabra(String palabrabusq, int posicion){
        if(posicion!=-1){
            int posicionPalabra=Todo.indexOf(palabrabusq,posicion);
            int posicionSigPal=Todo.indexOf(" ",posicionPalabra);
            String SigPal="";
            int sigEspacio=Todo.indexOf(" ",posicionSigPal+1);
            for(int i=1;posicionSigPal+i<sigEspacio;i++){
                SigPal=SigPal+Todo.charAt(posicionSigPal+i);
            }
            return SigPal;
        }
        else{ 
            System.out.println("fallo en la matrix");
            return null;
        }
    }
    public void contarHijos(){
        for(int x=0;x<clases.size();x++){
            for(int y=0;y<clases.get(x).extiend.size();y++){
            
                String encontrada=clases.get(x).extiend.get(y);
                
                for(int z=0;z<clases.size();z++){
                    if(encontrada.equals(clases.get(z).nombre)){
                        clases.get(z).Hijos++;
                    }
                }
            }
            
        }
        
    }
    public void identificarNoc(){
        for(int z=0;z<clases.size();z++){
                    System.out.println("la clase: "+clases.get(z).nombre+" tiene "+clases.get(z).Hijos+" hijos");
        }
    }       
    public static void main(String[] args) throws IOException {
        AppMetricas prueba=new AppMetricas();
        prueba.identificarWmc();
        prueba.identificarDit();
        prueba.contarHijos();
        prueba.identificarNoc();
        //System.out.println(prueba.Todo);
        // TODO code application logic here
    }
    
}
class Clase{
    String nombre;
    int Hijos=0;
    ArrayList<String> implement,extiend;
    Clase(String name,ArrayList <String> implementa,ArrayList <String> extiende){
        implement=implementa;
        extiend=extiende;
        nombre=name;
    }

    
    int DitC(){
        System.out.println("extiende: "+implement+"inteface: "+extiend);
        return implement.size()+extiend.size();
    }
    
}
