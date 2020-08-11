package io.mpwtech.randommemories.memoriesmanagement.mongo;

import java.time.ZonedDateTime;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

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
