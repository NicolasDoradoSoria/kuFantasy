package ar.edu.unsam.phm.booststrap

import ar.edu.unsam.phm.dao.ItemRepository
import ar.edu.unsam.phm.dao.StoreRepository
import ar.edu.unsam.phm.dao.TerritoryRepository
import ar.edu.unsam.phm.dao.UserRepository
import ar.edu.unsam.phm.models.*
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataInitializer : InitializingBean {

  @Autowired
  private lateinit var userRepository: UserRepository

  @Autowired
  private lateinit var territoryRepository: TerritoryRepository

  @Autowired
  private lateinit var itemRepository: ItemRepository

  @Autowired
  private lateinit var storeRepository: StoreRepository


  //***********************
  // ITEM
  //***********************

  val espadaMagica = Item().apply {
    name = "Espada Mágica"
    description = "Una espada con poder arcano"
    weight = 10
    price = 150.0
    attack = 25
    image = "espada.jpg"
  }

  val escudoHierro = Item().apply {
    name = "Escudo de Hierro"
    description = "Un escudo resistente"
    weight = 15
    price = 100.0
    defense = 20
    image = "escudo.jpg"
  }


  //***********************
  // TERRITORY
  //***********************

  val bosque = Territory().apply {
    name = "Bosque Encantado"
    history = "Un bosque misterioso lleno de magia."
    image = "bosque.jpg"
    subLocations = listOf(
      Territory().apply {
        name = "Cueva Secreta"
        history = "Una cueva oculta llena de tesoros."
        image = "cueva.jpg"
      },
      Territory().apply {
        name = "Lago Místico"
        history = "Un lago con propiedades curativas."
        image = "lago.jpg"
      }
    )
  }
  val torre = Territory().apply {
    name = "Torre Arcana"
    history = "Una antigua torre de hechicería prohibida."
    image = "torre.jpg"
    subLocations = listOf(
      Territory().apply {
        name = "Sala de Hechizos"
        history = "Una sala llena de libros de magia."
        image = "sala.jpg"
      },
      Territory().apply {
        name = "Observatorio"
        history = "Un lugar para observar las estrellas."
        image = "observatorio.jpg"
      }
    )
  }

  val desierto = Territory().apply {
    name = "Desierto del Olvido"
    history = "Nadie recuerda qué ocurrió aquí..."
    image = "desierto.jpg"
    subLocations = listOf(
      Territory().apply {
        name = "Oasis Perdido"
        history = "Un oasis escondido en el desierto."
        image = "oasis.jpg"
      },
      Territory().apply {
        name = "Ruinas Antiguas"
        history = "Ruinas de una civilización olvidada."
        image = "ruinas.jpg"
      }
    )
  }

  //***********************
  // Store
  //***********************

  val tienda = Store().apply {
    name = "Tienda Mágica"
    territory = bosque
  }
  val tienda2 = Store().apply {
    name = "Tienda Mágica"
    territory = torre
  }
  val tienda3 = Store().apply {
    name = "Tienda Mágica"
    territory = desierto
  }




  //***********************
  //USERS
  //***********************

  val valen = User().apply {
    mail = "valen@example.com"
    password = "password"
    name = "Valentino"
    defense = 20
    life = 100
    magic = 50
    attack = 30
    speed = 10
    exp = 150
    level = 2
    totalCapacity = 100
    balance = 250.0
    currentLocacion = bosque
    role = IndividualRole.COMMON
    inventory = listOf(
      InventorySlot().apply {
        item = espadaMagica
        quantity = 1
      },
      InventorySlot().apply {
        item = escudoHierro
        quantity = 1
      }
    )
  }

  val cris = User().apply {
    mail = "cris@example.com"
    password = "password"
    name = "Cristina"
    defense = 15
    life = 120
    magic = 20
    attack = 40
    speed = 15
    exp = 300
    level = 3
    totalCapacity = 120
    balance = 300.0
    currentLocacion = torre
    role = IndividualRole.COMMON
    type = UserType.PLAYER
  }

  val mati = User().apply {
    mail = "mati@example.com"
    password = "admin123"
    name = "Matías"
    defense = 40
    life = 200
    magic = 80
    attack = 70
    speed = 20
    exp = 800
    level = 5
    totalCapacity = 200
    balance = 800.0
    currentLocacion = desierto
    role = IndividualRole.COMMON
    type = UserType.PLAYER
  }

  val juana = User().apply {
    mail = "juana@example.com"
    password = "juana123"
    name = "Juana"
    defense = 25
    life = 90
    magic = 60
    attack = 20
    speed = 25
    exp = 200
    level = 2
    totalCapacity = 110
    balance = 190.0
    currentLocacion = desierto
    role = IndividualRole.COMMON
    type = UserType.PLAYER
  }

  fun createItems() {
    itemRepository.apply {
      create(espadaMagica)
      create(escudoHierro)
    }
    println("items agregados")
  }

  fun createUsers() {
    userRepository.apply {
      create(valen)
      create(cris)
      create(juana)
      create(mati)
    }
    println("usuarios agregados")
  }

  fun createTerritories() {
    territoryRepository.apply {
      create(torre)
      create(desierto)
      create(bosque)
    }
    println("territorios agregados")
  }

  fun createStores() {
    storeRepository.apply {
      create(tienda)
      create(tienda2)
      create(tienda3)
    }
    println("tiendas agregadas")
  }
  override fun afterPropertiesSet() {
    this.createUsers()
    this.createTerritories()
    this.createStores()
    this.createItems()
  }
}