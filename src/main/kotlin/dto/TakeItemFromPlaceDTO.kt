package ar.edu.unsam.phm.dto

class TakeItemFromPlaceDTO (
    val itemId: Long,
    val placeId: Long,
    val individualId: Long
) {
    override fun toString(): String {
        return "TakeItemFromPlaceDTO(itemId=$itemId, houseId=$placeId)"
    }
}