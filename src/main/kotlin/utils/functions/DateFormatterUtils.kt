package ar.edu.unsam.phm.utils.functions

import ar.edu.unsam.phm.utils.exceptions.IllegalDataException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

val DateWithDayFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

fun datifyStringWithDay(dateStr: String): LocalDate {
    return try {
        LocalDate.parse(dateStr, DateWithDayFormatter)
    } catch (e: DateTimeParseException) {
        throw IllegalDataException("La fecha no tiene el formato esperado dd/MM/yyyy")
    }
}