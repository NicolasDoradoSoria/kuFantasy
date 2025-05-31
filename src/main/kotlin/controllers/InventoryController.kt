package ar.edu.unsam.phm.controllers


import ar.edu.unsam.phm.service.InventoryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
class InventoryController(
  val inventoryService: InventoryService
) {


}