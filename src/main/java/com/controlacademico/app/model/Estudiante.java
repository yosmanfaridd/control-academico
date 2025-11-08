package com.controlacademico.app.model;

public class Estudiante {
    private int id;
    private String identificacion;
    private String nombre;
    private String correoInstitucional;
    private String correoPersonal;
    private String telefono;
    private boolean esVocero;
    private String comentarios;
    private String tipoDocumento;
    private String genero;

    public Estudiante() {}

    public Estudiante(int id, String identificacion, String nombre, String correoInstitucional,
                      String correoPersonal, String telefono, boolean esVocero,
                      String comentarios, String tipoDocumento, String genero) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.telefono = telefono;
        this.esVocero = esVocero;
        this.comentarios = comentarios;
        this.tipoDocumento = tipoDocumento;
        this.genero = genero;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreoInstitucional() { return correoInstitucional; }
    public void setCorreoInstitucional(String correoInstitucional) { this.correoInstitucional = correoInstitucional; }

    public String getCorreoPersonal() { return correoPersonal; }
    public void setCorreoPersonal(String correoPersonal) { this.correoPersonal = correoPersonal; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public boolean isEsVocero() { return esVocero; }
    public void setEsVocero(boolean esVocero) { this.esVocero = esVocero; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
