# VS Code
- lombok

- sonarlint
    User Settings

    "sonarlint.connectedMode.connections.sonarcloud": [
        {
            "connectionId": "my-id",
            "organizationKey": "org",
            "token": "token",
        }
    ],
    "sonarlint.connectedMode.project": {
        "connectionId": "my-id",
        "projectKey": "io.mpwtech.randommemories:memories-management"
    }


# Maven

settings.xml
    <profile>
        <id>randommemories</id>
        <properties>
            <sonar.host.url>HOST</sonar.host.url>
            <sonar.login>TOKEN</sonar.login>
            <sonar.organization>ORG</sonar.organization>
        </properties>
    </profile>


./mvnw clean install
./mvnw -P randommemories verify sonar:sonar
./mvnw -P dev -pl memories-management-rest -am spring-boot:run


# a conexão padrão é mongodb://mongo:mongo@localhost:27017/admin
# onde o usuario e senha estão definidos nas variaveis de ambiente
# MONGO_INITDB_ROOT_USERNAME=mongo
# MONGO_INITDB_ROOT_PASSWORD=mongo
docker-compose -f docker/compose.base.yml -f docker/compose.dev.yml down
docker-compose -f docker/compose.base.yml -f docker/compose.dev.yml up -d
