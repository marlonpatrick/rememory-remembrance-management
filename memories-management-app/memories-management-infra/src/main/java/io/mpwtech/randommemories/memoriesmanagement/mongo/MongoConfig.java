package io.mpwtech.randommemories.memoriesmanagement.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings.Builder;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions.MongoConverterConfigurationAdapter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import io.mpwtech.randommemories.memoriesmanagement.ComponentScanBasePackageClass;

@Configuration
@EnableMongoRepositories(basePackageClasses = {ComponentScanBasePackageClass.class})
class MongoClientConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private Environment environment;

    @Override
    protected String getDatabaseName() {
        return this.environment.getProperty("spring.data.mongodb.database");
    }

    @Override
    protected void configureClientSettings(Builder builder) {
        super.configureClientSettings(builder);

        builder.applicationName(this.environment.getProperty("spring.application.name"));

        builder.uuidRepresentation(UuidRepresentation.valueOf(this.environment
                .getProperty("spring.data.mongodb.uuid-representation").toUpperCase()));

        builder.applyConnectionString(
                new ConnectionString(this.environment.getProperty("spring.data.mongodb.uri")));
    }

    @Override
    protected boolean autoIndexCreation() {
        return Boolean
                .valueOf(this.environment.getProperty("spring.data.mongodb.auto-index-creation"));
    }

    @Override
    protected void configureConverters(MongoConverterConfigurationAdapter adapter) {
        adapter.registerConverter(DateToZonedDateTimeConverter.INSTANCE);
        adapter.registerConverter(ZonedDateTimeToDateConverter.INSTANCE);
    }

    /**
     * This method has been overridden to remove the configuration that writes the Java class
     * (_class) to the MongoDB document.
     */
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory,
            MongoCustomConversions customConversions, MongoMappingContext mappingContext) {

        MappingMongoConverter converter =
                super.mappingMongoConverter(databaseFactory, customConversions, mappingContext);

        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return converter;
    }
}
