package dev.alyxia.portal_app.lib

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
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
