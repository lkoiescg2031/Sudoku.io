import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
}

group = "io.sudoku"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	all {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
	}
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// spring boot dependency 설정
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	// been validation
	implementation("org.springframework.boot:spring-boot-starter-validation:2.6.4")

	// kotlin dependency 설정
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// database dependency 설정
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.0")
	implementation("org.postgresql:postgresql:42.2.24")

	// logger 설정
	implementation("org.springframework.boot:spring-boot-starter-log4j2:2.5.6")
	implementation("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16")

	// swagger 설정
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	// spring boot test dependency 설정
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
