import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.convertStringOfSizeToMegaByte() =
    when (this[this.lastIndex]){
        'M' -> this.replace("M", "").toDouble()
        'K' -> this.replace("K", "").toDouble() / 1024.0
        'G' -> this.replace("G", "").toDouble() * 1024.0
        else -> 0.0
    }

fun String.convertStringToLocalDate(): LocalDate {
    return LocalDate.parse(this, DateTimeFormatter.ofPattern("MMMM d yyyy"))
}