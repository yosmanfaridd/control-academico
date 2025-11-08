package com.controlacademico.app.model;

import java.sql.Date;

public class PeriodoAcademico {

    private int periodoAcademicoId;
    private String nombrePeriodo;
    private Date fechaInicio;
    private Date fechaFin;

    // 🔹 Constructor vacío
    public PeriodoAcademico() {
    }

    // 🔹 Constructor completo
    public PeriodoAcademico(int periodoAcademicoId, String nombrePeriodo, Date fechaInicio, Date fechaFin) {
        this.periodoAcademicoId = periodoAcademicoId;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // 🔹 Getters y Setters
    public int getPeriodoAcademicoId() {
        return periodoAcademicoId;
    }

    public void setPeriodoAcademicoId(int periodoAcademicoId) {
        this.periodoAcademicoId = periodoAcademicoId;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    // 🔹 Método toString (para imprimir fácilmente)
    @Override
    public String toString() {
        return "PeriodoAcademico{" +
                "id=" + periodoAcademicoId +
                ", nombrePeriodo='" + nombrePeriodo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
