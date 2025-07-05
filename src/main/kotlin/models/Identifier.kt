package ar.edu.unsam.phm.models

interface Identifier {

  var id: Long
  abstract fun validate()
  fun isNew (): Boolean = id == -1L
}