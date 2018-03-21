package Formularios;
//Declaracion de Librerias
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import javax.swing.Icon;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
public final class Arreglo_Objetos extends javax.swing.JFrame {
   // Declarando las clases
   Libro  objLibro;	        // un Libro
   ArregloLibros objArreglo;	// todos los Libros
   DefaultTableModel miModelo;
   String[] cabecera={"Nº","Codigo","Nombre de Libro","Tipo","Clase","Año","Num. Pàg","Costo"};
   String[][] data={};
    //variables globales
    int num = 0;
    public Arreglo_Objetos() {
        initComponents();
        // Seteando el modelo de la tabla
        miModelo=new DefaultTableModel(data,cabecera);
        tblRegistros.setModel(miModelo);
        // objeto que administra la información de los Libros
	objArreglo = new ArregloLibros();
        // proceso de carga de data del archivo al arreglo de objetos
	cargaData();
        //actualizando la tabla
        actualizar_tabla();
        //llamando al metodo resumen para mostrar los datos de salida
        resumen();
        //colocando el cursor en el text Codigo
        jtxtCodigo.requestFocus();
        setLocationRelativeTo(null);
    }

//METODO PARA EXTRAER LA INFORMACION DEL ARCHIVO BINARIO AL ARREGLO DE OBJETOS
public void cargaData(){
	// lee la data del objeto serializado
	try {
	   FileInputStream fis = new FileInputStream("Libros.bin");
	   ObjectInputStream in = new ObjectInputStream(fis);
	   if (in != null){
		objArreglo = (ArregloLibros)in.readObject();
		in.close();
	   }
	}catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error al cargar el archivo binario.."+ex);
	}// fin del catch
}// fin de cargaData

//METODO PARA GRABAR LA INFORMACION DEL ARREGLO DE OBJETOS AL ARCHIVO BINARIO
public void grabar(){
//guarda la data en el archivo serializado
    try{
        FileOutputStream fos = new FileOutputStream("Libros.bin");
        ObjectOutputStream out = new ObjectOutputStream(fos);

	if (out != null){
		out.writeObject(objArreglo);
		out.close();
	}// fin del if
    }catch(IOException ex){
    mensaje("Error en grabacion del archivo"+ex);
    }// fin del catch
}// fin de grabar

//LIMPIA LA TABLA CADA VEZ QUE ESTA SE ACTUALIZA
public void vaciar_tabla()
{
int filas=tblRegistros.getRowCount();
for(int i=0;i<filas;i++)
    miModelo.removeRow(0); // removiendo la fila de la tabla
}

//METODO PARA MOSTRAR LOS MENSAJES DEL APLICATIVO
public void mensaje(String texto){
	JOptionPane.showMessageDialog(this,texto);
}// fin de mensaje


public void actualizar_tabla()
{   vaciar_tabla();// Vaciandola informacion de la tabla
    //capturando el tamaño del arreglo
    int n=objArreglo.numeroLibros();
    for(int i=0;i<n;i++)
    {   // Se extrae la informacion de cada objeto del Arreglo
        String cod = objArreglo.getLibro(i).getCodigo();
        String nom = objArreglo.getLibro(i).getNombre();
        String ti =  objArreglo.getLibro(i).getTipo();
        String cla= objArreglo.getLibro(i).getClase();
        int an=objArreglo.getLibro(i).getAnio();
        int np=objArreglo.getLibro(i).getNum_pag();
        double c=objArreglo.getLibro(i).getCosto();        
        //Insertando la informacion en el Tabla
        insertar(i+1,cod,nom,ti,cla,an,np,c);
    }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jCbxClase = new javax.swing.JComboBox();
        jCbxTipo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jbtnGrabar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtAnio = new javax.swing.JTextField();
        jtxtCosto = new javax.swing.JTextField();
        jtxtNroPag = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jlblImagen = new javax.swing.JLabel();
        jbtnBuscarPortada = new javax.swing.JButton();
        jcbxOrdenar = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jbtnSalir2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("RELACIÓN DE LIBROS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("REGISTRO DE INFORMACIÓN DE LIBROS");

        tblRegistros.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles del Libro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(null);

        jCbxClase.setBackground(new java.awt.Color(204, 204, 255));
        jCbxClase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-SELECCIONE-", "A", "B", "C" }));
        jCbxClase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCbxClaseKeyPressed(evt);
            }
        });
        jPanel1.add(jCbxClase);
        jCbxClase.setBounds(80, 110, 110, 30);

        jCbxTipo.setBackground(new java.awt.Color(204, 204, 255));
        jCbxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----SELECCIONE-------------", "PROGRAMACION", "GESTION", "SISTEMAS" }));
        jCbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbxTipoActionPerformed(evt);
            }
        });
        jCbxTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCbxTipoKeyPressed(evt);
            }
        });
        jPanel1.add(jCbxTipo);
        jCbxTipo.setBounds(280, 20, 180, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo Editorial");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 20, 80, 15);

        jbtnGrabar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/as.jpg"))); // NOI18N
        jbtnGrabar.setText("Grabar");
        jbtnGrabar.setToolTipText("Graba la información en el archivo de Binario");
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnGrabar);
        jbtnGrabar.setBounds(10, 160, 100, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText(" Clase");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 120, 60, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText(" Nombre");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 60, 70, 15);

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyPressed(evt);
            }
        });
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(80, 50, 380, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Año Ed.");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(16, 86, 48, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Costo");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 90, 50, 15);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Nro. Pág.");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(200, 120, 56, 15);

        jtxtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtAnioKeyPressed(evt);
            }
        });
        jPanel1.add(jtxtAnio);
        jtxtAnio.setBounds(80, 80, 50, 30);

        jtxtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCostoKeyPressed(evt);
            }
        });
        jPanel1.add(jtxtCosto);
        jtxtCosto.setBounds(260, 80, 90, 30);

        jtxtNroPag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNroPagKeyPressed(evt);
            }
        });
        jPanel1.add(jtxtNroPag);
        jtxtNroPag.setBounds(260, 110, 90, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Còdigo");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(16, 24, 43, 15);

        jtxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCodigoKeyPressed(evt);
            }
        });
        jPanel1.add(jtxtCodigo);
        jtxtCodigo.setBounds(80, 20, 100, 26);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/buscar_cliente.gif"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("Busca la información del Arreglo");
        btnConsultar.setMaximumSize(new java.awt.Dimension(121, 59));
        btnConsultar.setMinimumSize(new java.awt.Dimension(21, 59));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultar);
        btnConsultar.setBounds(110, 160, 130, 30);

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/page_edit.gif"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Actualiza los datos en el Arreglo y Archivo");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(239, 160, 106, 30);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/editdelete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Elimina un registro en el Archivo Binario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(350, 160, 110, 30);

        jlblImagen.setBackground(new java.awt.Color(153, 255, 255));
        jlblImagen.setForeground(new java.awt.Color(0, 102, 102));
        jlblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlblImagen.setOpaque(true);
        jPanel1.add(jlblImagen);
        jlblImagen.setBounds(480, 20, 140, 170);

        jbtnBuscarPortada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnBuscarPortada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/logo.gif"))); // NOI18N
        jbtnBuscarPortada.setText("Portada");
        jbtnBuscarPortada.setToolTipText("Busca la imagen de la Portada del libro");
        jbtnBuscarPortada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnBuscarPortada.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbtnBuscarPortada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarPortadaActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscarPortada);
        jbtnBuscarPortada.setBounds(350, 80, 110, 60);

        jcbxOrdenar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno", "Codigo", "Nombre", "Tipo de Editorial", "Clase", "Año de Edición", "Nro de Páginas", "Costo" }));
        jcbxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxOrdenarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar por");

        jbtnSalir2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProy/salir.JPG"))); // NOI18N
        jbtnSalir2.setText("Salir");
        jbtnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalir2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(jLabel5)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jLabel1)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                    .add(jcbxOrdenar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 630, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 630, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(jLabel6)
                        .add(18, 18, 18)
                        .add(jbtnSalir2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jbtnSalir2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jcbxOrdenar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, 0, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    void resumen()
 {  //Declaración de las variables para la extracción de datos
    String sA="",sB="",sD1="",sD2="";
    int mayor=-99,menor=999999,sC=0;
    double maycos=-99;
    int n=objArreglo.numeroLibros(); //Numero de Libros   
    for(int i=0;i<n;i++)
    {   // Se extrae la informacion de cada objeto del Arreglo
        String cod = objArreglo.getLibro(i).getCodigo();
        String nombre = objArreglo.getLibro(i).getNombre();
        String tipo =  objArreglo.getLibro(i).getTipo();
        String clase= objArreglo.getLibro(i).getClase();
        int anio=objArreglo.getLibro(i).getAnio();
        int num_pag=objArreglo.getLibro(i).getNum_pag();
        double costo=objArreglo.getLibro(i).getCosto();
        //calculando los datos de salida
       //Nombre del Libro con el Año de Edición más reciente
           if(anio>mayor)
            {  mayor=anio;
               sA=nombre; }
       //Nombre de la Editorial que tiene el libro con el Menor número de páginas.
            if(num_pag<menor)
             {  menor=num_pag;
                sB=tipo; }
       //Numero de Libros que supera el costo de S/ 100 que sean de la Editorial A
       //y sean de Gestión
           if(costo>100 && tipo.equalsIgnoreCase("GESTION") && clase.equalsIgnoreCase("A"))
               sC++;
        //Nombre del Libro que tenga el mayor costo y a que editorial del pertenece.
           if(costo>maycos)
             {  maycos=costo;
                sD1=nombre;
                sD2=tipo; }
         }   
            //colocando la información en los TextField
              
 }

 
 public void eliminar(){
    // se llamada metodo consulta para ver los datos a borrar
    consulta();    
    //Se llama al metodo busca en el arreglo que devuelve la posicion
    // del codigo buscado
    int p = objArreglo.busca(jtxtCodigo.getText().toUpperCase());
    if (p!=-1)
    {
       int r = JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar a éste registro ?"
                ,"Reponder",0);
       if (r==0)// si
       {   objArreglo.elimina(p); // eliminado el objeto en la posicion p
           limpiar_entradas();//Limpiando las entradas
           grabar(); // grabamos la informacion en el archivo binario
           actualizar_tabla();//actualizando la tabla
           //llamando al metodo resumen para mostrar los datos de salida
           resumen();
          jtxtCodigo.requestFocus();//colocando el cursor en el text Codigo
       }
    }// fin del else

}// fin de elimina

public void modifica(){
                String cod = jtxtCodigo.getText().toUpperCase();
                // se vuelve a buscar el codigo para no repetir el mismo
		int p=objArreglo.busca(cod);
                 //Se leen los datos de entrada de los TextField
                 String nom = jtxtNombre.getText().toUpperCase();
                 String ti =  jCbxTipo.getSelectedItem().toString();
                 String cla=jCbxClase.getSelectedItem().toString();
                 int an=Integer.parseInt(jtxtAnio.getText());
                 int np=Integer.parseInt(jtxtNroPag.getText());
                 double c=Double.parseDouble(jtxtCosto.getText());
                 Icon por=jlblImagen.getIcon();
                 //Generando la clase para manejar un libro
                objLibro = new Libro(cod,nom,ti,cla,an,np,c,por);
                // Verificando si el codigo existe dentro del arreglo
		if (p==-1)// codigo nuevo
			objArreglo.agrega(objLibro);
		else// codigo ya existente
			objArreglo.reemplaza(p,objLibro);
                limpiar_entradas();//Limpiando las entradas
                grabar(); // grabamos la informacion en el archivo binario
	        actualizar_tabla();//actualizando la tabla
                //llamando al metodo resumen para mostrar los datos de salida
                resumen();
               //colocando el cursor en el text Codigo
                jtxtCodigo.requestFocus();
}// fin de modifica

    public void consulta(){
    String cod = jtxtCodigo.getText().toUpperCase();
    //Se llama al metodo busca en el arreglo que devuelve la posicion
    // del codigo buscado     	
    int p = objArreglo.busca(cod);
	if (p==-1)
        {  mensaje("Codigo no existe");
           limpiar_entradas();    }
	else{
		// se extrae todo el objeto con toda la informacion
                objLibro = objArreglo.getLibro(p);
                // se extrae la informacion de los campos del objeto
                //String cod = objLibro.getCodigo();
                String nombre = objLibro.getNombre();
                String tipo =  objLibro.getTipo();
                String clase= objLibro.getClase();
                int anio=objLibro.getAnio();
                int num_pag=objLibro.getNum_pag();
                double costo=objLibro.getCosto();  
                //colocando la informacion en los objetos
                jtxtNombre.setText(nombre);
                //colocando la informacion en el combobox tipo
                if(tipo.equalsIgnoreCase("PROGRAMACION"))
                    jCbxTipo.setSelectedIndex(1);
                else if(tipo.equalsIgnoreCase("GESTION"))
                        jCbxTipo.setSelectedIndex(2);
                else if(tipo.equalsIgnoreCase("SISTEMAS"))
                          jCbxTipo.setSelectedIndex(3);               
                //colocando la informacion en el combobox clase
                if(clase.equalsIgnoreCase("A"))
                    jCbxClase.setSelectedIndex(1);
                else if(clase.equalsIgnoreCase("B"))
                        jCbxClase.setSelectedIndex(2);
                else if(clase.equalsIgnoreCase("C"))
                          jCbxClase.setSelectedIndex(3);           
                // Informacion para los text field y la portada del libro
                jtxtNombre.setText(nombre);
                jtxtAnio.setText(String.valueOf(anio));
                jtxtNroPag.setText(String.valueOf(num_pag));
                jtxtCosto.setText(String.valueOf(costo));
                jlblImagen.setIcon(objLibro.getPortada());
	}
    }


    void limpiar_entradas() {
        jtxtCodigo.setText("");
        jtxtNombre.setText("");
        jtxtAnio.setText("");
        jtxtNroPag.setText("");
        jtxtCosto.setText("");
        //deseleccionando los ComboBox
        jCbxTipo.setSelectedIndex(0);
        jCbxClase.setSelectedIndex(0);
        jtxtCodigo.requestFocus(true);
        //Colocando sin iconos en el jlblImagen        
        jlblImagen.setIcon(null);
    }

    void insertar(int num,String codigo,String nombre,String tipo,String clase,
            int anio,int num_pag,double costo)
    {
        String co;
        //dando Formato al sueldo
        DecimalFormat df2 = new DecimalFormat("####.00");
        //co = String.format("%-10s%10.2f",costo);
        co=df2.format(costo);
        Object[] fila={num,codigo,nombre,tipo,clase,String.valueOf(anio),
                        String.valueOf(num_pag),co};
        miModelo.addRow(fila);
    }   
    
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jCbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbxTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbxTipoActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed
       //Se leen los datos de entrada de los TextField
        String cod = jtxtCodigo.getText().toUpperCase();
        String nom = jtxtNombre.getText().toUpperCase();
        String ti =  jCbxTipo.getSelectedItem().toString();
        String cla=jCbxClase.getSelectedItem().toString();
        int an=Integer.parseInt(jtxtAnio.getText());
        int np=Integer.parseInt(jtxtNroPag.getText());
        double c=Double.parseDouble(jtxtCosto.getText());
        Icon por=jlblImagen.getIcon();
        //Generando la clase para manejar un libro
        objLibro = new Libro(cod,nom,ti,cla,an,np,c,por);
	// Verificando si el codigo existe dentro del arreglo	
        if (objArreglo.busca(objLibro.getCodigo())!=-1)
	     mensaje("Codigo Repetido"); // se muestra mensaje
	else			
        {   objArreglo.agrega(objLibro); // se agrega el objeto al arreglo
            //Insertando la informacion en el Tabla
            insertar(0,cod,nom,ti,cla,an,np,c);
           //Limpiando las entradas
            limpiar_entradas();
           //Grabando la informacion en el archivo binario
            grabar();
           //actualizando la tabla
            actualizar_tabla();
           // llamda al metodo resumen para ver los datos de salida
        resumen();
        }
    }//GEN-LAST:event_jbtnGrabarActionPerformed




    private void jtxtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyPressed
    if(evt.getKeyCode()==evt.VK_ENTER)
        jCbxTipo.requestFocus();
    }//GEN-LAST:event_jtxtNombreKeyPressed

    private void jCbxTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCbxTipoKeyPressed
      if(evt.getKeyCode()==evt.VK_ENTER)
        jtxtAnio.requestFocus();
    }//GEN-LAST:event_jCbxTipoKeyPressed

    private void jtxtNroPagKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNroPagKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
            jtxtCosto.requestFocus();
    }//GEN-LAST:event_jtxtNroPagKeyPressed

    private void jtxtAnioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAnioKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
             jtxtNroPag.requestFocus();
    }//GEN-LAST:event_jtxtAnioKeyPressed

    private void jtxtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCostoKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
            jCbxClase.requestFocus();
    }//GEN-LAST:event_jtxtCostoKeyPressed

    private void jCbxClaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCbxClaseKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
             jbtnGrabar.requestFocus();
    }//GEN-LAST:event_jCbxClaseKeyPressed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // Llamada al metodo para hacer la consulta
        consulta();
}//GEN-LAST:event_btnConsultarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // llamada al metodo que modifica la informacion del Libro
        modifica();
}//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Llamada al metodo que elimina un registro
        eliminar();
}//GEN-LAST:event_btnEliminarActionPerformed

    private void jcbxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxOrdenarActionPerformed
      switch(jcbxOrdenar.getSelectedIndex())
       {  case 0: cargaData(); // carga la data nuevamente
                  actualizar_tabla(); // actualiza la tabla nuevamente
                  break;
          case 1: ord_PorCodigo();break;
          case 2: ord_PorNombre();break;
          case 3: ord_PorTipo();break;
          case 4: ord_PorClase();break;
          case 5: ord_PorAnio();break;
          case 6: ord_PorNumPag();break;
          case 7: ord_PorCosto();break;
      }
    }//GEN-LAST:event_jcbxOrdenarActionPerformed

    private void jtxtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCodigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoKeyPressed

    private void jbtnBuscarPortadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarPortadaActionPerformed
        JFileChooser dlg= new JFileChooser();       
        int option= dlg.showOpenDialog(this);// abre la ventana de dialogo 
        // si hace click en boton abrir del dialogo
        if(option == JFileChooser.APPROVE_OPTION) {
            // obtiene nombre de archivo seleccionado
            String file= dlg.getSelectedFile().getPath();
            jlblImagen.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            // se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140,170,java.awt.Image.SCALE_SMOOTH);
            // se genera el Image icon con la nueva imagen
            ImageIcon newIcon = new ImageIcon(newimg);
            jlblImagen.setIcon(newIcon); // se coloca el nuevo icono modificado
            jlblImagen.setSize(140,170); // se cambia el tamaño de la etiqueta
        }
}//GEN-LAST:event_jbtnBuscarPortadaActionPerformed

    private void jbtnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtnSalir2ActionPerformed

//                        METODOS DE ORDENAMIENTO
    void ord_PorCodigo()
    {   int n=objArreglo.numeroLibros();
        int menor;
        Libro aux;
        for (int p=0; p <n-1; p++)
        {   menor=p;
            for(int q=(p+1);q<n;q++)
           {  //Extrayendo los codigos de los libros
               String codActual=objArreglo.getLibro(q).getCodigo();
               String codMenor=objArreglo.getLibro(menor).getCodigo();
               if(codActual.compareToIgnoreCase(codMenor)<0)
                 { menor=q; }
	     }// fin del for
             aux = objArreglo.getLibro(p);
             objArreglo.reemplaza(p,objArreglo.getLibro(menor));
             objArreglo.reemplaza(menor, aux);
       }
        actualizar_tabla();
    }

    void ord_PorNombre()
    {
        int n=objArreglo.numeroLibros();
        Libro aux;
        for (int q=0; q <(n-1); q++)
         {  for(int p=0;p<(n-1)-q;p++)
             {  //Extrayendo los nombres d elos libros
               String nomAnt=objArreglo.getLibro(p).getNombre();
               String nomSig=objArreglo.getLibro(p+1).getNombre();
               if(nomAnt.compareToIgnoreCase(nomSig)>0)
                 {  aux = objArreglo.getLibro(p);
                    objArreglo.reemplaza(p,objArreglo.getLibro(p+1));
                    objArreglo.reemplaza(p+1, aux);
                 }
	     }// fin del for
       }
        actualizar_tabla();
    }
    
    void ord_PorTipo()
    {   int n=objArreglo.numeroLibros();
        int j;
        Libro aux;
        for (int i=1; i<n; i++)
        {   j=i;
           while(j!=0)
           {  //Extrayendo los codigos de los libros
               String tipoActual=objArreglo.getLibro(j).getTipo();
               String tipoAnt=objArreglo.getLibro(j-1).getTipo();
               if(tipoActual.compareToIgnoreCase(tipoAnt)<0)
                 {   aux = objArreglo.getLibro(j);
                     objArreglo.reemplaza(j,objArreglo.getLibro(j-1));
                     objArreglo.reemplaza(j-1, aux);                   
                 }
               else j=1;
               j=j-1;
	     }// fin del for 
       }
        actualizar_tabla();
    }

    void ord_PorClase()
    {
        int n=objArreglo.numeroLibros();
        Libro aux;
        for (int q=0; q <(n-1); q++)
         {  for(int p=0;p<(n-1)-q;p++)
             {  //Extrayendo los nombres d elos libros
               String claseAnt=objArreglo.getLibro(p).getClase();
               String claseSig=objArreglo.getLibro(p+1).getClase();
               if(claseAnt.compareToIgnoreCase(claseSig)>0)
                 {  aux = objArreglo.getLibro(p);
                    objArreglo.reemplaza(p,objArreglo.getLibro(p+1));
                    objArreglo.reemplaza(p+1, aux);
                 }
	     }// fin del for
       }
        actualizar_tabla();
    }

       void ord_PorAnio()
    {   int n=objArreglo.numeroLibros();
        int j;
        Libro aux;
        for (int i=1; i<n; i++)
        {   j=i;
           while(j!=0)
           {  //Extrayendo los codigos de los libros
               int anioActual=objArreglo.getLibro(j).getAnio();
               int anioAnt=objArreglo.getLibro(j-1).getAnio();
               if(anioActual<anioAnt)
                 {   aux = objArreglo.getLibro(j);
                     objArreglo.reemplaza(j,objArreglo.getLibro(j-1));
                     objArreglo.reemplaza(j-1, aux);
                 }
               else j=1;
               j=j-1;
	     }// fin del for
       }
        actualizar_tabla();
    }

  void ord_PorNumPag()
    {   int n=objArreglo.numeroLibros();
        int menor;
        Libro aux;
        for (int p=0; p <n-1; p++)
        {   menor=p;
            for(int q=(p+1);q<n;q++)
           {  //Extrayendo los codigos de los libros
               int npActual=objArreglo.getLibro(q).getNum_pag();
               int npMenor=objArreglo.getLibro(menor).getNum_pag();
               if(npActual<npMenor)
                 { menor=q;
                 }
	     }// fin del for
             aux = objArreglo.getLibro(p);
             objArreglo.reemplaza(p,objArreglo.getLibro(menor));
             objArreglo.reemplaza(menor, aux);
       }
        actualizar_tabla();
    }

   void ord_PorCosto()
    {   int n=objArreglo.numeroLibros();
        int menor;
        Libro aux;
        for (int p=0; p <n-1; p++)
        {   menor=p;
            for(int q=(p+1);q<n;q++)
           {  //Extrayendo los codigos de los libros
               double cActual=objArreglo.getLibro(q).getCosto();
               double cMenor=objArreglo.getLibro(menor).getCosto();
               if(cActual<cMenor)
                 { menor=q;
                 }
	     }// fin del for
             aux = objArreglo.getLibro(p);
             objArreglo.reemplaza(p,objArreglo.getLibro(menor));
             objArreglo.reemplaza(menor, aux);
       }
        actualizar_tabla();
    }


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Arreglo_Objetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jCbxClase;
    private javax.swing.JComboBox jCbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscarPortada;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnSalir2;
    private javax.swing.JComboBox jcbxOrdenar;
    private javax.swing.JLabel jlblImagen;
    private javax.swing.JTextField jtxtAnio;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtCosto;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNroPag;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables

}
