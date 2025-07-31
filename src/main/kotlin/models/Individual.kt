package ar.edu.unsam.phm.models

import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.enums.UserType
import ar.edu.unsam.phm.utils.exceptions.BusinessException
import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Individual :Combatant(), Identifier {

  @Id @GeneratedValue
  override var id: Long = 0
  open lateinit var lastName: String
  open var exp: Int = 0
  open var totalCapacity: Int = 0
  open var balance: Double = 0.0
  open lateinit var imageUrl: String
  @ManyToOne(fetch = FetchType.LAZY)
  open lateinit var currentLocacion: Territory

  @Enumerated(EnumType.STRING)
  open lateinit var role: IndividualRole

  @Enumerated(EnumType.STRING)
  open var type: UserType = UserType.PLAYER

  @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
  open var inventory: MutableList<InventorySlot> = mutableListOf()

  @ManyToOne(fetch = FetchType.LAZY)
  var race: Race? = null
  override fun validate() {
    if (name.isBlank()) {
      throw IllegalArgumentException("Name cannot be blank")
    }
    if (defense < 0 || life < 0 || magic < 0 || attack < 0 || speed < 0) {
      throw IllegalArgumentException("Attributes cannot be negative")
    }
    if (exp < 0 || level < 1 || totalCapacity < 0 || balance < 0) {
      throw IllegalArgumentException("Experience, level, total capacity, and balance must be non-negative")
    }
    if (!::currentLocacion.isInitialized) {
      throw IllegalArgumentException("Current location must be initialized")
    }
    if (!::role.isInitialized) {
      throw IllegalArgumentException("Role must be initialized")
    }
  }

  fun addItem(item: Item, quantity: Int = 1) {
    val existing = inventory.find { it.item.id == item.id }
    if (existing != null) {
      existing.quantity += quantity
    } else
      inventory.add(InventorySlot.create(item, quantity))
  }

  fun buyItemFrom(seller: Individual, itemId: Long){
    if (seller.role != IndividualRole.MERCHANT)
      throw BusinessException("Solo se puede comprar a individuos con rol MERCHANT.")

    if(this.currentLocacion != seller.currentLocacion)
      throw BusinessException("No estás en la misma locación que el vendedor para comprar este ítem.")

    val itemSlot = seller.inventory.find { it.item.id == itemId }
      ?: throw BusinessException("El vendedor no tiene el ítem con id ${itemId} en su inventario.")

    val item = itemSlot.item
    val price = item.price

    if(this.balance < price)
      throw BusinessException("No tenés suficiente dinero para comprar el ítem con id ${itemId}.")

    if(itemSlot.quantity == 1)
      seller.inventory.remove(itemSlot)
    else
      itemSlot.quantity -= 1

    this.addItem(item)
    this.balance -= price
    seller.balance += price
  }
}