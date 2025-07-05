package ar.edu.unsam.phm.booststrap.builders

import ar.edu.unsam.phm.models.Item

class ItemBuilder {
    companion object {
        fun buildMock(name: String, image: String, description: String, price: Double, weight: Int): Item {
            return Item().apply {
                this.name = name
                this.image = image
                this.description = description
                this.price = price
                this.weight = weight
            }
        }
    }
}