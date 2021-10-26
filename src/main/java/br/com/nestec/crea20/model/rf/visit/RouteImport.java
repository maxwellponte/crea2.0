package br.com.nestec.crea20.model.rf.visit;

import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "rota_importacao")
@Entity
public class RouteImport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_que_importou_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private User userImport;
    @Column(name = "data_hora_importacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHourImport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_ID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_rota_arquivo"))
    private RouteFile file;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Company company;
}