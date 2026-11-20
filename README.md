# Estructura de Datos

## 2.1.1 Ordenamiento directo · Java

**Autor del material:** Ing. Pablo Torres, Mgtr.
**Unidad 4:** Ordenamiento, búsqueda y recursividad
**Estudiante:** Evelyn Mayancela

---

## Descripción

Programa en Java que compara cuánto se demoran 5 formas de ordenar números, con 10.000, 50.000 y 100.000 elementos:

1. Burbuja
2. Merge Sort
3. `Arrays.sort` sobre `int[]`
4. `Arrays.sort` con `Comparator` sobre `Integer[]`
5. `Collectors` sobre `Integer[]`

Cada método ordena una copia del mismo arreglo y el resultado se compara con `Arrays.sort`.

## Clases

- `App`: corre las pruebas e imprime los tiempos.
- `Generador`: crea los arreglos con números al azar.
- `Metodos`: tiene los métodos de ordenamiento.
- `Benchmark`: mide el tiempo con `System.nanoTime()`.
- `Results`: guarda el nombre, el tiempo y el tamaño de cada prueba.

## Cómo ejecutar

Abrir el proyecto en VS Code y correr la clase `App`. En la consola salen los tiempos de cada método. La burbuja con 100.000 elementos se demora varios segundos.

## Resultados

Tiempos en segundos:

| Método | 10.000 | 50.000 | 100.000 |
|---|---|---|---|
| Burbuja | 0,0336 | 1,4793 | 7,7439 |
| Merge Sort | 0,0016 | 0,0069 | 0,0459 |
| Arrays.sort | 0,0012 | 0,0031 | 0,0060 |
| Arrays.sort Comparator | 0,0061 | 0,0117 | 0,0299 |
| Collectors | 0,0135 | 0,0327 | 0,0287 |

El detalle está en [investigacion.md](investigacion.md).