package com.module.arqcontrol.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "document_modifications")
public class ModificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String revNumber; // Ej: Rev. 1

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private StateEntity status; // Estado de la revisión (e.g. APPROVED)

    // Relación Many-to-One al Documento
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", nullable = false)
    @ToString.Exclude
    private DocumentEntity document;

    // Relación Many-to-One al Responsable (Miembro del Equipo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_id")
    @ToString.Exclude
    private TeamMemberEntity responsible;
}