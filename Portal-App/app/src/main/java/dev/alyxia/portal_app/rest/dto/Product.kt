package dev.alyxia.portal_app.rest.dto

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Date) {
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
        val accessor = timeFormatter.parse(value.toString())
        encoder.encodeString(Date.from(Instant.from(accessor)).toString())
    }

    override fun deserialize(decoder: Decoder): Date {
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
        val accessor = timeFormatter.parse(decoder.decodeString())
        return Date.from(Instant.from(accessor))
    }
}

typealias ProductList = List<ApiProduct>

@Serializable
data class ApiProduct(
    @Serializable(with = DateSerializer::class)
    val created_at: Date,
    @Serializable(with = DateSerializer::class)
    val updated_at: Date,
    val id: Int,
    val name: String,
    val description: String,
    val price: Int
)