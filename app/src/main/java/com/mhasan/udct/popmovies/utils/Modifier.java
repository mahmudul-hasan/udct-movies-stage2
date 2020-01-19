package com.mhasan.udct.popmovies.utils;

/**
 * This is the interface that is used to create a concrete modifier class that modifies a subject.
 *
 * @param <S> is the subject to be modified.
 * @author Mahmudul Hasan.
 */
public interface Modifier<S> {

	void modify(S subject);

}
