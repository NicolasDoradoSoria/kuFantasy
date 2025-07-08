package ar.edu.unsam.phm.controllers

import ar.edu.unsam.phm.service.ItemService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
  val itemService: ItemService
) {

}