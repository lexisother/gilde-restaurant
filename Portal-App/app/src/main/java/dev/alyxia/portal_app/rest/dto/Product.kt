package dev.alyxia.portal_app.rest.dto


import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object LocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(DateTimeFormatter.ISO_DATE.format(value))
    }

    override fun deserialize(decoder: Decoder): LocalDate =
        LocalDate.parse(decoder.decodeString())
}

//typealias ProductList = Map<String, ApiProduct>
typealias ProductList = List<ApiProduct>

@Serializable
data class ApiProduct(
    @Serializable(with = LocalDateSerializer::class)
    val created_at: LocalDate,
    @Serializable(with = LocalDateSerializer::class)
    val updated_at: LocalDate,

    val name: String,
    val description: String,
    val price: Double
)