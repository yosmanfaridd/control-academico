package com.controlacademico.app.model;

public class Calificacion {

    private int calificacionId;
    private int estudianteId;
    private int componenteEvaluacionId;
    private double nota;
    private String comentariosCalificacion;

    
    public Calificacion() {
    }

    
    public Calificacion(int calificacionId, int estudianteId, int componenteEvaluacionId,
                        double nota, String comentariosCalificacion) {
        this.calificacionId = calificacionId;
        this.estudianteId = estudianteId;
        this.componenteEvaluacionId = componenteEvaluacionId;
        this.nota = nota;
        this.comentariosCalificacion = comentariosCalificacion;
    }

     
    public int getCalificacionId() {
        return calificacionId;
    }

    public void setCalificacionId(int calificacionId) {
        this.calificacionId = calificacionId;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getComponenteEvaluacionId() {
        return componenteEvaluacionId;
    }

    public void setComponenteEvaluacionId(int componenteEvaluacionId) {
        this.componenteEvaluacionId = componenteEvaluacionId;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentariosCalificacion() {
        return comentariosCalificacion;
    }

    public void setComentariosCalificacion(String comentariosCalificacion) {
        this.comentariosCalificacion = comentariosCalificacion;
    }

   
    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + calificacionId +
                ", estudianteId=" + estudianteId +
                ", componenteEvaluacionId=" + componenteEvaluacionId +
                ", nota=" + nota +
                ", comentarios='" + comentariosCalificacion + '\'' +
                '}';
    }
}
