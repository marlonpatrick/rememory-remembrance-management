package io.mpwtech.rememory.remembrancemanagement.mongo;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

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
