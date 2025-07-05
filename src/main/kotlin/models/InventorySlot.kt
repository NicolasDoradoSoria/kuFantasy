package ar.edu.unsam.phm.models

import jakarta.persistence.*

@Entity
@Table(name = "inventory_slots")
class InventorySlot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long = 0

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id", nullable = false)
  lateinit var item: Item

  @Column(nullable = false)
  var quantity: Int = 1

  companion object {
    fun create(item: Item, quantity: Int = 1): InventorySlot {
      val slot = InventorySlot()
      slot.item = item
      slot.quantity = quantity
      return slot
    }
  }
}