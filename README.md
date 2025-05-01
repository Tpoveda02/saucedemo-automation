# SauceDemo Automation

Este proyecto contiene pruebas automatizadas para el sitio [SauceDemo](https://www.saucedemo.com) utilizando Java, Gradle y Serenity BDD.

## ✅ Requisitos Previos

Asegúrate de tener instalado en tu sistema:

- **Java JDK 17** (o 11) – [Descargar JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Gradle 7.6+** (o usar el *wrapper* incluido en el proyecto)
- **Navegador Microsoft Edge**

> Puedes verificar tus versiones instaladas con los siguientes comandos:
java -version
gradle -v

📥 Clonar el Repositorio
git clone https://github.com/Tpoveda02/saucedemo-automation.git
cd saucedemo-automation

🚀 Ejecutar las Pruebas
./gradlew clean test aggregate

📊 Ver los Resultados
Una vez finalizada la ejecución, abre el reporte de Serenity:
start build/reports/serenity/index.html

🛠️ Tecnologías Usadas
Java 17
Gradle 7.6
Serenity BDD
JUnit
Selenium WebDriver

👤 Autor
Tpoveda02
