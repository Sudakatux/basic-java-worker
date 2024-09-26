plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.orkes.conductor:orkes-conductor-client:2.1.1")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4")
    implementation ("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.4!!")
    implementation ("com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:2.11.4!!" )
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}