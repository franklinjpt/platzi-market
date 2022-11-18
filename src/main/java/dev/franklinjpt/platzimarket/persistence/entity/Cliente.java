package dev.franklinjpt.platzimarket.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(length = 20, name = "id")
    private String idCliente;

    @Column(length = 40)
    private String nombre;

    @Column(length = 100)
    private String apellidos;

    private Double celular;

    @Column(length = 80)
    private String direccion;

    @Column(name = "correo_electronico", length = 70)
    private String correElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;
}
