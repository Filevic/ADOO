import java.util.ArrayList;

/**
 *
 * @author jua_c
 */
public class SeleccionFutbol {

    private int id;
    private String Nombre;
    private String Apellidos;
    private int Edad;

   
	

	public SeleccionFutbol(int id, String nombre, String apellidos, int edad) {
		this.id = id;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Edad = edad;
	}
        
        public class Futbolista extends SeleccionFutbol {

        private int dorsal;
        private String demarcacion;
	

	public Futbolista(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion) {
		super(id, nombre, apellidos, edad);
		this.dorsal = dorsal;
		this.demarcacion = demarcacion;
	}
        
        }
        
       public class Entrenador extends SeleccionFutbol
{

	private String idFederacion;

        public Entrenador() {
		
	}	

	public void dirigirPartido() {
			
	}

	public void dirigirEntreno() {
		
	}
       }
       
       public class Masajista extends SeleccionFutbol
{

	private String Titulacion;
	private int aniosExperiencia;

        public Masajista() {
		
	}

       
	public void darMasaje() {
		
	}
    }
   

	public static void main(String[] args) {
           SeleccionFutbol mexico=new SeleccionFutbol( 9,"uno", "dos", 12);
            System.out.println(" " + mexico);
            
            
            

}

   }