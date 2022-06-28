
package com.pratica01.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estado")
public class Estado {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado;
    String pais;
    String capital;
    String playa;
    String descripcion;
    String hotel;

    public Estado() {
    }

    public Estado(String pais, String capital, String playa, String descripcion, String hotel) {
        this.pais = pais;
        this.capital = capital;
        this.playa = playa;
        this.descripcion = descripcion;
        this.hotel = hotel;
    }
    
}
