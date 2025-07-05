package ar.edu.unsam.phm.models

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany


@Entity
class House : Place() {

  @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
  var residents: MutableList<Individual> = mutableListOf()


}