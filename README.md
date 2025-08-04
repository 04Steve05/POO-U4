# Sistema de Gestión de Contenido Audiovisual

**Programación Orientada a Objetos - 2do Nivel**  
**Universidad Politécnica Salesiana**  
**Estudiante:** Jefferson Steve Tutillo Acero

## Descripción del Proyecto

Este es mi proyecto final de la Unidad 4 sobre Programación Limpia. Es un sistema que permite gestionar diferentes tipos de contenido audiovisual como películas, series de TV, documentales, podcasts y videoclips.

El programa aplica los conceptos que hemos visto en clase sobre código limpio, principios SOLID y arquitectura MVC. También guarda todos los datos en archivos CSV para que no se pierdan cuando cierras el programa.

## Cómo Ejecutar el Programa

### Requisitos
- Java 11 o superior
- Editor de código (VS Code, Eclipse, IntelliJ, etc.)

### Pasos para ejecutar

1. **Clona o descarga el proyecto**
```bash
git clone [tu-repositorio-url]
cd POO-U4
```

2. **Compila el programa**
```bash
javac -cp src src/Main.java
```

3. **Ejecuta el programa**
```bash
java -cp src src.Main
```

### Qué verás al ejecutar

```
════════════════════════════════════════════════════════════
    SISTEMA DE GESTIÓN DE CONTENIDO AUDIOVISUAL
════════════════════════════════════════════════════════════

Primera ejecución. Creando contenido de ejemplo...
Directorio creado: datos
Guardados 5 contenidos en: datos/contenidos.csv
Total de contenidos: 5

PELICULA
ID: 1 | Título: Avatar | Duración: 125 min | Género: Acción
Estudio: 20th Century Studios | Actores: Sam Worthington, Zoe Saldana

[... más contenidos ...]

Guardados 5 contenidos en: datos/contenidos.csv
Sistema finalizado. Datos guardados correctamente.
```

## Estructura del Proyecto

```
POO-U4/
├── src/
│   ├── modelo/                 # Clases de datos
│   │   ├── interfaces/        # Interfaces específicas
│   │   ├── factory/           # Factory Pattern
│   │   ├── ContenidoAudiovisual.java
│   │   ├── Pelicula.java
│   │   ├── SerieDeTV.java
│   │   ├── Documental.java
│   │   ├── Podcast.java
│   │   ├── Videoclip.java
│   │   ├── Actor.java
│   │   ├── Temporada.java
│   │   └── Investigador.java
│   ├── vista/                 # Interfaz de usuario
│   │   └── ConsolaVista.java
│   ├── controlador/           # Lógica de control
│   │   └── ContenidoControlador.java
│   ├── servicio/              # Servicios de archivos
│   │   ├── ArchivosServicio.java
│   │   └── CSVArchivosServicio.java
│   └── Main.java              # Punto de entrada
├── datos/
│   └── contenidos.csv         # Datos guardados (se crea automáticamente)
└── README.md
```

## Etapas del Desarrollo

### Etapa 1: Manejo de Archivos
- Implementé lectura y escritura de archivos CSV
- El programa crea automáticamente la carpeta "datos" si no existe
- Maneja errores cuando los archivos están dañados o no existen
- Guarda automáticamente cada vez que se hacen cambios

### Etapa 2: Refactorización y Código Limpio
- Mejoré los nombres de variables y métodos para que sean más claros
- Dividí métodos grandes en métodos más pequeños
- Eliminé código duplicado
- Organicé todo usando el patrón MVC (Modelo-Vista-Controlador)

### Etapa 3: Principios SOLID
- **SRP:** Cada clase tiene una sola responsabilidad
- **OCP:** Uso Factory Pattern para agregar nuevos tipos fácilmente
- **LSP:** Todas las subclases funcionan igual que la clase padre
- **ISP:** Interfaces específicas para cada funcionalidad
- **DIP:** El controlador depende de interfaces, no de clases concretas

### Etapa 4: Patrón MVC
- **Modelo:** Las clases de datos (Pelicula, SerieDeTV, etc.)
- **Vista:** ConsolaVista que maneja cómo se muestra todo
- **Controlador:** ContenidoControlador que coordina todo

## Tipos de Contenido

El sistema maneja 5 tipos diferentes:

**Películas**
- Título, duración, género
- Estudio productora
- Lista de actores principales

**Series de TV**
- Título, duración, género
- Número de temporadas
- Detalles de cada temporada

**Documentales**
- Título, duración, género
- Tema de investigación
- Lista de investigadores

**Podcasts**
- Título, duración, género
- Host del programa

**Videoclips**
- Título, duración, género
- Artista intérprete

## Cómo Funciona el Sistema

1. **Al iniciar:** El programa busca el archivo `datos/contenidos.csv`
2. **Si no existe:** Crea contenido de ejemplo automáticamente
3. **Si existe:** Carga todos los datos guardados
4. **Muestra todo:** Presenta el contenido de manera organizada
5. **Al terminar:** Guarda automáticamente cualquier cambio

## Archivos Importantes

### Main.java
Es donde empieza todo. Solo crea el controlador y lo ejecuta.

### ContenidoControlador.java
Es el cerebro del programa. Coordina todo:
- Carga los datos
- Los muestra usando la vista
- Los guarda cuando es necesario

### ConsolaVista.java
Se encarga de mostrar todo bonito en la consola con formatos organizados.

### ContenidoAudiovisual.java
Es la clase padre de todos los tipos de contenido. Define lo que todos tienen en común.

### CSVArchivosServicio.java
Maneja la lectura y escritura de archivos CSV. Es bastante complejo porque tiene que convertir objetos Java a CSV y viceversa.

## Características Técnicas

### Principios Aplicados
- **Código Limpio:** Nombres claros, métodos pequeños, sin duplicación
- **SOLID:** Los 5 principios aplicados correctamente
- **MVC:** Separación clara de responsabilidades
- **Factory Pattern:** Para crear objetos de manera controlada

### Manejo de Errores
- Si el archivo CSV está dañado, el programa no se cae
- Si no tiene permisos para escribir, muestra un error claro
- Si falta información, usa valores por defecto

### Extensibilidad
- Es fácil agregar nuevos tipos de contenido
- Se puede cambiar el formato de archivo (CSV a JSON) fácilmente
- Se puede agregar una interfaz gráfica sin cambiar el modelo

## Problemas que Tuve y Cómo los Resolví

### Problema 1: El programa se caía si no existía la carpeta "datos"
**Solución:** Programé que el sistema cree automáticamente la carpeta si no existe.

### Problema 2: Tenía mucho código repetido
**Solución:** Creé métodos comunes y los puse en la clase padre.

### Problema 3: Era difícil agregar nuevos tipos de contenido
**Solución:** Implementé el Factory Pattern para hacer esto más fácil.

### Problema 4: El código era difícil de entender
**Solución:** Apliqué principios de código limpio y organicé todo con MVC.

## Lo que Aprendí

- **Arquitectura de Software:** La importancia de organizar bien el código desde el principio
- **Principios SOLID:** Cómo aplicar estos conceptos teóricos en código real
- **Patrones de Diseño:** Factory Pattern y cómo hace el código más flexible
- **Código Limpio:** Técnicas para escribir código que otros puedan entender
- **MVC:** Cómo separar responsabilidades para tener código más mantenible

## Posibles Mejoras Futuras

- Agregar búsqueda y filtros
- Implementar una interfaz gráfica
- Soporte para más formatos de archivo (JSON, XML)
- Agregar más tipos de contenido (Audiolibros, Cursos online)
- Sistema de calificaciones y comentarios
- Base de datos en lugar de archivos CSV

## Notas para el Profesor

El proyecto demuestra el uso de:
- Los 5 principios SOLID aplicados correctamente
- Patrón MVC bien implementado
- Factory Pattern para extensibilidad
- Manejo robusto de archivos CSV
- Código limpio y bien documentado
- Estructura de proyecto profesional

Todo el código está comentado donde es necesario y sigue las convenciones de Java. El sistema es completamente funcional y está preparado para futuras extensiones.

---

**Desarrollado por:** Jefferson Steve Tutillo Acero  
**Curso:** Programación Orientada a Objetos  
**Universidad:** Universidad Politécnica Salesiana  
**Fecha:** 3 Agosto 2025