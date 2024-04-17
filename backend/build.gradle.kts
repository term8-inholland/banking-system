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
	//implementation("org.projectlombok:lombok")


	// sql
	//implementation("org.springframework.boot:spring-boot-starter-jooq")
	//runtimeOnly("org.postgresql:postgresql")
	implementation("com.h2database:h2")

	// Swagger UI
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${project.properties["springdoc_version"]}")

	// live reload
	//compileOnly("org.springframework.boot:spring-boot-devtools")

	// Unit testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}