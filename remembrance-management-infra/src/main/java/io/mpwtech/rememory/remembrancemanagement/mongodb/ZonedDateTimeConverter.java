package io.mpwtech.rememory.remembrancemanagement.mongodb;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;


@ReadingConverter
final class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {

    public static final DateToZonedDateTimeConverter INSTANCE = new DateToZonedDateTimeConverter();

    private DateToZonedDateTimeConverter() {
    }

    @Override
    public ZonedDateTime convert(Date date) {
        return date.toInstant().atZone(ZoneOffset.UTC);
    }
}


@WritingConverter
final class ZonedDateTimeToDateConverter implements Converter<ZonedDateTime, Date> {

    public static final ZonedDateTimeToDateConverter INSTANCE = new ZonedDateTimeToDateConverter();

    private ZonedDateTimeToDateConverter() {
    }

    @Override
    public Date convert(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }
}
