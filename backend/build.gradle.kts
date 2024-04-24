plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "me.piguy.inholland"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Swagger UI/OpenAPI spec generation
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${project.properties["springdoc_version"]}")

	// devtools for hot reload (disabled for now)
	// developmentOnly("org.springframework.boot:spring-boot-devtools")

	// Unit testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}