package ar.edu.unsam.phm.booststrap

import ar.edu.unsam.phm.dao.*
import ar.edu.unsam.phm.models.*
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.UserType

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.slf4j.LoggerFactory
@Service
class DataInitializer : InitializingBean {

  @Autowired
  private lateinit var userRepository: UserRepository

  @Autowired
  private lateinit var individualRepository: IndividualRepository

  @Autowired
  private lateinit var territoryRepository: TerritoryRepository

  @Autowired
  private lateinit var itemRepository: ItemRepository

  @Autowired
  private lateinit var storeRepository: StoreRepository

  @Autowired
  private lateinit var houseRepository : HouseRepository

  @Autowired
  private lateinit var placeRepository: PlaceRepository

  private val logger = LoggerFactory.getLogger(DataInitializer::class.java)


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

  val casco= Item().apply {
    name = "Casco de Hierro"
    description = "Un casco resistente"
    weight = 5
    price = 50.0
    defense = 10
    image = "casco.jpg"
  }
  //***********************
  // INVENTORY SLOTS
  //***********************

  val cascoSlot = InventorySlot().apply {
    item = casco
    quantity = 1
  }
  val bowSlot = InventorySlot().apply {
    item = Item().apply {
      name = "Arco Élfico"
      description = "Arco preciso y liviano"
      weight = 5
      price = 120.0
      attack = 15
      image = "arco.jpg"
    }
    quantity = 1
  }

  val ringSlot = InventorySlot().apply {
    item = Item().apply {
      name = "Anillo de Invisibilidad"
      description = "Te hace invisible por unos segundos"
      weight = 1
      price = 300.0
      image = "anillo.jpg"
    }
    quantity = 1
  }

  val pantrySlot = InventorySlot().apply {
    item = Item().apply {
      name = "Pan de la Comarca"
      description = "Muy nutritivo y sabroso"
      weight = 2
      price = 5.0
      image = "pan.jpg"
    }
    quantity = 10
  }
  val mesa = InventorySlot().apply {
    item = Item().apply {
      name = "mesa"
      description = "mesa muy pesada"
      weight = 2
      price = 5.0
      image = "pan.jpg"
    }
    quantity = 11
  }



  //***********************
  // Store
  //***********************

  val tienda = Store().apply {
    name = "Armeria"
    image = "legolas_house.jpg"
    inventory= mutableListOf(mesa)
  }

  val tienda2 = Store().apply {
    name = "Carpinteria"
    image = "legolas_house.jpg"
  }
  val tienda3 = Store().apply {
    name = "Alquimia"
    image = "legolas_house.jpg"
  }
  val tienda4 = Store().apply {
    name = "Herreria"
    image = "legolas_house.jpg"
  }
  val tienda5 = Store().apply {
    name = "Posada"
    image = "legolas_house.jpg"
  }

  //***********************
  // TERRITORY
  //***********************

  val bosque = Territory().apply {
    name = "Bosque Encantado"
    history = "Un bosque misterioso lleno de magia."
    image = "bosque.jpg"
  }

  val torre = Territory().apply {
    name = "Torre Arcana"
    history = "Una antigua torre de hechicería prohibida."
    image = "torre.jpg"
  }

  val desierto = Territory().apply {
    name = "Desierto del Olvido"
    history = "Nadie recuerda qué ocurrió aquí..."
    image = "desierto.jpg"
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
    currentLocacion = torre
    role = IndividualRole.COMMON
    type = UserType.PLAYER
    inventory = mutableListOf(
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
    currentLocacion = desierto
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
  val albertoComerciante = Individual().apply {
    name = "alberto"
    defense = 1
    life = 2
    magic = 1
    attack = 2
    speed = 1
    exp = 1
    level = 1
    totalCapacity = 110
    balance = 1000.0
    currentLocacion = desierto
    role = IndividualRole.MERCHANT
    type = UserType.NPC
    inventory = mutableListOf(cascoSlot)
  }
  //***********************
  //HOUSES
  //***********************

  val house1 = House().apply {
    name = "Casa de cris"
    residents = listOf(cris)
    inventory = listOf(bowSlot)
    image = "aragorn_house.jpg"
  }

  val house2 = House().apply {
    name = "Refugio de mati"
    residents = listOf(mati)
    inventory = listOf(ringSlot)
    image = "legolas_house.jpg"
  }

  val house3 = House().apply {
    name = "Casa de juana"
    residents = listOf(juana)
    inventory = listOf(pantrySlot)
    image = "frodo_house.jpg"
  }

  val house4 = House().apply {
    name = "Casa Comunal de la Comarca"
    image = "comarca.jpg"
  }

  fun linkLocationsToTerritories() {
    torre.subLocations = listOf(house1, house2)
    desierto.subLocations = listOf(tienda3, tienda4, tienda5, house3)
    bosque.subLocations = listOf(tienda, tienda2)
  }

  fun createHouses() {
    placeRepository.apply {
      create(house1)
      create(house2)
      create(house3)
      create(house4)
    }

    logger.info("casas agregadas")
  }
  fun createStores() {

    placeRepository.apply {
      create(tienda)
      create(tienda2)
      create(tienda3)
      create(tienda4)
      create(tienda5)
    }


    logger.info("tiendas agregadas")
  }
  fun createItems() {
    itemRepository.apply {
      create(espadaMagica)
      create(escudoHierro)
      create(bowSlot.item)
      create(ringSlot.item)
      create(pantrySlot.item)
      create(mesa.item)
      create(cascoSlot.item)
    }
    logger.info("items agregados")
  }

  fun createUsers() {
    userRepository.apply {
      create(valen)
    }
    logger.info("usuarios agregados")
  }

  fun createIndividuals() {
    individualRepository.apply {
      create(cris)
      create(juana)
      create(mati)
      create(albertoComerciante)
    }
    logger.info("individuos agregados")
  }

  fun createTerritories() {
    territoryRepository.apply {
      create(torre)
      create(desierto)
      create(bosque)
    }
    logger.info("territorios agregados")
  }

  override fun afterPropertiesSet() {
    this.createStores()
    this.createHouses()
    this.linkLocationsToTerritories()
    this.createTerritories()
    this.createUsers()
    this.createIndividuals()
    this.createItems()
  }
}