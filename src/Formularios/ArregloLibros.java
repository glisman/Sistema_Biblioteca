package Formularios;
//Declaracion de librerias adicionales
import java.io.Serializable;
import java.util.ArrayList;
public class ArregloLibros implements Serializable {
private ArrayList <Libro>  a;  // arreglo de objetos para empleados
//Generacion del Constructor
       public ArregloLibros(){
		a = new ArrayList();// crea el objeto
	}
// metodos de administracion del arreglo
	// adiciona un nuevo Libro
	public void agrega(Libro nuevo){  a.add(nuevo);	}
	// obtiene un Libro
	public Libro getLibro(int i){ return a.get(i) ;	}
	// reemplaza un informacion de un libro
	public void reemplaza(int i, Libro actualizado){
            a.set(i, actualizado);
	}
	// elimina un libro
	public void elimina(int i){  a.remove(i);  }
	// elimina a todos los libros
	public void elimina(){
            for (int i=0; i<numeroLibros(); i++)
		a.remove(0);
        }
	// obtiene numero de libros registrado
	public int numeroLibros(){  return a.size();   }

	// busca un libroo por codigo
	public int busca(String codigo){
            for (int i=0; i<numeroLibros(); i++){
		if (codigo.equalsIgnoreCase(getLibro(i).getCodigo()))
                    return i; // retorna indice
            }
            return -1; // significa que no lo encontró
	}
}
