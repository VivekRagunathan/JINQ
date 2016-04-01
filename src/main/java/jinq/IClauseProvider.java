package jinq;

import delegates.*;
import java.util.Comparator;

public interface IClauseProvider<T extends Comparable<T>> {

	Iterable<T> getWhereIterable(Iterable<T> source, Predicate<T> predicate);

	Iterable<T> getOrderByIterable(Iterable<T> source, Comparator<T> keySelector);

	Iterable<T> getSelectIterable(Iterable<T> source);

	<R /*extends Comparable<R>*/> Iterable<R> getSelectIterable(Iterable<T> source, Func<T, R> selector);

	<K extends Comparable<K>>
	IEnumerable<GroupByEntry<K, T>> getGroupByIterable(Iterable<T> source, Func<T, K> keySelector);

	<K extends Comparable<K>, E extends Comparable<E>>
	IEnumerable<GroupByEntry<K, E>> getGroupByIterable(
			Iterable<T> source,
			Func<T, K> keySelector,
			Func<T, E> elementSelector
	);
}
