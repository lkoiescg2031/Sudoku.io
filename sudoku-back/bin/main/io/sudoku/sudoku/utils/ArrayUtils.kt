package io.sudoku.sudoku.utils

inline fun <K, V> List<V>.groupByIndexed(keySelector: (Int, V) -> K): Map<K, List<V>>
= this.withIndex().groupBy({ (index, value) -> keySelector(index, value) }) { it.value }