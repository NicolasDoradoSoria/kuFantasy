package ar.edu.unsam.phm.booststrap

import ar.edu.unsam.phm.booststrap.builders.*
import ar.edu.unsam.phm.dao.*
import ar.edu.unsam.phm.models.*
import ar.edu.unsam.phm.utils.IndividualRole
import ar.edu.unsam.phm.utils.enums.Difficulty
import ar.edu.unsam.phm.utils.enums.TerritoryFeature
import ar.edu.unsam.phm.utils.enums.TerritoryType

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import org.slf4j.LoggerFactory
@Service
class DataInitializer : InitializingBean {

  @Autowired private lateinit var userRepository: UserRepository
  @Autowired private lateinit var individualRepository: IndividualRepository
  @Autowired private lateinit var territoryRepository: TerritoryRepository
  @Autowired private lateinit var itemRepository: ItemRepository
  @Autowired private lateinit var storeRepository: StoreRepository
  @Autowired private lateinit var houseRepository : HouseRepository
  @Autowired private lateinit var placeRepository: PlaceRepository
  @Autowired private lateinit var inventorySlotRepository: InventorySlotRepository
  @Autowired private lateinit var territoryResourceRepository: TerritoryResourceRepository
  @Autowired private lateinit var territoryInfoRepository: TerritoryInfoRepository
  @Autowired private lateinit var raceRepository: RaceRepository

  @Autowired(required = false) private lateinit var enemyRepository: EnemyRepository


  private val logger = LoggerFactory.getLogger(DataInitializer::class.java)

  //***********************
  // ITEM
  //***********************
  lateinit var arcoItem: Item
  lateinit var anilloItem: Item
  lateinit var panItem: Item
  lateinit var mesaItem: Item
  lateinit var espadaMagicaItem: Item
  lateinit var escudoHierro: Item
  lateinit var cascoItem: Item


  //***********************
  // Store
  //***********************
  lateinit var tienda: Store
  lateinit var tienda2: Store
  lateinit var tienda3: Store
  lateinit var tienda4: Store
  lateinit var tienda5: Store


  //***********************
  // TERRITORY
  //***********************

  val bosque = Territory().apply {
    name = "Bosque Encantado"
    history = "Un bosque misterioso lleno de magia."
    image = "bosque.jpg"
    overview = "gran bosque encantado"
    difficulty = Difficulty.MEDIUM
    level = 5
    type = TerritoryType.FOREST
    left = "20%"
    top = "60%"
  }

  val torre = Territory().apply {
    name = "Torre Arcana"
    history = "Una antigua torre de hechicería prohibida."
    image = "torre.jpg"
    overview = "torre magica simple"
    difficulty = Difficulty.HARD
    level = 10
    type = TerritoryType.TOWER
    left = "30%"
    top = "90%"
  }

  val desierto = Territory().apply {
    name = "Desierto del Olvido"
    history = "Nadie recuerda qué ocurrió aquí..."
    image = "desierto.jpg"
    overview = "desierto con gran cantidad de arena blanca"
    difficulty = Difficulty.EXTREME
    level = 15
    type = TerritoryType.DESERT
    left = "90%"
    top = "20%"
  }

  //***********************
  //USERS
  //***********************
  lateinit var albertoComerciante: Individual
  lateinit var cris: Individual
  lateinit var mati: Individual
  lateinit var juana: Individual
  lateinit var valen: User


  //***********************
  //HOUSES
  //***********************

  lateinit var house1: House
  lateinit var house2: House
  lateinit var house3: House
  lateinit var house4: House

  //***********************
  //RACE
  //***********************
  lateinit var orc: Race
  lateinit var elf: Race
  lateinit var human: Race
  lateinit var dwarf: Race
  lateinit var gnome: Race


  fun linkLocationsToTerritories() {
    torre.subLocations = mutableListOf(house1, house2)
    desierto.subLocations = mutableListOf(tienda3, tienda4, tienda5, house3)
    bosque.subLocations = mutableListOf(tienda, tienda2)
  }

  fun createRace() {
    orc = Race().apply {
      name = "Orc"
      description = "Strong but not very smart. High attack and life, low magic."
      imageUrl = "http://localhost:9090/orco.jpg"
      colorTheme = ColorTheme().apply {
        primaryColor = "#4E5F3D"
        secondaryColor = "#7A8F55"
        bgColor= "from-red-50 to-orange-50"
      }
      attack = 80
      defense = 60
      speed = 40
      magic = 10
      life = 150
      level = 1
    }

    elf = Race().apply {
      name = "Elf"
      description = "Graceful and intelligent. High magic and speed, low life."
      imageUrl = "http://localhost:9090/elfo.png"
      colorTheme = ColorTheme().apply {
        primaryColor = "#A1E6C1"
        secondaryColor = "#2A6F52"
        bgColor = "from-green-50 to-emerald-50"
      }
      attack = 40
      defense = 30
      speed = 90
      magic = 100
      life = 80
      level = 1
    }

    human = Race().apply {
      name = "Human"
      description = "Balanced race. Jack of all trades, master of none."
      imageUrl = "http://localhost:9090/human.jpg"
      colorTheme = ColorTheme().apply {
        primaryColor = "#F5D7B5"
        secondaryColor = "#A9744F"
        bgColor= "from-blue-50 to-indigo-50"
      }
      attack = 60
      defense = 60
      speed = 60
      magic = 60
      life = 100
      level = 1
    }

    dwarf = Race().apply {
      name = "Dwarf"
      description = "Sturdy and resistant. High defense and life, low speed."
      imageUrl = "http://localhost:9090/enano.png"
      colorTheme = ColorTheme().apply {
        primaryColor = "#B78C4D"
        secondaryColor = "#5D3A00"
        bgColor= "from-amber-50 to-yellow-50"
      }
      attack = 50
      defense = 90
      speed = 30
      magic = 40
      life = 130
      level = 1
    }

    gnome = Race().apply {
      name = "Gnome"
      description = "Clever and fast. High speed and magic, low attack."
      imageUrl = "http://localhost:9090/ghomo.jpg"
      colorTheme = ColorTheme().apply {
        primaryColor = "#9E8FB2"
        secondaryColor = "#5C5270"
        bgColor= "from-purple-50 to-pink-50"
      }
      attack = 30
      defense = 40
      speed = 95
      magic = 90
      life = 70
      level = 1
    }

    raceRepository.saveAll(listOf(orc, elf, human, dwarf, gnome))
    logger.info("✅ Races initialized")

  }

  fun createHouses() {
    house1 = HouseBuilder.buildMock(
      name = "Casa de Cristian",
      image = "aragorn_house.jpg",
      residents = listOf(),
      inventoryItems = listOf()
    )
    house2 = HouseBuilder.buildMock(
      name = "Refugio de Matías",
      image = "legolas_house.jpg",
      residents = listOf(),
      inventoryItems = listOf()
    )
    house3 = HouseBuilder.buildMock(
      name = "Casa de Juana",
      image = "frodo_house.jpg",
      residents = listOf(),
      inventoryItems = listOf()
    )
    house4 = HouseBuilder.buildMock(
      name = "Casa Comunal de la Comarca",
      image = "comarca.jpg",
      residents = listOf(),
      inventoryItems = listOf()
    )


    placeRepository.saveAll(listOf(house1, house2, house3, house4))

    logger.info("✅ casas agregadas")
  }
  fun createStores() {
    tienda = StoreBuilder.buildMock(
      name = "Tienda de Armas",
      seller = albertoComerciante,
      image = "legolas_house.jpg",
      inventoryItems = listOf(espadaMagicaItem to 1, escudoHierro to 1)
    )

    tienda2 = StoreBuilder.buildMock(
      name = "Tienda de Arcos",
      seller = albertoComerciante,
      image = "legolas_house.jpg",
      inventoryItems = listOf(arcoItem to 1)
    )
    tienda3 = StoreBuilder.buildMock(
      name = "Tienda de Anillos",
      seller = albertoComerciante,
      image = "legolas_house.jpg",
      inventoryItems = listOf(anilloItem to 1)
    )
    tienda4 = StoreBuilder.buildMock(
      name = "Tienda de Comida",
      seller = albertoComerciante,
      image = "legolas_house.jpg",
      inventoryItems = listOf(panItem to 10)
    )
    tienda5 = StoreBuilder.buildMock(
      name = "Tienda de Muebles",
      seller = albertoComerciante,
      image = "legolas_house.jpg",
      inventoryItems = listOf(mesaItem to 5)
    )

    placeRepository.saveAll(listOf(tienda, tienda2, tienda3, tienda4, tienda5))
    logger.info("tiendas agregadas")
  }
  fun createItems() {

    arcoItem = ItemBuilder.buildMock(
      name = "Arco Élfico",
      image = "arco.jpg",
      description = "Arco preciso y liviano",
      price = 120.0,
      weight = 5
    )
    anilloItem = ItemBuilder.buildMock(
      name = "Anillo de Invisibilidad",
      image = "anillo.jpg",
      description = "Te hace invisible por unos segundos",
      price = 300.0,
      weight = 1
    )
    panItem = ItemBuilder.buildMock(
      name = "Pan de la Comarca",
      image = "pan.jpg",
      description = "Muy nutritivo y sabroso",
      price = 5.0,
      weight = 2
    )
    mesaItem = ItemBuilder.buildMock(
      name = "Mesa",
      image = "mesa.jpg",
      description = "Mesa muy pesada",
      price = 5.0,
      weight = 2
    )
    espadaMagicaItem = ItemBuilder.buildMock(
      name = "Espada Mágica",
      image = "espada.jpg",
      description = "Una espada con poder arcano",
      price = 150.0,
      weight = 10
    )
    escudoHierro = ItemBuilder.buildMock(
      name = "Escudo de Hierro",
      image = "escudo.jpg",
      description = "Un escudo resistente",
      price = 100.0,
      weight = 15
    )
    cascoItem = ItemBuilder.buildMock(
      name = "Casco de Hierro",
      image = "casco.jpg",
      description = "Un casco resistente",
      price = 50.0,
      weight = 5
    )

    itemRepository.saveAll(listOf(espadaMagicaItem, escudoHierro, cascoItem, arcoItem, anilloItem, panItem, mesaItem))
  }

  fun createUsers() {
    valen = UserBuilder.buildMock("valen", "valen@example.com", torre, inventoryItems = listOf(espadaMagicaItem to 1, escudoHierro to 1))
    userRepository.saveAll(listOf(valen))
    logger.info(" ✅usuarios agregados")
  }

  fun createTerritoryInfos() {
    val bosqueInfo = TerritoryInfo().apply {
      shortDescription = "Un lugar magico donde lso arboles susurran."
      longDescription = "EL Bosque esta encantado desde hace siglos. los elfos y criatiras misticas lo habitan."
      features = listOf(TerritoryFeature.MAGIC_ZONE, TerritoryFeature.SAFE)
      lore = "Durante la guerra antigua, el bosque protegio a los refugiados magicos."
      territory = bosque
    }

    val torreInfo = TerritoryInfo().apply {
      shortDescription = "Torre que irradia energía oscura."
      longDescription = "Abandonada hace mil años, ahora vuelve a activarse lentamente..."
      features = listOf(TerritoryFeature.MAGIC_ZONE, TerritoryFeature.TRADE_CENTER)
      lore = "Lugar donde se selló al último archimago oscuro."
      territory = torre
    }

    val desiertoInfo = TerritoryInfo().apply {
      shortDescription = "Territorio olvidado por el tiempo."
      longDescription = "El sol quema sin piedad y las dunas esconden secretos."
      features = listOf(TerritoryFeature.DANGEROUS, TerritoryFeature.HISTORICAL_SITE)
      lore = "Aquí se libró la batalla final entre humanos y demonios."
      territory = desierto
    }

    bosque.info = bosqueInfo
    torre.info = torreInfo
    desierto.info = desiertoInfo

    territoryInfoRepository.saveAll(listOf(bosqueInfo, torreInfo, desiertoInfo))
  }

  fun createTerritoryResources() {
    val bosqueResources = listOf(
      TerritoryResource().apply {
        name = "Hierba magica"
        rarity = 2
        territory = bosque
      },
      TerritoryResource().apply {
        name = "madera encantada"
        rarity = 3
        territory = bosque
      }
    )

    val torreResources = listOf(
      TerritoryResource().apply {
        name = "Cristal arcano"
        rarity = 5
        territory = torre
      }
    )

    val desiertoResources = listOf(
      TerritoryResource().apply {
        name = "Fragmento de obsidiana"
        rarity = 4
        territory = desierto
      },
      TerritoryResource().apply {
        name = "Arena magica"
        rarity = 1
        territory = desierto
      }
    )

    territoryResourceRepository.saveAll(bosqueResources + torreResources + desiertoResources)

    logger.info(" ✅ resources agregados")
  }

  fun createIndividuals() {
    val slotCasco = InventorySlot.create(cascoItem, 1)
    val slotArco = InventorySlot.create(arcoItem, 1)
    val slotAnillo = InventorySlot.create(anilloItem, 1)
    val slotPan = InventorySlot.create(panItem, 10)
    val slotEspada = InventorySlot.create(espadaMagicaItem, 1)
    val slotEscudo = InventorySlot.create(escudoHierro, 1)
    val slotPanItem = InventorySlot.create(panItem, 10)

    albertoComerciante = IndividualBuilder.buildMock(
      name = "Alberto",
      role = IndividualRole.MERCHANT,
      locacion = desierto,
      inventorySlots = listOf(slotCasco),
      balance = 1000.0
    )
    cris = IndividualBuilder.buildMock(
      name = "Cristian",
      role = IndividualRole.COMMON,
      locacion = desierto,
      inventorySlots = listOf(slotArco, slotAnillo, slotPan),
      balance = 500.0
    )
    mati = IndividualBuilder.buildMock(
        name = "Matías",
        role = IndividualRole.COMMON,
        locacion = desierto,
        inventorySlots = listOf(slotEspada, slotEscudo),
        balance = 800.0
    )
    juana = IndividualBuilder.buildMock(
      name = "Juana",
      role = IndividualRole.COMMON,
      locacion = desierto,
      inventorySlots = listOf(slotPanItem),
      balance = 200.0
    )

    individualRepository.saveAll(listOf(albertoComerciante, cris, mati, juana))

    //albertoComerciante.inventory.add(cascoSlot)
    individualRepository.save(albertoComerciante)
    logger.info("✅ individuos agregados")
  }

  fun createTerritories() {
    territoryRepository.saveAll(listOf(torre, desierto, bosque))
    logger.info("✅ territorios agregados")
  }

  fun createEnemies() {
    val orco = Enemy().apply {
      type = "orc"
      name = "Orco"
      expReward = 50
      territory = bosque
      attack = 10
      defense = 5
      life = 30
      speed = 3
      level = 1
    }

    val espectro = Enemy().apply {
      type = "ghost"
      name = "Espectro"
      expReward = 100
      territory = torre
      attack = 15
      defense = 3
      life = 40
      speed = 6
      level = 2
    }
    bosque.enemies.add(orco)
    torre.enemies.add(espectro)

    enemyRepository.saveAll(listOf(orco, espectro))
  }

  private fun cleanDatabase() {
    userRepository.deleteAll()
    storeRepository.deleteAll()
    individualRepository.deleteAll()
    inventorySlotRepository.deleteAll()
    placeRepository.deleteAll()
    itemRepository.deleteAll()
    territoryRepository.deleteAll()
    territoryInfoRepository.deleteAll()
    territoryResourceRepository.deleteAll()
    if (::enemyRepository.isInitialized) enemyRepository.deleteAll()
  }

  override fun afterPropertiesSet() {
    cleanDatabase()
    this.createItems()
    this.createTerritories()
    this.createEnemies()
    this.createTerritoryInfos()
    this.createTerritoryResources()
    this.createIndividuals()
    this.createRace()
    this.createUsers()
    this.createStores()
    this.createHouses()
    this.linkLocationsToTerritories()

  }
}