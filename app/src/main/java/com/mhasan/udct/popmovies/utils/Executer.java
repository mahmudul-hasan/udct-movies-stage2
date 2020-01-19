package com.mhasan.udct.popmovies.utils;

/**
 * This is the interface to create the concrete executer class that does (or executes) some operations
 * on a given subject.
 *
 * @param <S> is the given subject on which the operation is executed.
 * @author Mahmudul Hasan.
 */
public interface Executer<S> {

	void execute(S subject);

}
