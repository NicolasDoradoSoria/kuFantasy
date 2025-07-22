package ar.edu.unsam.phm.models

import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "locacion_type")
abstract class Locacion : Identifier {

  @Id
  @GeneratedValue
  override var id: Long = 0

  @Column(nullable = false)
  open lateinit var name: String

  @Column(nullable = false)
  open lateinit var image: String

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  open var parentLocation: Locacion? = null
}