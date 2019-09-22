plugins {
    java
    war
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("javax:javaee-web-api:7.0")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1-m09")
    implementation("javax.servlet:javax.servlet-api:3.1.0")
    implementation("junit:junit:3.8.1")
}

tasks.war {
    archiveFileName.set("myapp.war")
}
