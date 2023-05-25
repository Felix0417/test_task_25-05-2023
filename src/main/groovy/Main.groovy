package main.groovy

import groovy.transform.CompileStatic

import java.util.stream.Collectors

//Предварительно необходимо выполнить тестовое задание с помощью языка Java и Groovy:
//
//Подсчитать количество всех элементов списка/массива и вернуть ассоциативных массив,
// где ключ – элемент списка, значение – количество этих элементов в списке. Порядок не имеет значения.
//
//Пример: [1, 3, 4, 5, 1, 5, 4] -> {1 : 2, 3 : 1, 4 : 2, 5 : 2}

static void main(String[] args) {
    List<Integer> list = List.of(1, 3, 4, 5, 1, 5, 4)

    //способ со стримом
    println list.stream()
            .collect(Collectors.groupingBy({ it }, Collectors.counting()))

    println "--------------------"

    //способ с циклом
    println groupingAndCountingList(list)
}

@CompileStatic
static Map<Integer, Integer> groupingAndCountingList(List<Integer> list) {
    HashMap<Integer, Integer> map = [:]

    for (def x in list) {
        map.merge(x, 1, (y, z) -> ++z)
    }

    return map as Map<Integer, Integer>
}
