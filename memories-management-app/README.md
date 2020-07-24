# VS Code
- lombok
- sonarlint

# Maven

settings.xml
    <profile>
        <id>randommemories</id>
        <properties>
            <sonar.host.url>HOST</sonar.host.url>
            <sonar.login>TOKEN</sonar.login>
        </properties>
    </profile>


./mvnw clean install
./mvnw -P randommemories sonar:sonar
