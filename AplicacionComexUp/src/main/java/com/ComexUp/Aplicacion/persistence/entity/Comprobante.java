package com.ComexUp.Aplicacion.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comprobante_id")
    private Integer idComprobante;
    @Column(name = "usuario_id")
    private int idUsuario;
    @Column(name = "infocomprobante")
    private String infoComprobante;

    @ManyToOne
    @JoinColumn(name = "usuario_id",insertable = false,updatable = false)
    private Usuario usuario;

    public Integer getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(Integer idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getInfoComprobante() {
        return infoComprobante;
    }

    public void setInfoComprobante(String infoComprobante) {
        this.infoComprobante = infoComprobante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
