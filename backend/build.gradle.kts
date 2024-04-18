plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.jooq.jooq-codegen-gradle") version "3.19.7"
}

group = "me.piguy.inholland"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

sourceSets {
	main {
		java {
			// include jooq generated files in the project
			srcDir("build/generated-sources/jooq")
		}
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Sql and most of the model later
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	// spring by default selects an older version, so I manually select this
	implementation("org.jooq:jooq:${project.properties["jooq_version"]}")
	runtimeOnly("com.h2database:h2")
	// make the driver available during codegen
	jooqCodegen("com.h2database:h2")

	// Swagger UI/OpenAPI spec generation
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${project.properties["springdoc_version"]}")

	// devtools for hot reload
	compileOnly("org.springframework.boot:spring-boot-devtools")

	// Unit testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jooq {
	configuration {
		logging = org.jooq.meta.jaxb.Logging.WARN
		jdbc {
			driver = "org.h2.Driver"
			url = "jdbc:h2:$projectDir/db/devel;AUTO_SERVER=TRUE"
			user = "sa"
			password = ""
		}
		generator {
			database {
				name = "org.jooq.meta.h2.H2Database"
				inputSchema = "PUBLIC"
			}
			generate {
				withPojos(true)
			}
			target {
				packageName = "${project.group}"
			}
		}
	}
}