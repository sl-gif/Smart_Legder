package com.example.mytestapplication.domain.model

import android.util.Log
import androidx.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

object TimeConverter {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

  @TypeConverter
  @JvmStatic
  fun toOffsetDateTime(value: String?): OffsetDateTime? {
      val result = value?.let {
          //LocalDateTime.ofInstant(Instant.ofEpochMilli(value),ZoneOffset.UTC)
           formatter.parse(value, OffsetDateTime::from.also {
            Log.d("OffsetDateTimeLog","${it.hashCode()} and ${it == null}")
          })
      }
      return result
  }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? {
        date?.also{
        //    Log.d("OffsetDateTimeeeeeeeee"," ${it == null} and $it")

        }

        return date?.format(formatter)
        //LocalDateTime.ofInstant(Instant.ofEpochMilli(value),ZoneOffset.UTC)

    }

}