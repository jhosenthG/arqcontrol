package com.module.arqcontrol.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "Project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false, length = 255)
    private Long id;

    @Column(name = "project_name", nullable = false, length = 255) // Rooftop Sando Domingo Club
    private String name;

    @Column(name = "project_number", nullable = false, unique = true, length = 64)
    private String projectNumber;

    @Enumerated(EnumType.STRING)
    private StateEntity state;

    private LocalDateTime LastModification;

    @OneToMany(mappedBy = "Project", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<DocumentEntity> documents;

    @ManyToMany
    @JoinTable(
            name = "project_architect",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "architect_id")
    )
    @ToString.Exclude
    private List<TeamMemberEntity> architects;
}

