package com.ComexUp.Aplicacion.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "boleto")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer idTicket;
    @Column(name = "usuario_id",unique = true)
    private int idUsuario;
    @Column(name = "estado")
    private String estado;
    @Column(name = "title")
    private String titulo;
    private String content;
    private String fecha;
    private String destinatario;

    @ManyToOne
    @JoinColumn(name = "usuario_id",insertable = false,updatable = false)
    private Usuario usuario;

    public Boleto() {
    }
    public Boleto(Integer idTicket, int idUsuario, String titulo, String estado, String content, String fecha, String destinatario, Usuario usuario) {
        this.idTicket = idTicket;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.estado = estado;
        this.content = content;
        this.fecha = fecha;
        this.destinatario = destinatario;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
