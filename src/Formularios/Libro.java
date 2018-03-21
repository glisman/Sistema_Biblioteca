package Formularios;
import java.io.Serializable;
import javax.swing.*;
public class Libro implements Serializable {
    // atributos    
    private String codigo;
    private String nombre;
    private String tipo;
    private String clase;
    private int anio;
    private int num_pag;
    private double costo;
    private Icon portada;
	// constructor vacio
	public Libro(){	}
	// constructor con parametros
	public Libro(String codigo,String nombre,String tipo,String clase,int anio,
                         int num_pag,double costo,Icon porta){
		this.codigo=codigo;
                this.nombre = nombre;
		this.tipo = tipo;
		this.clase = clase;
                this.anio=anio;
                this.num_pag=num_pag;
                this.costo=costo;
                this.portada=porta;
	}
    public String getCodigo() { 
        return codigo; 
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo; 
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getClase() {
        return clase; 
    }
    public void setClase(String clase) {
        this.clase = clase;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio; 
    }    
    public int getNum_pag() { 
        return num_pag;  
    }
    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag; 
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) { 
        this.costo = costo; 
    }   
    public Icon getPortada() { 
        return portada;  
    }
    public void setPortada(Icon portada) { 
        this.portada = portada; 
    }
}
