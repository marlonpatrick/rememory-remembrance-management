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
            <sonar.organization>ORG</sonar.organization>
            <sonar.projectKey>PROJECTKEY</sonar.projectKey>
        </properties>
    </profile>


./mvnw clean install
./mvnw -P randommemories verify sonar:sonar
