package com.ComexUp.Aplicacion.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "usuario_id")
    private Integer idUsuario;
    private String nombre;
    private String apellidos;
    @Column (unique = true)
    private String email;
    private String password;
    private int rol;
    @OneToMany(mappedBy = "usuario")
    private List<Boleto> Boletos;
    @OneToMany(mappedBy = "usuario")
    private List<Comprobante> comprobantes;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public List<Boleto> getBoletos() {
        return Boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        Boletos = boletos;
    }

    public List<Comprobante> getComprobantes() {
        return comprobantes;
    }

    public void setComprobantes(List<Comprobante> comprobantes) {
        this.comprobantes = comprobantes;
    }
}
