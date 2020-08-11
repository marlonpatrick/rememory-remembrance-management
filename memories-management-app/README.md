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


docker-compose -f docker/compose.base.yml -f docker/compose.dev.yml up -d rm-memories-mngmt-mongodb

